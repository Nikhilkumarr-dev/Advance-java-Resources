package in.NIkhil.shoppping;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/test1")
public class SessionServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//creating the response writer 
		
		PrintWriter out = response.getWriter();
		
		
		HttpSession session = request.getSession();
		
//Getting the session  object  to track the request information of client
		if(session.isNew())
		{
			out.println("<h2>New Session created with the id of :: " + session.getId() +"</h2>");
		}
		else
		{
			out.println("<h2>Existing session with the session id" + session.getId() + "</h2>");
			
		}
//		retrieving the user information from the request object
		String name = request.getParameter("name");
	    String value = 	request.getParameter("value");
	    
//	    specifiying max active time
        session.setMaxInactiveInterval(60);
	    
//	    keeping the user info in the session object
	    session.setAttribute(name, value);
	    
//	    sending the response to the end user
	    RequestDispatcher rd = request.getRequestDispatcher("login.html");
	    rd.include(request, response);
	    
	    
	    out.close();
	    
	}

}
