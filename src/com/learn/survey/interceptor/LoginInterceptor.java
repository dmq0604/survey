package com.learn.survey.interceptor;

import com.learn.survey.action.BaseAction;
import com.learn.survey.action.LoginAction;
import com.learn.survey.action.RegAction;
import com.learn.survey.model.User;
import com.learn.survey.struts.UserAware;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7590470667100000732L;

	@Override
	public void destroy() {
		

	}

	@Override
	public void init() {
		
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		BaseAction<?> action = (BaseAction<?>) arg0.getAction();
		if(action instanceof LoginAction ||action instanceof RegAction){
			return arg0.invoke();
		}else{
			User user = (User) arg0.getInvocationContext().getSession().get("user");
			if(user == null){
				return "login";
			}else{
				if(action instanceof UserAware){
					((UserAware) action).setUser(user);
				}
				return arg0.invoke();
			}
		}
	}

}
