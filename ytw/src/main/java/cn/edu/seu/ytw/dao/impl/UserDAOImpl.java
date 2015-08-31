package cn.edu.seu.ytw.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.seu.ytw.bean.User;
import cn.edu.seu.ytw.dao.UserDAO;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired //×¢Èë
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<User> findByParams(String sql, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(User user) {
		jdbcTemplate.update("insert into user (name,password) values (?,?)",user.getName(),user.getPassword());
	}

}
