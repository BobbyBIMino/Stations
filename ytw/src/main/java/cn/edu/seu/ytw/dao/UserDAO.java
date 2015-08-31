package cn.edu.seu.ytw.dao;

import java.util.List;

import cn.edu.seu.ytw.bean.User;

public interface UserDAO {
	List<User> findByParams(String sql,Object...params);
	void save(User user);
}
