package in.Nikhil.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import in.Nikhil1.utility.JDBCutil;

public class TestApp {

	public static void main(String[] args)
//	instead of ducking the exception we use try catch methods
	{
		
		Connection connection=null;
		PreparedStatement pstmnt=null;
		ResultSet resultSet=null;
		Scanner scan=null;
		
		
		
		
		try {
			connection = JDBCutil.getDbConnection();
			String sqlSelectQuery = "select name,dob  from person where name=?";
			if(connection!=null)
				pstmnt = connection.prepareStatement(sqlSelectQuery);
			
			if(pstmnt!=null)
			{
				scan=new Scanner(System.in);
				System.out.println("enter the name of person::");
			     String name=scan.next();
				
				pstmnt.setString(1,name);
				
				
				resultSet = pstmnt.executeQuery();
			}
			
			if(resultSet!=null)
			if(resultSet.next())
			{
				System.out.println("NAME\tDOB");
				Date sqldate=resultSet.getDate(2);
				SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
				String stringdate=sdf.format(sqldate);
				System.out.println(resultSet.getString(1)+"\t"+stringdate);
				
			}
			else
			{
			
				System.out.println("record not available for the given name");
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
				JDBCutil.CloseResources(connection, pstmnt, resultSet);
				scan.close();
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
