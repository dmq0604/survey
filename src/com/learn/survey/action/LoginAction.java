package com.learn.survey.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.learn.survey.model.User;
import com.learn.survey.service.UserService;
import com.learn.survey.util.MD5Utils;

@Controller
@Scope("prototype")
public class LoginAction extends BaseAction<User> implements SessionAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2888959346139177643L;
	private Map<String,Object> session;
	@Autowired
	private UserService userService;
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
	
	public String index(){
		return "index";
	}

	public String login(){
		
		return "success";
	}
	
	public void validateLogin() {
		User user = userService.userLogin(model.getEmail(),MD5Utils.GetMD5Code(model.getPassword()));
		if(null == user){
			this.addActionError("”√ªß√˚√‹¬Î¥ÌŒÛ");
		}else{
			session.put("user", user);
		}
		
	}
	

}
