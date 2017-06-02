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
import validators.EditProductValidator;

@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/myDB")
    private DataSource dbRes;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idProd=(String)request.getParameter("produsId");
		request.getSession().setAttribute("produsId", idProd);
		request.getRequestDispatcher("editProduct.jsp").include(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if(request.getParameter("produsId")!=null)
//		String idProd=(String)request.getParameter("produsId");
		String idProd=(String)request.getSession().getAttribute("produsId");
		request.getSession().removeAttribute("produsId");
		String pret=(String)request.getParameter("pret");
		String stoc=(String)request.getParameter("stoc");
		String descriere=(String)request.getParameter("descriere");
		String nrStoc=(String)request.getParameter("nrStoc");
		System.out.println(pret+" "+stoc+" "+descriere+" "+nrStoc);
		ProductDaoImpl productDaoImpl=new ProductDaoImpl();
		Connection connection=null;
		EditProductValidator validator=new EditProductValidator();
		if(validator.validate(pret, stoc, descriere, nrStoc))
		{
			try{
				connection=dbRes.getConnection();
				if(pret.trim()!=""||stoc.trim()!=""||descriere.trim()!=""||nrStoc.trim()!="")
					productDaoImpl.updateProductInfo(Integer.parseInt(idProd), connection, pret, stoc, descriere, nrStoc);
//				request.getRequestDispatcher("products.jsp").forward(request, response);
				response.sendRedirect("ProductServlet");
				return;
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			finally{
				if(connection!=null)
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
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
