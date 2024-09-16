package in.Nikhil.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		getting the writer object to the writing response
		PrintWriter out = response.getWriter();
		
			
		out.println("<h1>Forward Request Attribute</h1>");
//		accessing the all the attributes
		Enumeration<String> names = request.getAttributeNames();
		while(names.hasMoreElements())
		{
			String name = (String) names.nextElement();
			Object value = request.getAttribute(name);
			out.println(name +" " + value + "<br/>");
			
			
		}
	}

}
