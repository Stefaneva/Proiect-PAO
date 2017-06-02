package myservlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import dao.impl.UserDaoImpl;
import entity.Products;
import entity.User;

/**
 * Servlet implementation class EditUsersServlet
 */
@WebServlet("/EditUsersServlet")
public class EditUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/myDB")
    private DataSource dbRes;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection=null;
		HttpSession session=request.getSession();;
		if(request.getSession().getAttribute("UserID")==null)
			{
				response.sendRedirect("index.jsp");
				return;
			}
		System.out.println((Integer)request.getSession().getAttribute("UserID"));
		ArrayList<User> userList;
		try {
			connection = dbRes.getConnection();
			UserDaoImpl usersDao=new UserDaoImpl();
			userList=new ArrayList<>();
			userList=(ArrayList<User>)usersDao.getUsers((Integer)session.getAttribute("UserID"),connection);
			request.getSession().setAttribute("userList",userList);
			request.getRequestDispatcher("users.jsp").forward(request, response);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(connection!=null)
				try {
					connection.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
