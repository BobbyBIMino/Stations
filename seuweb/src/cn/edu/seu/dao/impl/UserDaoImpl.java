package cn.edu.seu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.seu.bean.User;
import cn.edu.seu.dao.UserDao;

public class UserDaoImpl implements UserDao {

    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
    @Override
    public List<User> findByParams(String sql, Object... params) {//涓嶅畾椤瑰弬鏁帮紝锛涚悊瑙ｄ负涓�釜Object[] params
        
        List<User> list = new ArrayList<User>();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaserver","root","herald");
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            for(int i=0;i<params.length;i++){
                pstmt.setObject(i+1, params[i]);
            }
            
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String pwd = rs.getString("password");
                
                User user = new User(id,name,pwd);
                list.add(user);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(conn!=null)
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }

        return list;
    }

    @Override
    public User get(int id) {
        Connection conn = null;
        User user = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","11111");
            PreparedStatement pstmt = conn.prepareStatement("select * from user where id=?");
            
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
               // int id = rs.getInt("id");
                String name = rs.getString("name");
                String pwd = rs.getString("password");
                
                user = new User(id,name,pwd);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(conn!=null)
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        return user;

    }

    @Override
    public void save(User user) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","11111");
            PreparedStatement pstmt = conn.prepareStatement("insert into user (name,password) values (?,?)");
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(conn!=null)
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }


    }



}
