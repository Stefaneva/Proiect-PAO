package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import dao.impl.ProductDaoImpl;
import entity.Products;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/myDB")
    private DataSource dbRes;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection=null;
		HttpSession session = request.getSession();
//		int userID=(int)session.getAttribute("UserID");
		if(session.getAttribute("UserID")!=null){
			String idProd=(String)request.getParameter("cumpara");
			ConcurrentHashMap<Products, Integer> cos = (ConcurrentHashMap<Products, Integer>) session.getAttribute("cos");
			if(idProd!=null){
				try{
					connection = dbRes.getConnection();
					ProductDaoImpl productDAO=new ProductDaoImpl();
					Products product=productDAO.getProductInfo(Integer.parseInt(idProd), connection);
					if(cos.containsKey(product)){
						
						cos.put(product, cos.get(product)+1);
					}
					else{
						cos.put(product, 1);
						System.out.println(cos.get(product));
					}
					request.getRequestDispatcher("cart.jsp").include(request, response);
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
			else
				request.getRequestDispatcher("cart.jsp").include(request, response);
		}
		else response.sendRedirect("index.jsp?message="+URLEncoder.encode("Please log in!","UTF-8"));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
