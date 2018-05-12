package com.oneslide.RestfulCheck.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oneslide.RestfulCheck.entity.Profile;
@Repository
@Transactional
public interface ProfileRepository extends JpaRepository<Profile,Long>{
  
    
	
	/**
	 * @Query("from User user where user.email like %?1%")
	 * **/
	@Query("from Profile profile where profile.gender=?1"
			+ " and profile.style like %?2%"
			+ " and profile.feature=?3")
	List<Profile> QulifiedV1(boolean gender,String style,String feature);
	
	@Query("from Profile profile where profile.gender=?1"
			+ " and profile.feature=?2")
	List<Profile> QulifiedV2(boolean gender,String feature);
	
	
	List<Profile> findByGender(boolean gender);
	
	//List<Profile> findByGenderAndStyle(int gender,String style);
	
	Profile findById(long selectpro);
	List<Profile> findAll();
}
