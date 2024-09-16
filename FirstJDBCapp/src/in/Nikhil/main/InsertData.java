package in.Nikhil.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {

	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		
//		load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
//		establish the connection
		String url="jdbc:mysql://localhost:3306/nikhil";
		String user="root";
		String password="Nikhil@0810";
		Connection connection = DriverManager.getConnection(url,user,password);
		
//		create the statement object
		Statement statement =connection.createStatement();
		
//		execute the query
		String sqlInsertQuery ="insert into students(sid,sname,sage,sadress) values(18,'Kohli',37,'IND')";
		int rowAffected = statement.executeUpdate(sqlInsertQuery);
		
//		to process the result 
		if(rowAffected==1)
		{
			System.out.println("the no of rows affected are::" + rowAffected);
		}
		else
		{
			System.out.println("insertion of the data failed");
		}
		statement.close();
		connection.close();
		

	}

}
