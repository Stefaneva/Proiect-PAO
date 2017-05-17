package dao.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


import dao.ProductDAO;
import entity.Products;
import entity.User;

public class ProductDaoImpl implements ProductDAO{
	
	public Products getProductInfo(int ID,Connection connection){
		Products productInfo=null;
		try{
			String SQL="Select Denumire,Stoc,Pret,Descriere from produsPAO";
			PreparedStatement pstm=connection.prepareStatement(SQL);
			ResultSet rs=pstm.executeQuery();
			productInfo=new Products();
			while(rs.next()){
				productInfo.setDenumire(rs.getString("Denumire"));
				productInfo.setStoc(rs.getString("Stoc"));
				productInfo.setPret(Integer.parseInt(rs.getString("Pret")));
				productInfo.setDescriere(rs.getString("Descriere"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return productInfo;
	}
	public List<Products> getAllProducts(Connection connection){
		List<Products> productList=null;
		try{
			String SQL="Select Denumire,Stoc,Pret,Categorie,Descriere,NrStoc from produsePAO";
			PreparedStatement pstm=connection.prepareStatement(SQL);
			ResultSet rs=pstm.executeQuery();
			productList=new ArrayList<>();
			while(rs.next()){
				Products productInfo=new Products();
				productInfo.setDenumire(rs.getString("Denumire"));
				productInfo.setStoc(rs.getString("Stoc"));
				productInfo.setPret(Integer.parseInt(rs.getString("Pret")));
				productInfo.setCategorie(rs.getString("Categorie"));
				productInfo.setNrStoc(Integer.parseInt(rs.getString("NrStoc")));
				productInfo.setDescriere(rs.getString("Descriere"));
				productList.add(productInfo);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return productList;
	}
}
