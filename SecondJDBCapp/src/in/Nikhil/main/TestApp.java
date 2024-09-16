package in.Nikhil.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.Nikhil.utility.JDBCutil;

public class TestApp {

	public static void main(String[] args)
//	instead of ducking the exception we use try catch methods
	{
		
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		
		
		try {
			connection = JDBCutil.getDbConnection();
			
			if(connection!=null)
				statement = connection.createStatement();
			
			if(statement!=null)
				resultSet = statement.executeQuery("select sid,sname,sage,sadress from students");
			
			if(resultSet!=null)
				System.out.println("SID\tSNAME\tSAGE\tSADRESS");
			while(resultSet.next())
			{
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
			}
		} 
		catch (SQLException e) 
		{
	
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
//			handling
		}
		finally
		{
//			closing the resources
			try 
			{
				JDBCutil.CloseResources(connection, statement, resultSet);
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		
	}

}
