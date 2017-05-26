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
import javax.sql.DataSource;

import dao.impl.UserDaoImpl;
import entity.User;
import validators.SignUpValidator;

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
		SignUpValidator validator=new SignUpValidator();
		String userName=(String)request.getParameter("userName");
		String password=(String)request.getParameter("password");
		String email=(String)request.getParameter("email");
		String phone=(String)request.getParameter("phone");
//		String role=(String)request.getParameter("role");
		String address=(String)request.getParameter("address");
		if(validator.validate(userName, email, phone, password, address))
		{
			try {
				connection = dbRes.getConnection();
				User userInfo=new User(userName,password,email,address,Integer.parseInt(phone));
				UserDaoImpl userDaoImpl=new UserDaoImpl();
				userDaoImpl.saveUser(userInfo, connection);
				connection.close();
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else{
			PrintWriter out=response.getWriter();
			request.getRequestDispatcher("signUp.jsp").include(request, response);  
			out.print("Field empty or not valid");
			out.close();
			return;
		}
	}

}
