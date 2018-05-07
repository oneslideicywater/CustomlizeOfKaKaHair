package com.oneslide.RestfulCheck.wechatJSON;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oneslide.RestfulCheck.entity.Customer;
import com.oneslide.RestfulCheck.repository.CustomerRepository;

@Controller
public class WechatImplicitController {
    
	@Autowired
	CustomerRepository customerRepository;
	//这里是微信授权登陆页面的代码
	
	//登入入口地址  域名/customize/loginDefault
	
	//发送连接到腾讯，作用域为snsapi_base
	/**
	 * https://open.weixin.qq.com/connect/oauth2/authorize?
	 * appid=wx520c15f417810387
	 * &redirect_uri=https%h194_60
	 * &response_type=code
	 * &scope=snsapi_base
	 * &state=123
	 * #wechat_redirect
	 * 
	 * */
	
	/**公众号私人定制地址打到这里*/
	@RequestMapping(path="/customize/loginEntry")
	public void loginEntry(HttpServletResponse response) {
	
		 String prepareURL="https://open.weixin.qq.com/connect/oauth2/authorize?"
				           +"appid="+WechatAPP.getAPP_ID()
				           +"&"
				           +"redirect_uri="+WechatAPP.getDOMAIN()+WechatAPP.getAPPURL()
				           +"/customize/loginDefault"  
				           +"&response_type=code"
		                   +"&scope=snsapi_base"
		                   +"&state=oneslide"
		                   +"#wechat_redirect";
		 //对连接进行编码
		 String readyURL=WechatAPP.encodeValue(prepareURL);
        
		 //跳转申请微信动态验证码-Code
		 try {
			response.sendRedirect(readyURL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			System.out.println("Step of first Authorization is wrong");
			e.printStackTrace();
		}
	}
	
	/**微信官方回调至此**/
	@RequestMapping(path="/customize/loginDefault")
	public String startInAuth(@RequestParam("code")String code,
			                  @RequestParam("state")String state,
			                  HttpSession session) {
		if(code.isEmpty()) {return "error";}
		String prepareURL=WechatAPP.startInAuthCodeGenerator(code);
		//对URL进行编码 
		String readyURL=WechatAPP.encodeValue(prepareURL);
		try {
			URL url=new URL(readyURL);
			ObjectMapper mapper=new ObjectMapper();
			try {
				CodeForAccessToken token=mapper.readValue(url,CodeForAccessToken.class);
				//如果出现错误
				if(token.equals(null)) {
					return "error";
				}
				if(token.getOpenid().isEmpty()) {
					return "error";
				}
				
				Customer customer=customerRepository.
						     findByOpenid(Long.parseLong(token.getOpenid()));
			    //通过用户openid数据库查找信息
				
				if(customer.equals(null)) {
					//用户授权登陆页面
					//查找不到,返回到登陆页面
					return "authorization";
				}else {
					//查找到
					session.setAttribute("id",customer.getId());
					return "consult";
				}
			
			
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return "error";
	}
	
	
	/**第二步验证过程链接生成
	 * @Desciption:因为这个链接并没有编码，所以，调用之后返回的字符串应该进行编码
	 * 
	 * **/
    
}
