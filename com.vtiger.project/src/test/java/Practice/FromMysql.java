package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FromMysql {

	public static void main(String[] args) throws Exception {
		Driver dref=new Driver();
		DriverManager.registerDriver(dref);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_info","root","root");
		Statement statem = conn.createStatement();
		//String query="select * from students;";
		ResultSet result = statem.executeQuery("select * from students;");
		while (result.next()) {
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
			
		}

	}

}
