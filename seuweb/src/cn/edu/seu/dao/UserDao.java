package cn.edu.seu.dao;

import java.util.List;

import cn.edu.seu.bean.User;

public interface UserDao {
    //集合类
    List<User> findByParams(String sql,Object...params);
    User get(int id);
    void save(User user);
}
