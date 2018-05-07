package com.oneslide.RestfulCheck.wechatJSON;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatError {
 
	public WeChatError() {
		super();
	}
	/**
	 * {"errcode":40029,"errmsg":"invalid code"}
	 * 
	 * **/
	
	private int errcode;
	private String errmsg;
	public int getErrcode() {
		return errcode;
	}
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	
}
