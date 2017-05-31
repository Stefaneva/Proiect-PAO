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

import dao.impl.ProductDaoImpl;
import dao.impl.UserDaoImpl;
import entity.Products;
import entity.User;
import validators.AddProductValidator;

@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/myDB")
    private DataSource dbRes;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("addProduct.jsp").include(request, response); 
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = null;
		AddProductValidator validator = new AddProductValidator();
		String productName = (String)request.getParameter("productName");
		String stoc = (String)request.getParameter("stoc");
		String price=(String)request.getParameter("price");
		String category=(String)request.getParameter("category");
		String description=(String)request.getParameter("description");
		String nrStoc=(String)request.getParameter("nrStoc");
		if(validator.validate(productName, stoc, price, category, description, nrStoc))
		{
			try {
				connection = dbRes.getConnection();
				Products productInfo = new Products(productName, stoc, Integer.parseInt(price), category, description, Integer.parseInt(nrStoc));
				ProductDaoImpl productDaoImpl = new ProductDaoImpl();
				productDaoImpl.saveProduct(productInfo, connection);
				connection.close();
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else{
			PrintWriter out=response.getWriter();
			request.getRequestDispatcher("addProduct.jsp").include(request, response);  
			out.print("Field empty or not valid");
			out.close();
			return;
		}
	}

}
