package com.learn.survey.test;


import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ≤‚ ‘ ˝æ›‘¥
 * @author Administrator
 *
 */
public class TestDataSource {

	@Test
	public void getConnection() throws Exception {
		ApplicationContext cx = new ClassPathXmlApplicationContext("spring.xml");
		DataSource data = (DataSource) cx.getBean("dataSource");
		System.out.println(data.getConnection());
	}
	
}
