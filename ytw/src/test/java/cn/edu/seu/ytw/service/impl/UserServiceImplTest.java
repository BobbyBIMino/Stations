package cn.edu.seu.ytw.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.model.InitializationError;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.seu.ytw.bean.User;
import cn.edu.seu.ytw.exception.RegisterException;
import cn.edu.seu.ytw.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserServiceImplTest extends AbstractJUnit4SpringContextTests{



	@Resource
	private UserService userService;
	
	@Test
	public void testLogin() {
		
		//IOC  inervsion of control   DI   dependency injection
		
//		UserService userService = (UserService) ctx.getBean("userService");
//		UserService userService = new UserServiceImpl();
		User user = userService.login("zhangsan", "11111");
		assertEquals("zhangsan",user.getName());
	}

	@Test
	public void testRegister() {
		try {
			userService.register("wangwu", "12345", "12345");
		} catch (RegisterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
