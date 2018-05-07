package com.oneslide.RestfulCheck.wechatJSON;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo {
   public UserInfo() {
		super();
	}
/**
    * {     "openid":"OPENID",
			"nickname":NICKNAME,
			"sex":"1",
			"province":"PROVINCE"
			"city":"CITY",
			"country":"COUNTRY",
			"headimgurl": "http://thirdwx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/46",
			"privilege":["PRIVILEGE1" "PRIVILEGE2" ],
			"unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL"
		}
    * 
    * 
    * 
    * **/
	
	   private String openid;
	   private String nickname;
	   private int sex;
	   private String province;
	   private String city;
	   private String country;
	   private String headimgurl;
	   private String[] privilege;
	   private String unionid;
	   
	   
	   public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String[] getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String[] privilege) {
		this.privilege = privilege;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	
	   
	
}
