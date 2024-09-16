package in.Nikhil.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import in.Nikhil.utility.JDBCutil;

public class DeleteData {

	public static void main(String[] args)
	{
		Connection connection=null;
		PreparedStatement pstmnt=null;
		ResultSet resultSet=null;
		Scanner scan=null;
		
		
		try 
		{
			connection =JDBCutil.getDbConnection();
			String sqlDeleteQuery = "delete from students where sid=?";
			if(connection!=null)
				pstmnt=connection.prepareStatement(sqlDeleteQuery);
			
			if(pstmnt !=null)
			{
				scan=new Scanner(System.in);
				System.out.print("enter the value of sid to be deleted::");
				int sid=scan.nextInt();
				
				pstmnt.setInt(1,sid);
				
				int rowAffected=pstmnt.executeUpdate();
				
				if(rowAffected==1)
				{
					System.out.println("Deletion is sucessfull");
				}
				else
				{
					System.out.println("Deletion unsucesfull");
				}
				
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
			try {
				JDBCutil.CloseResources(connection, pstmnt, null);
				scan.close();
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
