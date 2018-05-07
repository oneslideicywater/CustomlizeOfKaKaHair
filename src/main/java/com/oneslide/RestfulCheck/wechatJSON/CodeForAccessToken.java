package com.oneslide.RestfulCheck.wechatJSON;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CodeForAccessToken {
	
	/**
	 * 
	 * 获取code后，请求以下链接获取access_token：  
	 * https://api.weixin.qq.com/sns/oauth2/access_token?
	 * appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
	 * **/
	
	
	/**
	 * 
	 * 获取第二步的refresh_token后，请求以下链接获取access_token：
      https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN
	 * 
	 * **/
	
    public CodeForAccessToken() {
		super();
	}
	//JSON对象,第一步JSON对象和第二次JSON对象相同
	/*
	 * { 	"access_token":"ACCESS_TOKEN",
			"expires_in":7200,
			"refresh_token":"REFRESH_TOKEN",
			"openid":"OPENID",
			"scope":"SCOPE" }
	 * 
	 * **/
	
	private String access_token;
	private int expires_in;
	private String refresh_token;
	private String openid;
	private String scope;
	
	
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	
	
}
