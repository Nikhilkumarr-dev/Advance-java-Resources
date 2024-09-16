package in.Nikhil.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import in.Nikhil.utility.JDBCutil;

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
			String sqlSelectQuery = "select sid,sname,sage,sadress from students where sid=?";
			if(connection!=null)
				pstmnt = connection.prepareStatement(sqlSelectQuery);
			
			if(pstmnt!=null)
			{
				scan=new Scanner(System.in);
				System.out.println("enter the value of the sid::");
				int sid=scan.nextInt();
				
				pstmnt.setInt(1,sid);
				
				resultSet = pstmnt.executeQuery();
			}
			
			if(resultSet!=null)
				System.out.println("SID\tSNAME\tSAGE\tSADRESS");
			if(resultSet.next())
			{
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
			}
			else
			{
			
				System.out.println("record not available for the given id");
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
