package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import dao.impl.UserDaoImpl;
import entity.User;
import validators.LoginValidator;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/myDB")
    private DataSource dbRes;
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").include(request, response); 
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection=null;
		String userName,password;
		try {
			connection=dbRes.getConnection();
			userName=request.getParameter("userName");
			password=request.getParameter("password");
			LoginValidator loginValidator=new LoginValidator();
			int resultID=loginValidator.authentication(userName, password, connection);
			if(resultID!=0)
			{
				HttpSession session=request.getSession(true);
				
				UserDaoImpl userDaoImpl=new UserDaoImpl();
				User userInfo=userDaoImpl.getUserInfo(resultID,connection);
				String role=userInfo.getUserRole();
				session.setAttribute("userRole",role);
				
				session.setAttribute("currentUser", userName);
				session.setAttribute("UserID",resultID);
				request.getRequestDispatcher("index.jsp").include(request, response);
//				response.sendRedirect("succes.jsp");
				return;
			}
			else
			{
				PrintWriter out=response.getWriter();
//				response.sendRedirect("login.jsp");
				request.getRequestDispatcher("login.jsp").include(request, response);  
				out.print("UserName or password is incorrect!");
				out.close();
				return;
			}
		
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		}
		finally{
			if(connection!=null)
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
