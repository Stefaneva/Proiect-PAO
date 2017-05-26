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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("searchProducts.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		String productName=(String)request.getParameter("productName");
		String priceMin=(String)request.getParameter("priceMin");
		String priceMax=(String)request.getParameter("priceMax");
		if(productName.trim()!="")
			session.setAttribute("productName", productName);
		if(priceMin.trim()!="")
			session.setAttribute("priceMin", priceMin);
		if(priceMax.trim()!="")
			session.setAttribute("priceMax", priceMax);
		response.sendRedirect("ProductServlet");
	}

}
