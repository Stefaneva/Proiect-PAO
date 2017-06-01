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

@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/myDB")
    private DataSource dbRes;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("editProduct.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ceva");
		String idProd = request.getParameter("produse");
		String pret=request.getParameter("pret");
		String stoc=request.getParameter("stoc");
		String descriere=request.getParameter("descriere");
		String nrStoc=request.getParameter("nrStoc");
		ProductDaoImpl productDaoImpl=new ProductDaoImpl();
		Connection connection=null;
		try{
			connection=dbRes.getConnection();
			if(pret.trim()!=""||stoc.trim()!=""||descriere.trim()!=""||nrStoc.trim()!="")
				productDaoImpl.updateProductInfo(idProd, connection, pret, stoc, descriere, nrStoc);
			request.getRequestDispatcher("products.jsp").forward(request, response);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			System.out.println("ceva");
			if(connection!=null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			else{
			PrintWriter out=response.getWriter();
			request.getRequestDispatcher("editProduct.jsp").include(request, response);  
			out.print("Field not valid");
			out.close();
			return;
		}
	}
	}
}
