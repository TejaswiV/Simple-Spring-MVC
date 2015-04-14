package com.springmvc.dao;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springmvc.bean.User;

@Repository
public class RegistrationDAO extends JdbcDaoSupport {
	
	@Autowired
	private DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	} 

	public void testConnnection(){
		System.out.println(dataSource);
		
	}
	
	public boolean saveUser(User user){
		//PreparedStatement ps= dataSource.getConnection().prepareStatement(sql)
		int i = getJdbcTemplate().update("INSERT INTO USER(FIRSTNAME,LASTNAME,PASSWORD,EMAIL,GENDER) VALUES(?,?,?,?,?)"
									,user.getFirstName()
									,user.getLastName()
									,user.getPassword()
									,user.getEmail()
									,user.getGender());
		if(i>=0)
			return true;
		else
			return false;
	}
	
}