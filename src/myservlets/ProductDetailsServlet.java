package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

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

@WebServlet("/ProductDetailsServlet")
public class ProductDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/myDB")
    private DataSource dbRes;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection=null;
		HttpSession session = request.getSession();
		String idProd = request.getParameter("produs");
		//HashMap<Products, Integer> cos = (HashMap<Products, Integer>) session.getAttribute("cos");
		try{
			connection = dbRes.getConnection();
			ProductDaoImpl productDAO=new ProductDaoImpl();
			Products product=productDAO.getProductInfo(Integer.parseInt(idProd), connection);
			if(product != null) {
				session.setAttribute("product", product);
			}
			request.getRequestDispatcher("detaliiProdus.jsp").include(request, response);
		}catch (SQLException e) {
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
