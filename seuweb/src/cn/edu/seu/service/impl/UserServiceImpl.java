package cn.edu.seu.service.impl;

import java.util.List;

import cn.edu.seu.bean.User;
import cn.edu.seu.dao.UserDao;
import cn.edu.seu.dao.impl.UserDaoImpl;
import cn.edu.seu.exception.LoginException;
import cn.edu.seu.exception.RegisterException;
import cn.edu.seu.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public User login(String username, String password) throws LoginException {
        List<User> list = userDao.findByParams("select * from user where name=?", username);

        if (list.size() == 0) {
            throw new LoginException(LoginException.USER_NOT_EXIST);
        }

        User user = list.get(0);
        if (!user.getPassword().equals(password)) {
            throw new LoginException(LoginException.PASSWORD_ERROR);
        }

        return user;
    }

    @Override
    public void register(String username, String password, String confirm) throws RegisterException{
        
        if(password == null || !password.equals(confirm)){
            throw new RegisterException(RegisterException.CONFIRM_ERROR);
        }
        
        List<User> list = userDao.findByParams("select * from user where name=?", username);
        if(list.size()>0){
            throw new RegisterException(RegisterException.USERNAME_EXIST);
        }
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        userDao.save(user);
    }

    @Override
    public User qryById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

}
