package in.Nikhil.API;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.Nikhil.entity.Employee;
import in.Nikhil.utility.JDBCutil;

@WebServlet("/retrieve")
public class RetrieveApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SQL_SELECT_QUERY="select eid,ename,eage,eadress from employee where eid=?";
	

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//collecting input supplied by the user
		String userId = request.getParameter("userid");
		Connection connection;
		try {
			connection = JDBCutil.getDbConnection();
			PreparedStatement pstmnt = connection.prepareStatement(SQL_SELECT_QUERY);
			pstmnt.setInt(1,Integer.parseInt(userId));
			
			ResultSet resultSet = pstmnt.executeQuery();
			
			PrintWriter out =response.getWriter();
			RequestDispatcher rd=null;
			
			//out.println("<html><head><title>Output</title></head>");
			
			
			
			if(resultSet.next())
			{
				Employee employee =  new Employee();
				employee.setEid(resultSet.getInt(1));
				employee.setEage(resultSet.getInt(3));
				employee.setEname(resultSet.getString(2));
				employee.setEadress(resultSet.getString(4));
				
				rd = request.getRequestDispatcher("success.html");
				request.setAttribute("employee", employee);
				rd.forward(request, response);
				
				/*
				 * out.println("<h1>Employee information</h1>");
				 * out.println("<table border='1'>"); out.println(
				 * "<tr><th>EID</th><th>ENAME</th><th>EAGE</th><th>EADRESS</th></tr>");
				 * out.println("<tr>"); out.println("<td>"+resultSet.getInt(1)+"</td>");
				 * out.println("<td>"+resultSet.getString(2)+"</td>");
				 * out.println("<td>"+resultSet.getInt(3)+"</td>");
				 * out.println("<td>"+resultSet.getString(4)+"</td>"); out.println("</tr>");
				 * 
				 * out.println("</table>");
				 */
			}
			else
			{
				rd=request.getRequestDispatcher("failure.html");
				request.setAttribute("userId", userId);
				rd.forward(request,response);
			}
			
			//out.println("</html>");
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

}
}
