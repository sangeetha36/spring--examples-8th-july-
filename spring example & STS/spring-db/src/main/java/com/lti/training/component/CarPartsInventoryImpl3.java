package com.lti.training.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


@Component("carPartsImpl3")
public class CarPartsInventoryImpl3 implements  CarPartsInventory{

	
	@Autowired
	@Qualifier("ds1")
	private DataSource dataSource;
	
	public void addNewPart(CarPart carpart) {
		
		     JdbcTemplate  jt = new JdbcTemplate(dataSource);
		     
			jt.update("insert into TBL_CARPART values(?,?,?,?)",
					carpart.getPartNo(),
					carpart.getCarModel(),
					carpart.getPartName(),
					carpart.getQuantity());
			
	}
	
	class CarPartRowMapper implements RowMapper<CarPart> {

		public CarPart mapRow(ResultSet rs, int rowNum) throws SQLException {
             CarPart carpart=new CarPart();
             carpart.setPartNo(rs.getInt(1));
             carpart.setPartName(rs.getString(2));
             carpart.setCarModel(rs.getString(3));
             carpart.setQuantity(rs.getInt(4));
             return carpart;

			
		}
		
	}
	public List<CarPart> getAvailableParts() {
		JdbcTemplate  jt = new JdbcTemplate(dataSource);
		
		String sql="select * from TBL_CARPART";
       List<CarPart> list = jt.query(sql,new CarPartRowMapper());
		
		return list;
	}

}
