package in.Nikhil.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import in.Nikhil.utility.JDBCutil;

public class UpdateData {

	public static void main(String[] args)
	{
		Connection connection=null;
		PreparedStatement pstmnt=null;
		Scanner scan=null;
		
		try {
			connection = JDBCutil.getDbConnection();
			String sqlUpdateQuery="update  students set sname=? where sid=?";
			if(connection!=null)
				pstmnt=connection.prepareStatement(sqlUpdateQuery);
			
			if(pstmnt!=null)
			{
				scan=new Scanner(System.in);
				System.out.print("enter the value of sname::");
				String sname=scan.next();
				System.out.print("enter the value of sid::");
				int sid=scan.nextInt();
				
				pstmnt.setInt(2, sid);
				pstmnt.setString(1,sname);
				
				
				int rowAffected = pstmnt.executeUpdate();
				if(rowAffected==1)
				{
					System.out.println("Updation succesfull");
				}
				else
				{
					System.out.println("Data unavialable for updation......" + sid);
				}
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
