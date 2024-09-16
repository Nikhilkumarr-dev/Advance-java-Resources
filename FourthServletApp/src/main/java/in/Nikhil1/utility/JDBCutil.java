package in.Nikhil1.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCutil 
{
	static 
	{
//		Load and register the driver
		try 
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
	    }
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public static Connection getDbConnection() throws SQLException
	{
//		establish the connection
		String url="jdbc:mysql://localhost:3306/nikhil";
		String user="root";
		String password="Nikhil@0810";
		return DriverManager.getConnection(url,user,password);
		
	}
	
	public static void CloseResources(Connection connection,Statement statement,ResultSet resultSet)throws SQLException
	{
		if(resultSet!=null)
			resultSet.close();
		if(connection!=null)
			connection.close();
		if(statement!=null)
			statement.close();
	}
	
}
