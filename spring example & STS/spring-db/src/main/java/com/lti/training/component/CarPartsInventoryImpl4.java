package com.lti.training.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;




@Component("carPartsImpl4")
public class CarPartsInventoryImpl4 implements  CarPartsInventory{
//This time We are injecting EntityManager
	//object required when using  JPA
	//@Autowired doesn't work for injecting the same
	//we use @persiatancecontext 
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional   //instead of begin,commit and close @Transaction is used
	public void addNewPart(CarPart carPart) {
	entityManager.persist(carPart);
	}
	
	public List<CarPart> getAvailableParts() {
		Query q =  entityManager.createQuery("select  c from TBL_CARPART as c");
		List<CarPart> list = q.getResultList();
		return list;
		//return entityManager.createQuery("select  c from TBL_CARPART as c").getResultList();
	}
	}


