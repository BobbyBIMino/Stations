package cn.edu.seu.service;

import java.util.List;

import cn.edu.seu.bean.User;
import cn.edu.seu.exception.LoginException;
import cn.edu.seu.exception.RegisterException;

public interface UserService {
    User login(String username,String password) throws LoginException;
    void register(String username,String password,String confirm) throws RegisterException;
    User qryById(int id);
    
}
