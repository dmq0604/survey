package com.learn.survey.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.learn.survey.dao.BaseDao;
import com.learn.survey.model.User;
import com.learn.survey.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	
	@Override
	@Resource(name="userDao")
	public void setBaseDao(BaseDao<User> baseDao) {
		super.setBaseDao(baseDao);
	}

	@Override
	public boolean isEmailUsed(String email) {
		String hql = "from User u where u.email=?";
		List<User> userList = this.getEntityByHQL(hql, email);
		if(userList.size()>0){
			return true;
		}
		return false;
	}

	@Override
	public User userLogin(String email, String password) {
		String hql="from User u where u.email=? and u.password=?";
		List<User> userList = this.getEntityByHQL(hql, email,password);
		if(userList==null || userList.size()==0){
			return null;
		}else{
			return userList.get(0);
		}
		
	}
}
