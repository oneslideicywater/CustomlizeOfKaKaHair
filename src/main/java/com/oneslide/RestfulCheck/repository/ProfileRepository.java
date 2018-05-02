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
  
	@Query("select pro from Profile pro where pro.gender=?#{[0]} and pro.style=?#{[1]}")
	List<Profile> findAllQulified(boolean gender,int style);

	Profile findById(long selectpro);
	List<Profile> findAll();
}
