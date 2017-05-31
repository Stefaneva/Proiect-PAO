package dao.impl;

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
			String SQL="Select Idprod,Denumire,Stoc,Pret,Categorie,Descriere,NrStoc from produsePAO where Idprod="+Integer.toString(ID);
			PreparedStatement pstm=connection.prepareStatement(SQL);
			ResultSet rs=pstm.executeQuery();
			productInfo=new Products();
			while(rs.next()){
				productInfo.setIdProd(Integer.parseInt(rs.getString("Idprod")));
				productInfo.setDenumire(rs.getString("Denumire"));
				productInfo.setStoc(rs.getString("Stoc"));
				productInfo.setPret(Integer.parseInt(rs.getString("Pret")));
				productInfo.setCategorie(rs.getString("Categorie"));
				productInfo.setNrStoc(Integer.parseInt(rs.getString("NrStoc")));
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
			String SQL="Select Idprod,Denumire,Stoc,Pret,Categorie,Descriere,NrStoc from produsePAO";
			PreparedStatement pstm=connection.prepareStatement(SQL);
			ResultSet rs=pstm.executeQuery();
			productList=new ArrayList<>();
			while(rs.next()){
				Products productInfo=new Products();
				productInfo.setIdProd(Integer.parseInt(rs.getString("Idprod")));
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
	public List<Products> getProductsByCriteria(String name,String priceMin,String priceMax,Connection connection){
		List<Products> productList=null;
		try{
			System.out.println(name+" "+priceMin+" "+priceMax);
			productList=new ArrayList<>();
			String sql="select Idprod,Denumire,Stoc,Pret,Categorie,Descriere,NrStoc from produsePAO ";
			if(name!=""&&priceMin!=""&&priceMax!="")
				sql+=" where lower(Denumire) like '%"+name+"%' and Pret between "+priceMin+" and "+priceMax;
			if(name==""&&priceMin!=""&&priceMax!="")
				sql+="where Pret between "+priceMin+" and "+priceMax;
			if(name!=""&&priceMin!=""&&priceMax=="")
				sql+="where lower(Denumire) like '%"+name+"%' and Pret >= "+priceMin;
			if(name!=""&&priceMax!=""&&priceMin=="")
				sql+="where lower(Denumire) like '%"+name+"%' and Pret <= "+priceMax;
			if(name!=""&&priceMin==""&&priceMax=="")
				sql+="where lower(Denumire) like '%"+name+"%'";
			if(priceMin!=""&&name==""&&priceMax=="")
				sql+="where Pret >= "+priceMin;
			if(priceMax!=""&&name==""&&priceMin=="")
				sql+="where Pret <= "+priceMax;
			System.out.println(sql);
			PreparedStatement pstm=connection.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				Products productInfo=new Products();
				productInfo.setIdProd(Integer.parseInt(rs.getString("Idprod")));
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
	

public List<Products> getProductsByCategory(String category, Connection connection) {
	List<Products> productList = null;
	try {
		productList=new ArrayList<>();
		String sql = "select Idprod,Denumire,Stoc,Pret,Categorie,Descriere,NrStoc from produsePAO ";
		if(category != "")
			sql += " where lower(Categorie) like '%"+category+"%'";
		System.out.println(sql);
		PreparedStatement pstm = connection.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			Products productInfo = new Products();
			productInfo.setIdProd(Integer.parseInt(rs.getString("Idprod")));
			productInfo.setDenumire(rs.getString("Denumire"));
			productInfo.setStoc(rs.getString("Stoc"));
			productInfo.setPret(Integer.parseInt(rs.getString("Pret")));
			productInfo.setCategorie(rs.getString("Categorie"));
			productInfo.setNrStoc(Integer.parseInt(rs.getString("NrStoc")));
			productInfo.setDescriere(rs.getString("Descriere"));
			productList.add(productInfo);
		}
	} catch(SQLException e) {
		e.printStackTrace();
	}
		return productList;
	}

public void saveProduct(Products productSaved, Connection connection)
{
	try{
		String sql="INSERT INTO PRODUSEPAO(DENUMIRE,STOC,PRET,CATEGORIE,DESCRIERE,NRSTOC)"//
					+ " VALUES('"+productSaved.getDenumire()+"','"+productSaved.getStoc()+"',"//
					+productSaved.getPret()+",'"+productSaved.getCategorie()+"','"+productSaved.getDescriere()+"',"//
					+productSaved.getNrStoc()+")";
		PreparedStatement pstm=connection.prepareStatement(sql);
		pstm.executeUpdate();
		System.out.println("SAVE PRODUCT TO DB");
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
}
}
