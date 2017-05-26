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
import validators.EditValidation;

/**
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/myDB")
    private DataSource dbRes;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("editProfile.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId=(int)request.getSession().getAttribute("UserID");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		Connection connection=null;
		EditValidation validator=new EditValidation();
		if(validator.validate(password, email, phone))
		{
			try{
				connection=dbRes.getConnection();
				if(password.trim()!=""||email.trim()!=""||phone.trim()!="")
					userDaoImpl.updateUserInfo(userId, connection, password, email, phone);
				request.getRequestDispatcher("index.jsp").forward(request, response);
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
		else{
			PrintWriter out=response.getWriter();
			request.getRequestDispatcher("editProfile.jsp").include(request, response);  
			out.print("Field not valid");
			out.close();
			return;
		}
	}

}
