package in.Nikhil.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import in.Nikhil.utility.JDBCutil;

public class InsertData {

	public static void main(String[] args) {
		Connection connection=null;
		Statement statement =null;
		try 
		{
			connection=JDBCutil.getDbConnection();
			
			if(connection!=null)
				statement=connection.createStatement();
			
			String sqlInsertQuery="insert into students(sid,sname,sage,sadress) values(18,'kohi',37,'IND')";
			int rowAffected =statement.executeUpdate(sqlInsertQuery);
			
			if(rowAffected==1)
			{
				System.out.println("The no of rows affected::" + rowAffected);
			}
			else
			{
				System.out.println("Insertion failed");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	    catch(Exception e)
		{
	    	e.printStackTrace();
		}
		finally
		{
//			closing the resources
			try 
			{
				JDBCutil.CloseResources(connection, statement, null);
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		

	}

}
