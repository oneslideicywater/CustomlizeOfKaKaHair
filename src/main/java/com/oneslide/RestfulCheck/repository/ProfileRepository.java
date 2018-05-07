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
    //严格注意空格，换行 ,会自动默认gender为boolean类型
	@Query("select pro from Profile pro where "
			+ "pro.gender=?#{[0]} "
			+ "and pro.style=?#{[1]} "
			+ "and pro.feature=?#{[2]}")
	List<Profile> Qulified(boolean gender,String style,String feature);
    
	List<Profile> findByGender(boolean gender);
	
	//List<Profile> findByGenderAndStyle(int gender,String style);
	
	Profile findById(long selectpro);
	List<Profile> findAll();
}
