package com.example.demo.login.domain.repository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.UserDao;

@Repository("UserDaoJdbcImpl")
public class UserDaoJdbcImpl implements UserDao {
	@Autowired
	JdbcTemplate jdbc;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public int insertOne(User user) throws DataAccessException {
		String password=passwordEncoder.encode(user.getPassword());
		String sql ="insert into m_user (user_id,password,role)values(?,?,?)";
		return jdbc.update(sql,user.getUserId(),password,user.getRole());
	}

	@Override
	public User selectOne(String userId) throws DataAccessException {
		String sql = "select * from m_user where user_id";
		RowMapper< User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
		return jdbc.queryForObject(sql, rowMapper,userId);
	}

	@Override
	public List<User> selectMany() throws DataAccessException {
		String sql="select * from m_user";
		RowMapper< User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
		return jdbc.query(sql,rowMapper);
	}

	@Override
	public int updateOne(User user) throws DataAccessException {
		String password=passwordEncoder.encode(user.getPassword());
		String sql ="update m_user set m_user into password=?,role=? where user_id=?";
		return jdbc.update(sql,password,user.getRole(),user.getUserId());
	}

	@Override
	public int deleteOne(String userId) throws DataAccessException {
		return jdbc.update("delete from m_user where user_id=?",userId);
	}

}
