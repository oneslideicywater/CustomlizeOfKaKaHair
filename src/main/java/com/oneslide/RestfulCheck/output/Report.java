package com.oneslide.RestfulCheck.output;

import java.util.List;

public class Report {
    
	public Report() {
		super();
	}


	//微信头像
	private String portraitURL;
	//年龄
	private String age;
	//身高
	private String stature;
	
	//体重
	private String weight;
	
	//BMI
	private double BMI;
	
	//不同BMI值得建议
	private String advice;
    //脸型
	private String featureURL;
	
	//推荐发型
	private List<String> haircutURL;
	
	
	//体型分析
	private String somatotypeURL;
	
	//肤色分析
	private String complexionURL;
	
	
	//头发护理
	private String hairMantainURL;


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(BMI);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((advice == null) ? 0 : advice.hashCode());
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((complexionURL == null) ? 0 : complexionURL.hashCode());
		result = prime * result + ((featureURL == null) ? 0 : featureURL.hashCode());
		result = prime * result + ((hairMantainURL == null) ? 0 : hairMantainURL.hashCode());
		result = prime * result + ((haircutURL == null) ? 0 : haircutURL.hashCode());
		result = prime * result + ((portraitURL == null) ? 0 : portraitURL.hashCode());
		result = prime * result + ((somatotypeURL == null) ? 0 : somatotypeURL.hashCode());
		result = prime * result + ((stature == null) ? 0 : stature.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Report other = (Report) obj;
		if (Double.doubleToLongBits(BMI) != Double.doubleToLongBits(other.BMI))
			return false;
		if (advice == null) {
			if (other.advice != null)
				return false;
		} else if (!advice.equals(other.advice))
			return false;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (complexionURL == null) {
			if (other.complexionURL != null)
				return false;
		} else if (!complexionURL.equals(other.complexionURL))
			return false;
		if (featureURL == null) {
			if (other.featureURL != null)
				return false;
		} else if (!featureURL.equals(other.featureURL))
			return false;
		if (hairMantainURL == null) {
			if (other.hairMantainURL != null)
				return false;
		} else if (!hairMantainURL.equals(other.hairMantainURL))
			return false;
		if (haircutURL == null) {
			if (other.haircutURL != null)
				return false;
		} else if (!haircutURL.equals(other.haircutURL))
			return false;
		if (portraitURL == null) {
			if (other.portraitURL != null)
				return false;
		} else if (!portraitURL.equals(other.portraitURL))
			return false;
		if (somatotypeURL == null) {
			if (other.somatotypeURL != null)
				return false;
		} else if (!somatotypeURL.equals(other.somatotypeURL))
			return false;
		if (stature == null) {
			if (other.stature != null)
				return false;
		} else if (!stature.equals(other.stature))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}


	public String getPortraitURL() {
		return portraitURL;
	}


	public void setPortraitURL(String portraitURL) {
		this.portraitURL = portraitURL;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getStature() {
		return stature;
	}


	public void setStature(String stature) {
		this.stature = stature;
	}


	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}


	public double getBMI() {
		return BMI;
	}


	public void setBMI(double bMI) {
		BMI = bMI;
	}


	public String getAdvice() {
		return advice;
	}


	public void setAdvice(String advice) {
		this.advice = advice;
	}


	public String getFeatureURL() {
		return featureURL;
	}


	public void setFeatureURL(String featureURL) {
		this.featureURL = featureURL;
	}


	public List<String> getHaircutURL() {
		return haircutURL;
	}


	public void setHaircutURL(List<String> haircutURL) {
		this.haircutURL = haircutURL;
	}


	public String getSomatotypeURL() {
		return somatotypeURL;
	}


	public void setSomatotypeURL(String somatotypeURL) {
		this.somatotypeURL = somatotypeURL;
	}


	public String getComplexionURL() {
		return complexionURL;
	}


	public void setComplexionURL(String complexionURL) {
		this.complexionURL = complexionURL;
	}


	public String getHairMantainURL() {
		return hairMantainURL;
	}


	public void setHairMantainURL(String hairMantainURL) {
		this.hairMantainURL = hairMantainURL;
	}
	
	
}
