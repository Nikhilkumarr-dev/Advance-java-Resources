package in.Nikhil.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
//	code used by JVM during the de-serialization
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		adding data to the request object
		request.setAttribute("Nikhil", "java");
		
//		transferring the control to the second coponent servlet
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/second");
		rd.forward(request, response);
	}

	

}
