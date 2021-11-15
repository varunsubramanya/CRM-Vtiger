package com.vtiger.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseConnection {

	public static void main(String[] args) throws SQLException {
		Driver driverRef= new Driver();
		DriverManager.registerDriver(driverRef);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_info", "root", "root" );
		Statement stat = con.createStatement();
		String query="select * from students_data;";


		/*insert into students_data (Name, Class, Age) values('yogi','M.tech','26')
		 int result = stat.executeUpdate(query);
		  if(result==1) {
			System.out.println("Data updated");
		}
		else{
			System.out.println("Data not updated");
		}*/


		ResultSet result = stat.executeQuery(query);
		while(result.next()) {
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getInt(3));
		}
		con.close();

	}

}
