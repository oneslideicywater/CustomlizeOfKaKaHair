package com.oneslide.RestfulCheck.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Customer {


	public Customer() {
	}
	

   
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private int age;
	private boolean gender;
	private double stature;
	private double weight;
	private String complexion;
	private String somatotype;
	private String feature;
	
	private String nickname;
	private String headImageURL;
	private long openid;
	//油性程度
    private int HairOilness;
		
		//软硬程度
    private int HairToughness;
		
		//发量
	private int HairVolume;
		
		//喜欢的风格
	private String FavorStyle;
	
	//还有其他风格
	
	
	

	


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	

	public double getStature() {
		return stature;
	}

	public void setStature(double stature) {
		this.stature = stature;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getComplexion() {
		return complexion;
	}

	public void setComplexion(String complexion) {
		this.complexion = complexion;
	}

	public String getSomatotype() {
		return somatotype;
	}

	public void setSomatotype(String somatotype) {
		this.somatotype = somatotype;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public int getHairOilness() {
		return HairOilness;
	}

	public void setHairOilness(int hairOilness) {
		HairOilness = hairOilness;
	}

	public int getHairToughness() {
		return HairToughness;
	}

	public void setHairToughness(int hairToughness) {
		HairToughness = hairToughness;
	}

	public int getHairVolume() {
		return HairVolume;
	}

	public void setHairVolume(int hairVolume) {
		HairVolume = hairVolume;
	}

	public String getFavorStyle() {
		return FavorStyle;
	}

	public void setFavorStyle(String favorStyle) {
		FavorStyle = favorStyle;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadImageURL() {
		return headImageURL;
	}

	public void setHeadImageURL(String headImageURL) {
		this.headImageURL = headImageURL;
	}

	public long getOpenid() {
		return openid;
	}

	public void setOpenid(long openid) {
		this.openid = openid;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	



	

	
}
