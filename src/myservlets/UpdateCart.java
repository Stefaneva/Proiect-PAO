package myservlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Products;

@WebServlet("/UpdateCart")
public class UpdateCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int prodId,quantity=0;
//		if(request.getParameter("prodId")!=null)
			 prodId=Integer.parseInt(request.getParameter("prodId"));
		if(request.getParameter("quantity")!=null)
			quantity=Integer.parseInt(request.getParameter("quantity"));
		System.out.println(quantity);
		ConcurrentHashMap<Products, Integer> cos = (ConcurrentHashMap<Products, Integer>) session.getAttribute("cos");
		if(prodId>0){
			for(Map.Entry<Products, Integer> entry:cos.entrySet())
			{
				if(entry.getKey().getIdProd()==prodId)
					if(quantity>0){
						cos.put(entry.getKey(),quantity);
					}
					else{
						cos.remove(entry.getKey());
					}
			}
			response.sendRedirect("cart.jsp");
		}
		else
			response.sendRedirect("cart.jsp");
		
	}

}
