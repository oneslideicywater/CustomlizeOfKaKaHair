package com.oneslide.RestfulCheck.Input;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomerForm {


	public CustomerForm() {
		super();
	}

	//性别
	@NotNull
	private int gender;
	
	//年龄
	@NotNull
 
	private int age;
	@NotNull
	//身高
	
	private double stature;
	@NotNull
	//体重
	private double weight;
	@NotNull
	//肤色
	private String complexion;
	@NotNull
	//体型
	private String somatotype;
	@NotNull
	//脸型
	private String feature;
	@NotNull
	//油性程度
	@Min(value=1) @Max(value=3)
	private int hairOilness;
	@NotNull
	//软硬程度
	@Min(value=1) @Max(value=3)
	private int hairToughness;
	@NotNull
	//发量
	@Min(value=1) @Max(value=3)
	private int hairVolume;
	@NotNull
	//喜欢的风格
	@Size(min=1,max=3)
	private String favorStyle;

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

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
		return this.hairOilness;
	}

	public void setHairOilness(int hairOilness) {
		this.hairOilness = hairOilness;
	}

	public int getHairToughness() {
		return hairToughness;
	}

	public void setHairToughness(int hairToughness) {
		this.hairToughness = hairToughness;
	}


	public String getFavorStyle() {
		return favorStyle;
	}

	public void setFavorStyle(String favorStyle) {
		this.favorStyle = favorStyle;
	}

	public int getHairVolume() {
		return hairVolume;
	}

	public void setHairVolume(int hairVolume) {
		this.hairVolume = hairVolume;
	}



	
}
