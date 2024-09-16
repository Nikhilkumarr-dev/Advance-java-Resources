package in.Nikhil.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import in.Nikhil.utility.JDBCutil;
//This is the program of the prepared Statement where user enter the data into the database
public class InsertData {

	public static void main(String[] args) {
		Connection connection=null;
		PreparedStatement pstmnt =null;
		ResultSet resultSet=null;
		Scanner scan=null;
		try 
		{
			connection=JDBCutil.getDbConnection();
			String sqlInsertQuery = "insert into students(sid,sname,sage,sadress) values(?,?,?,?)";
			if(connection!=null)
				pstmnt=connection.prepareStatement(sqlInsertQuery);
			if(pstmnt!=null)
			{
//				taking the inputs from the user
				
				scan=new Scanner(System.in);
				System.out.print("enter the value of sid::");
				int sid=scan.nextInt();
				System.out.print("enter the value of sage::");
				int sage=scan.nextInt();
				System.out.print("enter the value of sname::");
				String sname=scan.next();
				System.out.print("enter the value of sadress::");
				String sadress=scan.next();
				pstmnt.setInt(1, sid);
				pstmnt.setString(2, sname);
				pstmnt.setInt(3, sage);
				pstmnt.setString(4,sadress);
				
				int rowAffected =pstmnt.executeUpdate();
				if(rowAffected==1)
				{
				System.out.println("Insertion sucessfull");
				}
				else
				{
				System.out.println("Insertion failed");
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
          //closing the resources
			try 
			{
				JDBCutil.CloseResources(connection, pstmnt, null);
				scan.close();
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
