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
	
	//筛选算法
	public List<Profile> select(Customer customer,String depict){
		 List<Profile> list=profileRepository.findAllQulified(customer.isGender(),customer.getStyle());
		//筛选算法
		/** if(list.size()>=5) {
			 return list;
		 }else {
			 List<Profile> listtemp=new ArrayList<>(); 
			 int m=list.size();
			 while(listtemp.size()<=5) {
			     long selectpro=(long)Math.random()*m;
			     if(!listtemp.contains(profileRepository.findById(selectpro))) {
			    	 listtemp.add(profileRepository.findById(selectpro));
			     }
			 }			 
			 return listtemp;
		 }**/
		 return list;
	}
	
	
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
