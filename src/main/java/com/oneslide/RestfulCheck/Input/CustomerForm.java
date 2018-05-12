package com.oneslide.RestfulCheck.Input;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.oneslide.RestfulCheck.entity.Customer;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerForm {


	public CustomerForm() {
		super();
	}

	//性别
	@NotNull
	private boolean gender;
	
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
	@Size(min=1,max=5)
	private String favorStyle;


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

    public Customer convertToCustomer(Customer customer) {
    	customer.setAge(this.getAge());
    	customer.setStature(this.getStature()/100);
    	customer.setWeight(this.getWeight());
    	customer.setComplexion(this.getComplexion());
    	customer.setSomatotype(this.getSomatotype());
    	customer.setFeature(this.getFeature());
    	customer.setFavorStyle(this.getFavorStyle());
    	customer.setHairOilness(this.getHairOilness());
    	customer.setHairToughness(this.getHairToughness());
    	customer.setHairVolume(this.getHairVolume());
    	return customer;
    }

	public boolean getGender() {
		return this.gender;
	}

	public void setGender(boolean xingbie) {
		this.gender = xingbie;
	}

	@Override
	public String toString() {
		return "CustomerForm [gender=" + gender + ", age=" + age + ", stature=" + stature + ", weight=" + weight
				+ ", complexion=" + complexion + ", somatotype=" + somatotype + ", feature=" + feature
				+ ", hairOilness=" + hairOilness + ", hairToughness=" + hairToughness + ", hairVolume=" + hairVolume
				+ ", favorStyle=" + favorStyle + "]";
	}

	
}
