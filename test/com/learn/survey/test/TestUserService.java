package com.learn.survey.test;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn.survey.model.User;
import com.learn.survey.service.UserService;
import com.learn.survey.util.MD5Utils;

/**
 * ≤‚ ‘ ˝æ›‘¥
 * @author Administrator
 *
 */
public class TestUserService {
	
	private static UserService userService;
	
	@BeforeClass
	public static void initUserService(){
		ApplicationContext cx = new ClassPathXmlApplicationContext("spring.xml");
		userService = (UserService) cx.getBean("userService");
	}

	@Test
	public void insertUser() throws Exception {
		User user = new User();
		user.setName("penghuiqun");
		user.setNickName("pengpeng");
		user.setEmail("phq@126.com");
		user.setPassword(MD5Utils.GetMD5Code("dmq911119"));
		user.setRegDate(new Date());
		userService.saveEntity(user);
	}
	
}
