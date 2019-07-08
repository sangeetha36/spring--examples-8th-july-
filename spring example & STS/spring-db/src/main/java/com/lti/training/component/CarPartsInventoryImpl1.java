package com.lti.training.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;


@Component("carPartsImpl1")
public class CarPartsInventoryImpl1 implements  CarPartsInventory{

	public void addNewPart(CarPart carpart) {
		Connection conn= null;											//manages the connection between the app and 
		PreparedStatement stmt = null;								//helps us to execute SQL statements
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			/*String url = "jdbc:oracle:thin:@localhost:1521:XE";
			 * 
			 */
			String user = "hr";
			String pass = "hr";
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",user,pass); 	//Calling the url                                                  
			String sql = "insert into TBL_CARPART values(?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt (1,  carpart.getPartNo());
			stmt.setString (2,  carpart.getCarModel());
			stmt.setString(3,  carpart.getPartName());
			stmt.setInt(4,  carpart.getQuantity());
			stmt.executeUpdate();											//any DML	 statement
			
		}
		
		catch(ClassNotFoundException e) {
			System.out.println("JDBC driver not found");
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
		
	}

		
		
	

	public List<CarPart> getAvailableParts() {

		
		return null;
	}

}
