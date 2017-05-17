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
import javax.sql.DataSource;

import dao.impl.ProductDaoImpl;
import entity.Products;


@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/myDB")
    private DataSource dbRes;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection=null;
		try {
			ArrayList<Products> productList=new ArrayList<>();
			connection = dbRes.getConnection();	
			ProductDaoImpl productDAO=new ProductDaoImpl();
			productList=(ArrayList<Products>)productDAO.getAllProducts(connection);
			request.getSession().setAttribute("productList",productList);
			request.getRequestDispatcher("products.jsp").forward(request, response);
		}
		catch (SQLException e) {
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
