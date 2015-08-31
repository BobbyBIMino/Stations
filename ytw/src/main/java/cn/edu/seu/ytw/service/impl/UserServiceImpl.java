package cn.edu.seu.ytw.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.seu.ytw.bean.User;
import cn.edu.seu.ytw.dao.UserDAO;
import cn.edu.seu.ytw.exception.RegisterException;
import cn.edu.seu.ytw.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public User login(String name, String password) {
		System.out.println(getClass().getName()+" login execute!");
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		return user;
	}

	public void register(String name, String password, String confirm) throws RegisterException {
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		
		userDAO.save(user);
		
		
	}

}
