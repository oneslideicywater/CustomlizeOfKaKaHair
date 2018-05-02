package com.oneslide.RestfulCheck.controller;

import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oneslide.RestfulCheck.config.DBImage;
import com.oneslide.RestfulCheck.entity.Profile;
import com.oneslide.RestfulCheck.service.ProfileService;
import com.oneslide.RestfulCheck.storage.StorageFileNotFoundException;
import com.oneslide.RestfulCheck.storage.StorageProperties;
import com.oneslide.RestfulCheck.storage.StorageService;




@Controller
public class FileUploadController {

    public FileUploadController(StorageService storageService, ProfileService profileService) {
		super();
		this.storageService = storageService;
		this.profileService = profileService;
	}

	private final StorageService storageService;
    
    @Autowired
    ProfileService profileService;
    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                        "serveFile", path.getFileName().toString()).build().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }

    
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
   
    @Transactional
    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,@RequestParam("gender")String gender,
    		@RequestParam("style")String style,
            RedirectAttributes redirectAttributes) {
        //这里执行一些操作
    	//获取待存储图片在数据库中的Id
    	long fCandidate=profileService.getImageFileName();
        
        storageService.store(file,fCandidate);
        Profile profile=profileService.findProfileById(fCandidate);
        StorageProperties p=new StorageProperties();
        int m=file.getOriginalFilename().split("\\.").length-1;
        String mString=""+p.getLocation()+"/"+fCandidate+"."+file.getOriginalFilename().split("\\.")[m];
        profile.setImage(mString);
        
        if(Integer.parseInt(gender)==1) {
        	profile.setGender(true);
        }else {
        	profile.setGender(false);
        }
        profile.setStyle(Integer.parseInt(style));
        
        //保存
        profileService.saveProfile(profile);
        
        
        
        
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + mString + "!");

        return "redirect:/";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
