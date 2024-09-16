package in.Nikhil.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {

	public static void main(String[] args)throws ClassNotFoundException,SQLException 
	{
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
		String sqlUpdateQuery ="update students set sname='Rohit' where sid=45";

		int rowAffected = statement.executeUpdate(sqlUpdateQuery);
		
//		to process the result 
		if(rowAffected==1)
		{
			System.out.println("the no of rows affected are::" + rowAffected);
		}
		else
		{
			System.out.println("Updation of the data failed");
		}
		statement.close();
		connection.close();
	}

}
