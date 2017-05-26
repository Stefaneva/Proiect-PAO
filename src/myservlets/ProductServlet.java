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

import dao.impl.ProductDaoImpl;
import entity.Products;


@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/myDB")
    private DataSource dbRes;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection=null;
		HttpSession session=null;
		ArrayList<Products> productList;
		try {
			ProductDaoImpl productDAO=new ProductDaoImpl();
			session=request.getSession();
			connection = dbRes.getConnection();
			productList=new ArrayList<>();
			String productName=(String)session.getAttribute("productName");
			String priceMin=(String)session.getAttribute("priceMin");
			String priceMax=(String)session.getAttribute("priceMax");
			String category = (String)session.getAttribute("category");
			productList=(ArrayList<Products>)productDAO.getAllProducts(connection);
//			if(priceMin!=null||productName!=null||priceMax!=null)
				if(category != null) productList = (ArrayList<Products>)productDAO.getProductsByCategory(category, connection);
				if((String)session.getAttribute("searchForm")!=null)productList=(ArrayList<Products>)productDAO.getProductsByCriteria(productName, priceMin, priceMax, connection);
//			else
//				productList=(ArrayList<Products>)productDAO.getAllProducts(connection);
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
