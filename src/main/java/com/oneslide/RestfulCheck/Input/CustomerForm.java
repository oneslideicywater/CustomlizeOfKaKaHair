package com.oneslide.RestfulCheck.Input;

public class CustomerForm {
   
	public CustomerForm() {
		super();
	}
	private long id;
	private long telephone;  
	private int age;
	private int gender;
	private double stature;  //身高
	private double weight;   //体重
	private String complexion; //肤色
	private String somatotype;  //体型
	private String feature;  //脸型
	private int hairQuality;  //发质
	private int hairVolume;   //发色
	
	private int style;   //风格
	private String description;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getTelephone() {
		return telephone;
	}
	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
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
	public int getHairQuality() {
		return hairQuality;
	}
	public void setHairQuality(int hairQuality) {
		this.hairQuality = hairQuality;
	}
	public int getHairVolume() {
		return hairVolume;
	}
	public void setHairVolume(int hairVolume) {
		this.hairVolume = hairVolume;
	}
	public int getStyle() {
		return style;
	}
	public void setStyle(int style) {
		this.style = style;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
