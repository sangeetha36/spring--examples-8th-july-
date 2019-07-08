package com.lti.training.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("carPartsImpl2")
public class CarPartsInventoryImpl2 implements  CarPartsInventory{

	
	@Autowired
	@Qualifier("ds1")
	private DataSource dataSource;
	
	public void addNewPart(CarPart carpart) {
		Connection conn= null;										
		PreparedStatement stmt = null;									
		try {
	    	conn=dataSource.getConnection(); //this replaces the driver connection
			
			//conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",user,pass); 	//Calling the url                                                  
			String sql = "insert into TBL_CARPART values(?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt (1,  carpart.getPartNo());
			stmt.setString (2,  carpart.getCarModel());
			stmt.setString(3,  carpart.getPartName());
			stmt.setInt(4,  carpart.getQuantity());
			stmt.executeUpdate();											//any DML	 statement
			
		}
		
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try { 
				conn.close(); 
			}
			catch(Exception e) {
				
			}
		}
		
	}

		
		
	

	public List<CarPart> getAvailableParts() {

		
		return null;
	}

}
