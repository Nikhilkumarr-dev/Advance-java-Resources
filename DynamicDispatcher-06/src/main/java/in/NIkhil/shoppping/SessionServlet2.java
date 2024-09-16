package in.NIkhil.shoppping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/test2")
public class SessionServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
//		getting the old session object for the name and value
		HttpSession session = request.getSession();
		if(session==null)
		{
			out.println("<h2>No sessin info is available with respect to the user</h2>");
			out.println("<table border='2'><tr><th>AttributeName</th><th>AttributeValue</th></tr>");
		}
		else
		{
//			retrieve info from the session 
			
			Enumeration<String>  names = session.getAttributeNames();
			while(names.hasMoreElements())
			{
				String name = (String)names.nextElement();
				Object value = session.getAttribute(name);
				out.println("<tr><td>"+name+"</td><td>"+value+"</td></tr>");
			}
			out.println("</table>");
			long creationTime = session.getCreationTime();
	        long lastAccessedTime = session.getLastAccessedTime();
	        int maxInactiveInterval = session.getMaxInactiveInterval();
	        out.println("<h1> Creation time is ::" +new Date(creationTime)+"</h1>");
	        
	        out.println("<h1> LastAcessed time is ::" +new Date(lastAccessedTime)+"</h1>");
	        
	        out.println("<h1> maxInactiveInterval time is ::" +new Date(maxInactiveInterval)+"</h1>");
	        
			// Extra information is also retrieved
			
		}
		out.close();
	}


	
}
