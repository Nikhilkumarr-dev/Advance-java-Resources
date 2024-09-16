package in.Nikhil.include;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		getting the writer object to write the response
	PrintWriter out = response.getWriter();
	
//	writing the response	
	out.println("<h1>this is the first servlet</h1>");
	
//	Forward the request to second  component
    RequestDispatcher rd= request.getRequestDispatcher("./second");
    rd.include(request, response);
    out.println("<h1>hello this is a first servlet agian</h1>");
    out.close();
	
	}

}
