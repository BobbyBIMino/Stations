package cn.edu.seu.ytw.service.impl;

import cn.edu.seu.ytw.bean.User;
import cn.edu.seu.ytw.exception.RegisterException;
import cn.edu.seu.ytw.service.UserService;

public class UserServiceImpl implements UserService{

	public User login(String name, String password) {
		System.out.println(getClass().getName()+" login execute!");
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		return user;
	}

	public void register(String name, String password, String confirm) throws RegisterException {
		// TODO Auto-generated method stub
		
	}

}
