package com.learn.survey.service;

import com.learn.survey.model.User;

public interface UserService extends BaseService<User> {

	public boolean isEmailUsed(String email);

	public User userLogin(String email, String password);

}
