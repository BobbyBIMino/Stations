package cn.edu.seu.ytw.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.seu.ytw.bean.User;
import cn.edu.seu.ytw.service.UserService;

public class UserServiceImplTest{

	@Test
	public void testLogin() {
		
		//IOC  inervsion of control   DI   dependency injection
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) ctx.getBean("userService");
//		UserService userService = new UserServiceImpl();
		User user = userService.login("zhangsan", "11111");
		assertEquals("zhangsan",user.getName());
	}

	@Test
	public void testRegister() {
		fail("Not yet implemented");
	}

}
