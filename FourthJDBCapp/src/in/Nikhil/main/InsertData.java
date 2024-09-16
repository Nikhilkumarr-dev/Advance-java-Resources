package in.Nikhil.main;
//time and date operation
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import in.Nikhil1.utility.JDBCutil;
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
			String sqlInsertQuery = "insert into person(name,dob) values(?,?)";
			if(connection!=null)
				pstmnt=connection.prepareStatement(sqlInsertQuery);
			if(pstmnt!=null)
			{
//				taking the inputs from the user
				
				scan=new Scanner(System.in);
				System.out.print("enter the value of name::");
			    String name=scan.next();
			    
			    
				System.out.print("enter the value of dob(dd-mm-yyyy)::");
				String dob=scan.next();
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
				java.util.Date utilDate=sdf.parse(dob);
				
				java.sql.Date sqlDate= new java.sql.Date(utilDate.getTime());
				
				pstmnt.setString(1,name);
				pstmnt.setDate(2, sqlDate);
				
				
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
