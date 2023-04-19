package com.vtiger.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class JDBCsql {

	public static void main(String[] args) throws SQLException {
		//Step 1 : Register/load the mySQL database 
		Driver driverRef = new Driver() ;
		DriverManager.registerDriver(driverRef);
		
		//Step 2 : get connection with database
		Connection con = DriverManager.getConnection("Database path","UserName","Password");
		
		//Step 3 : Create SQL statement
		Statement stat = con.createStatement();
		
		//Step 4 : Execute statement/Query
		ResultSet result = stat.executeQuery("");
		
		while(result.next()) {
			System.out.println(result.getInt("Column 1") + result.getString("Column 2"));
		
		}

		//Step 5 : Close connection
		con.close();
	}
	
}
