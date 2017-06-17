package com.learn.survey.action;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.learn.survey.model.User;
import com.learn.survey.service.UserService;
import com.learn.survey.util.MD5Utils;

@Controller
@Scope("prototype")
public class RegAction extends BaseAction<User> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5846520042938134758L;

	

	private String confirmPassword;
	
	@Autowired
	private UserService userService;
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@SkipValidation
	public String index(){
		return "index";
	}
	
	public String doReg(){
		model.setPassword(MD5Utils.GetMD5Code(model.getPassword().trim()));
		model.setRegDate(new Date());
		userService.saveEntity(model);
		return "doReg";
	}
	
	public void validateDoReg() {
		if(StringUtils.isBlank(model.getEmail())){
			addFieldError("email", "email����Ϊ��");
		}
		if(StringUtils.isBlank(model.getName())){
			addFieldError("name", "�û����ֲ���Ϊ��");
		}
		if(StringUtils.isBlank(model.getNickName())){
			addFieldError("nickName", "�û��ǳƲ���Ϊ��");
		}
		if(StringUtils.isBlank(model.getPassword())){
			addFieldError("password", "�û����벻��Ϊ��");
		}
		if(hasErrors()){
			return ;
		}
		System.out.println("confirmPassword:"+confirmPassword+",password:"+model.getPassword());
		if(!model.getPassword().trim().equals(confirmPassword.trim())){
			addFieldError("password", "�û����벻һ��");
			return ;
		}
		if(userService.isEmailUsed(model.getEmail())){
			addFieldError("email", "�����Ѿ���ע��");
			return ;
		}
	}

}
