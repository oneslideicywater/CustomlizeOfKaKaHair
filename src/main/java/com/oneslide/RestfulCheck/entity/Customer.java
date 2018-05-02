package com.oneslide.RestfulCheck.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.oneslide.RestfulCheck.Input.CustomerForm;

@Entity
public class Customer {
	public Customer(long id, long telephone, boolean gender, double stature, double weight, String complexion,
			String somatotype, String feature, int hairQuality, int hairVolume) {
		super();
		this.id = id;
		this.telephone = telephone;
		this.gender = gender;
		this.stature = stature;
		this.weight = weight;
		this.complexion = complexion;
		this.somatotype = somatotype;
		this.feature = feature;
		this.hairQuality = hairQuality;
		this.hairVolume = hairVolume;
	}

	public Customer() {
	}
	

   
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private long telephone;
	private int age;
	private boolean gender;
	private double stature;
	private double weight;
	private String complexion;
	private String somatotype;
	private String feature;
	private int hairQuality;
	private int hairVolume;
	private int style;
	
    public static Customer transformIntoCustomer(CustomerForm input) {
    	Customer cus=new Customer();
    	cus.setAge(input.getAge());
    	cus.setTelephone(input.getTelephone());
    	cus.setGender(input.getGender()==1);
    	cus.setStature(input.getStature());
    	cus.setWeight(input.getWeight());
    	cus.setComplexion(input.getComplexion());
    	cus.setFeature(input.getFeature());
    	cus.setSomatotype(input.getSomatotype());
    	cus.setHairQuality(input.getHairQuality());
    	cus.setHairVolume(input.getHairVolume());
    	cus.setStyle(input.getStyle());
    	return cus;
    	
    }
	public long getTelephone() {
		return telephone;
	}

	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getStyle() {
		return style;
	}

	public void setStyle(int style) {
		this.style = style;
	}
}
