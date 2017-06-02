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
 * Servlet implementation class PromoteServlet
 */
@WebServlet("/PromoteServlet")
public class PromoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/myDB")
    private DataSource dbRes;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s=(String)request.getParameter("blocked");
		String blocked[]=null;
		if(s!=null){
			blocked=s.split(",");
			request.getSession().setAttribute("id",blocked[0]);
			if(blocked[1]!=null)
				if(blocked[1].equals("blocked"))
					blocked[1]="activated";
				else
					blocked[1]="blocked";
				request.getSession().setAttribute("blocked",blocked[1]);
		}
		else
			request.getSession().setAttribute("blocked",null);
		if(request.getParameter("id")!=null)
			request.getSession().setAttribute("id", request.getParameter("id"));
		else if(s==null)
			{
				response.sendRedirect("index.jsp");
				return;
			}
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id;
		Connection connection=null;
		if(request.getSession().getAttribute("id")!=null){
			try{
				connection = dbRes.getConnection();
				id=Integer.parseInt((String)request.getSession().getAttribute("id"));
				request.getSession().removeAttribute("id");
				String blocked=(String)request.getSession().getAttribute("blocked");
				UserDaoImpl userInfo=new UserDaoImpl();
				if(blocked==null) userInfo.updateUserRole(id, "admin", connection);
				else{
					userInfo.updateUserRole(id, "user", connection);
					userInfo.blockUser(id, blocked,connection);
				}
				response.sendRedirect("EditUsersServlet");
			}catch (SQLException e) {
				// TODO Auto-generated catch block
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
		else
			response.sendRedirect("EditUsersServlet");;
	}

}
