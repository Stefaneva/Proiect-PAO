package myservlets;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
//		request.setAttribute("LogoutSucces","You have been logged out succesfully!");
		HttpSession session=request.getSession();  
        session.invalidate();
//       request.getRequestDispatcher("index.jsp").forward(request, response);
        String message="You have been logged out succesfully";
        response.sendRedirect("index.jsp?message="+URLEncoder.encode(message,"UTF-8"));
	}

}
