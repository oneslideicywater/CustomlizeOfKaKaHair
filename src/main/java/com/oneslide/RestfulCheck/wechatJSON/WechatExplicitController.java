package com.oneslide.RestfulCheck.wechatJSON;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

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
public class WechatExplicitController {
    @Autowired
    CustomerRepository customerRepository;
    
	@RequestMapping(path="/customize/authorizeEntry")
	public String loginEntry(@RequestParam("code") String code,
			               @RequestParam("state") String state,
			               HttpSession session) {
		
		if(code.isEmpty()) {return "error";}
		/**开始第一步获取access_token*/
		
		String prepareURL=WechatAPP.startInAuthCodeGenerator(code);
		String readyURL=WechatAPP.encodeValue(prepareURL);
		ObjectMapper mapper=new ObjectMapper();
		try {
			URL url=new URL(readyURL);
			CodeForAccessToken token=mapper.readValue(url,CodeForAccessToken.class);
			if(token.equals(null)) {
				return "error";
			}
			if(token.getOpenid().isEmpty()) {
				return "error";
			}
		
		/**现在开始确定第三部，刷新Access_token*/	
			prepareURL=WechatAPP.refreshInAuth(token.getRefresh_token());
			readyURL=WechatAPP.encodeValue(prepareURL);
			URL urlInRefresh=new URL(readyURL);
		    token=mapper.readValue(urlInRefresh,CodeForAccessToken.class);
			
			if(token.equals(null)) {
				return "error";
			}
			if(token.getOpenid().isEmpty()) {
				return "error";
			}
	 	 
	    /**通过Access_token返回用户的全部信息*/		
			prepareURL=WechatAPP.InfoInAuth(token.getOpenid(), token.getAccess_token());
			readyURL=WechatAPP.encodeValue(prepareURL);
			URL infoURL=new URL(readyURL);
			UserInfo userInfo=mapper.readValue(infoURL,UserInfo.class);
			if(userInfo.equals(null)) {
				return "error";
			}
		    if(userInfo.getOpenid().equals(null)) {
		    	return "error";
		    }
		    /**存储Customer*/
		    Customer customer=new Customer();
		    Customer custom=customerRepository.save(customer);
			custom.setOpenid(Long.parseLong(userInfo.getOpenid()));
			custom.setNickname(userInfo.getNickname());
			custom.setHeadImageURL(userInfo.getHeadimgurl());
			customer=customerRepository.save(custom);
			
			/**存储Session*/
			session.setAttribute("id",customer.getId());
			
			return "consult";
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return "error";
	}
	
	
	
	
	
}
