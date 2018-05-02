package com.oneslide.RestfulCheck.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Profile {
    public Profile() {
		super();
	}

	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private long id;
	 
	 private boolean gender;// 1 male 0 female
	 @Basic
	 private String image;
	 private int style;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	public int getStyle() {
		return style;
	}

	public void setStyle(int style) {
		this.style = style;
	}

	
}
