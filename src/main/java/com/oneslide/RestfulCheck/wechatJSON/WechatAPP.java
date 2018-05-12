package com.oneslide.RestfulCheck.wechatJSON;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class WechatAPP {
     //微信接口的一些固有属性
	
	 //APPID
	 private static String APP_ID="wx550cbc80cf196c23";
	 
	 private static String APPURL="RestfulCheck-0.0.1-SNAPSHOT";
	 //APPSecret
	 private static String SECRET="0afca626381e6dd3874e95492fa0c77a";
	 
	 private static String DOMAIN="http://www.kakatohair.com/";
	 

	 public static String getAPP_ID() {
		return APP_ID;
	 }

	 public static String getSECRET() {
		return SECRET;
	 }

	public static String getDOMAIN() {
		return DOMAIN;
	}

	 static String startInAuthCodeGenerator(String code) {
			/**
			 * 
			 * https://api.weixin.qq.com/sns/oauth2/access_token?
			 * appid=APPID
			 * &secret=SECRET
			 * &code=CODE
			 * &grant_type=authorization_code
			 **/
			String prepareURL="https://api.weixin.qq.com/sns/oauth2/access_token?"
					          +"appid="+WechatAPP.getAPP_ID()
					          +"&"+"secret="+WechatAPP.getSECRET()
					          +"&code="+code
					          +"&grant_type=authorization_code";
			
			
			return prepareURL;
					          
			
		}
	/**
	 *  @see 
	 *  https://api.weixin.qq.com/sns/oauth2/refresh_token?
	 *  appid=APPID
	 *  &grant_type=refresh_token
	 *  &refresh_token=REFRESH_TOKEN
	 * 
	 * @return  微信授权登陆刷新access_token后的网址，没有经过编码
	 * **/	
		static String refreshInAuth(String token) {
			String prepareURL="https://api.weixin.qq.com/sns/oauth2/refresh_token?"
			                  +"appid="+APP_ID
			                  +"&grant_type=refresh_token"
			                  +"&refresh_token="+token;
			return prepareURL;
		}
         /**
	      * @author onesl
	     * @Param   
	     *   openid和access_token
	     * @return
	     * 返回获取用户信息的链接，未经编码
	     * 
	     * @see
	     *   https://api.weixin.qq.com/sns/userinfo?
	     *   access_token=ACCESS_TOKEN
	     *   &openid=OPENID
	     *   &lang=zh_CN
	     ***/
	   static String InfoInAuth(String openid,String token){
		   String prepareURL="https://api.weixin.qq.com/sns/userinfo?"
				             +"access_token="+token
				             +"&openid="+openid
				             +"&lang=zh_CN";
		   return prepareURL; 
	   }
	 
	 
	 
	 
	 
	 static String encodeValue(String value) {
		    try {
				return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return value;
		}

	public static String getAPPURL() {
		return APPURL;
	}

	public static void setAPPURL(String aPPURL) {
		APPURL = aPPURL;
	}
		

	 
}
