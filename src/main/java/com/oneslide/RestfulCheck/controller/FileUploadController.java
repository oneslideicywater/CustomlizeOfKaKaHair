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

    @GetMapping(path="/JoinUsWithFileUpload")
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
        //load file as Resource with file name
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
   
    @Transactional
    @PostMapping("/HandleFileUpload")
    public String handleFileUpload(
    		@RequestParam("file") MultipartFile file,
    		@RequestParam("gender")String gender,
    		@RequestParam("style")String style,
    		@RequestParam("feature")String feature, //脸型
            RedirectAttributes redirectAttributes) {
        //这里执行一些操作
    	//获取待存储图片在数据库中的Id
    	//异常检测
    	if(gender.isEmpty()||style.isEmpty()||feature.isEmpty()) {
    		redirectAttributes.addFlashAttribute("message",
                    "invalid Parameter,you may be miss some Input" + "!");
    		System.out.println("I am executed to check parameter!");
    		return "redirect:/JoinUsWithFileUpload";
    	}
    	if(file.isEmpty()) {
    		redirectAttributes.addFlashAttribute("message",
                    "You haven't choose uploaded " + "File" + "!");
    		return "redirect:/JoinUsWithFileUpload";
    	}
    	long fCandidate=profileService.getImageFileName();
        
    	//按照数据库Profile ID命名上传的图片
        storageService.store(file,fCandidate);
        //从数据库中获取Profile对象，便于存储
        Profile profile=profileService.findProfileById(fCandidate);
        
        //合成合理的图片路径，路径为，"已定义路径下/图片数据库ID.扩展名"
        StorageProperties p=new StorageProperties();
        int m=file.getOriginalFilename().split("\\.").length-1;
        String mString=""+p.getLocation()+"/"+fCandidate+"."
                       +file.getOriginalFilename().split("\\.")[m];
        
        //将格式化后图片路径保存至数据库
        profile.setImage(mString);
        
        //类型转换
        if(Integer.parseInt(gender)==1) {
        	profile.setGender(true);
        }else {
        	profile.setGender(false);
        }
        
        //解析用户输入表单信息
        
        //风格一共6种
      
         profile.setStyle(style);
      
         profile.setFeature(feature);
        //保存
        profileService.saveProfile(profile);
        
        
        
        
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + mString + "!");

        return "redirect:/JoinUsWithFileUpload";
    }

    //异常处理句柄：处理StorageFileNotFoundException,定义在storage包里
    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
