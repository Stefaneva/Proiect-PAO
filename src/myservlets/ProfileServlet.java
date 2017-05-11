package myservlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/myDB")
    private DataSource dbRes;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection;
		try {
			connection = dbRes.getConnection();	
			UserDaoImpl userDaoImpl=new UserDaoImpl();
			int userID=(int)request.getSession().getAttribute("UserID");
			User userInfo=userDaoImpl.getUserInfo(userID,connection);
			List<String> A=new ArrayList<>();
			A.add(userInfo.getName());
			A.add(userInfo.getEmail());
			A.add(userInfo.getAddress());
			A.add(String.valueOf(userInfo.getPhone()));
			request.getSession().setAttribute("UserDetails",A);
			request.getRequestDispatcher("profile.jsp").forward(request, response);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}

}
