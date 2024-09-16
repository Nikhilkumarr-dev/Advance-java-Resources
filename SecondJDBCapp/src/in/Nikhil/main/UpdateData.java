package in.Nikhil.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import in.Nikhil.utility.JDBCutil;

public class UpdateData {

	public static void main(String[] args)
	{
		Connection connection=null;
		Statement statement=null;
		
		try {
			connection = JDBCutil.getDbConnection();
			if(connection!=null)
				statement=connection.createStatement();
			String sqlDeleteQuery="update  students set sname='Sharma' where sid=45";
			int rowAffected =statement.executeUpdate(sqlDeleteQuery);
			if(rowAffected==1)
			{
				System.out.println("the no of rows affected is::" + rowAffected);
			}
			else
			{
				System.out.println("no updation done");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				JDBCutil.CloseResources(connection, statement, null);
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
