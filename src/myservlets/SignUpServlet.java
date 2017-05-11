package myservlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import dao.impl.UserDaoImpl;
import entity.User;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/myDB")
    private DataSource dbRes;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("signUp.jsp").include(request, response); 
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection=null;
		try {
			connection = dbRes.getConnection();
			User userInfo=new User(request.getParameter("userName"),request.getParameter("password"),//
					request.getParameter("email"),request.getParameter("address"),//
					Integer.parseInt(request.getParameter("phone")),request.getParameter("role"));
			UserDaoImpl userDaoImpl=new UserDaoImpl();
			userDaoImpl.saveUser(userInfo, connection);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
