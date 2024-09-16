package in.NIkhil.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.Nikhil1.utility.JDBCutil;
	


@WebServlet("/save")
public class StudentController extends HttpServlet {
	private static final String SQLINSERT_QUERY="insert into students(sname,sage,sadress) values(?,?,?)";
       
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection=null;
		PreparedStatement pstmnt=null;
		
		
		String sname = request.getParameter("sname");
		String sage = request.getParameter("sage");
		String sadress = request.getParameter("sadress");
	    PrintWriter out = response.getWriter();
		
		
		try {
			connection = JDBCutil.getDbConnection();
	        pstmnt = connection.prepareStatement(SQLINSERT_QUERY);
	        pstmnt.setString(1, sname);
	        pstmnt.setInt(2,Integer.parseInt(sage));
	        pstmnt.setString(3, sadress);
	        int rowCount=pstmnt.executeUpdate(); 
	        if(rowCount==1)
	        	out.println("<html><head></head><body><h1>RECORD INSERTED SUCESSFULLY</h1></body>");
	        else
	        	out.println("<body><h1>RECORD INSERTION FAILED</h1></body>");
	        out.println("</html>");
	        out.close();
		} 
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				JDBCutil.CloseResources(connection, pstmnt, null);
				
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
