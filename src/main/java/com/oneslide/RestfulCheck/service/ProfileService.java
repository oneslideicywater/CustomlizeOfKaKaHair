package com.oneslide.RestfulCheck.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneslide.RestfulCheck.entity.Customer;
import com.oneslide.RestfulCheck.entity.Profile;
import com.oneslide.RestfulCheck.repository.ProfileRepository;

@Service
public class ProfileService {
   
	public ProfileService() {
		super();
	}

	public ProfileService(ProfileRepository profileRepository) {
		super();
		this.profileRepository = profileRepository;
	}

	@Autowired
	ProfileRepository profileRepository;
	
	//筛选算法，通过性别，风格，脸型
	public List<Profile> select(boolean gender,String style,String feature){
	     List<Profile> list=profileRepository.QulifiedV1(gender, style, feature);
	     
	     if(list.size()<=5) {
	         //放宽条件进行查询
	    	 //二级筛选
	    	 list=profileRepository.QulifiedV2(gender, feature);
	    	 if(list.size()<=5) {
	    		  
	    		 //三级筛选
	    		 list=profileRepository.findByGender(gender);
	    		  if(list.size()<=5) {
	    			  return list;
	    		  }else {
	    			  return this.truncateProfile(list);
	    		  }
	    		  
	    		  
	    	 }else {
	    		 return this.truncateProfile(list);
	    	 }
	     }else{
	    	 return this.truncateProfile(list);
	     }
	     
		 
	}
	
	//修剪大于5个的集合
	private List<Profile> truncateProfile(List<Profile> list){
		List<Profile> listtemp=new ArrayList<Profile>();
		for(int i=0;i<5;i++) {
			 int temp=(int) Math.floor(Math.random()*list.size());
			 listtemp.add(list.get(temp));
			 list.remove(temp);
		}
		
		return listtemp;
	}
	
	
	
	
	
	
	//存储一个空profile,返回id
	public long getImageFileName() {
		Profile profiletemp=new Profile();
		Profile profile=profileRepository.save(profiletemp);
		long ident=profile.getId();
		return ident;
		
	}
	
	public void saveProfile(Profile p) {
		profileRepository.save(p);
	}
	
	
	public Profile findProfileById(long id) {
		return profileRepository.findById(id);
	}
	
	public List<Profile> all() {
		return profileRepository.findAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
