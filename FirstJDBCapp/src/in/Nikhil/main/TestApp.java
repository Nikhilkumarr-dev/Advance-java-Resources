package in.Nikhil.main;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestApp {

	public static void main(String[] args)throws Exception 
	{
//		Load and register the dirver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
//		establish the connection
		String url="jdbc:mysql://localhost:3306/nikhil";
		String user="root";
		String password="Nikhil@0810";
		Connection connection = DriverManager.getConnection(url,user,password);
		
//		create the statement object
		Statement statement =connection.createStatement();
		
//		execute the query
		String sqlSelectQuery ="select sid,sname,sage,sadress from students";
		ResultSet resultSet=statement.executeQuery(sqlSelectQuery);
		
		
//		to process the result 
		System.out.println("SID\tSNAME\tSAGE\tSADRESS");
		while(resultSet.next())
		{
			System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
			
		}
		resultSet.close();
		statement.close();
		connection.close();
		
		
	}

}
