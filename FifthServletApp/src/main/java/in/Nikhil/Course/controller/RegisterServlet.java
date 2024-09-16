package in.Nikhil.Course.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("request phase processing.....");
		String username = request.getParameter("username");
		String usernumber=request.getParameter("usernumber");
		String[] course=request.getParameterValues("course");
		
		PrintWriter out =response.getWriter();
		out.println("<html><head><title>OUTPUT</title></head>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr><td>USERNAME</td><td>" +username+"</td></tr>");
		out.println("<tr><td>USERMOBILENUMBER</td><td>" +usernumber+"</td></tr>");
		for(String courses:course)
		{
			out.println("<tr>");
			out.println("<td>COURSE</td><td>" + courses + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
;
		}

}
