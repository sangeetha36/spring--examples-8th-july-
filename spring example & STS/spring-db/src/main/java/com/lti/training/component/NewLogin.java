package com.lti.training.component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("newLogin")
public class NewLogin implements LoginDetials {

	
	
	
	
	@PersistenceContext
	private EntityManager em;
@Transactional
	public void addNew(Login login) {
		em.persist(login);		
	}


class LoginRowMapper implements RowMapper<Login> {

	public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
		Login lo=new Login();
		lo.setAcNo(rs.getInt(1));
		lo.setAccType(rs.getString(2));
		lo.setBalance(rs.getDouble(3));
		lo.setAccType(rs.getString(4));
		return lo;
	}
	
}
	public List<Login> getDetials() {
		Query q =  em.createQuery("select t from Login as t");
		List<Login> list = q.getResultList();
		return list;
	}
}
