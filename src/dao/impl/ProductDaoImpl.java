package dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import dao.ProductDAO;
import entity.Products;
import entity.User;

public class ProductDaoImpl implements ProductDAO{
	
	public Products getProductInfo(int ID,Connection connection) throws SQLException{
		Products productInfo=null;
		PreparedStatement pstm=null;
		try{
			String SQL="Select Idprod,Denumire,Stoc,Pret,Categorie,Descriere,NrStoc from produsePAO where Idprod="+Integer.toString(ID);
			pstm=connection.prepareStatement(SQL);
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
		finally{
			if(pstm!=null)
				pstm.close();
		}
		return productInfo;
	}
	public List<Products> getAllProducts(Connection connection) throws SQLException{
		List<Products> productList=null;
		PreparedStatement pstm=null;
		try{
			String SQL="Select Idprod,Denumire,Stoc,Pret,Categorie,Descriere,NrStoc from produsePAO";
			pstm=connection.prepareStatement(SQL);
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
		finally{
			if(pstm!=null)
				pstm.close();
		}
		return productList;
	}
	public List<Products> getProductsByCriteria(String name,String priceMin,String priceMax,Connection connection) throws SQLException{
		List<Products> productList=null;
		PreparedStatement pstm=null;
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
			pstm=connection.prepareStatement(sql);
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
		finally{
			if(pstm!=null)
				pstm.close();
		}
		return productList;
	}
	

	public List<Products> getProductsByCategory(String category, Connection connection) throws SQLException {
		List<Products> productList = null;
		PreparedStatement pstm=null;
		try {
			productList=new ArrayList<>();
			String sql = "select Idprod,Denumire,Stoc,Pret,Categorie,Descriere,NrStoc from produsePAO ";
			if(category != "")
				sql += " where lower(Categorie) like '%"+category+"%'";
			System.out.println(sql);
			pstm = connection.prepareStatement(sql);
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
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(pstm!=null)
				pstm.close();
		}
			return productList;
		}
	
	
	public void saveProduct(Products productSaved, Connection connection) throws SQLException
	{
		PreparedStatement pstm=null;
		try{
			String sql="INSERT INTO PRODUSEPAO(DENUMIRE,STOC,PRET,CATEGORIE,DESCRIERE,NRSTOC)"//
						+ " VALUES('"+productSaved.getDenumire()+"','"+productSaved.getStoc()+"',"//
						+productSaved.getPret()+",'"+productSaved.getCategorie()+"','"+productSaved.getDescriere()+"',"//
						+productSaved.getNrStoc()+")";
			pstm=connection.prepareStatement(sql);
			pstm.executeUpdate();
			System.out.println("SAVE PRODUCT TO DB");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			if(pstm!=null)
				pstm.close();
		}
	}
	
	public void updateProductInfo(int ID, Connection connection,String pret,String stoc,String descriere, String nrStoc) throws SQLException{
		PreparedStatement pstm=null;
		try{
			String sql=null;
			if(stoc.trim()!=""){
				sql="Update produsepao set Stoc=? where idprod=?";
				pstm=connection.prepareStatement(sql);
				pstm.setString(1,stoc);
				pstm.setString(2,Integer.toString(ID));
				pstm.executeUpdate();
				pstm.close();
			}
			if(pret.trim()!="")
				{
				sql="Update produsepao set pret=? where idprod=?";
				pstm=connection.prepareStatement(sql);
				pstm.setInt(1, Integer.parseInt(pret));
				pstm.setString(2,Integer.toString(ID));
				pstm.executeUpdate();
				pstm.close();
				}
			if(nrStoc.trim()!=""){
				sql="Update produsepao set nrstoc=? where idprod=?";
				pstm=connection.prepareStatement(sql);
				pstm.setInt(1, Integer.parseInt(nrStoc));
				pstm.setString(2,Integer.toString(ID));
				pstm.executeUpdate();
				pstm.close();
			}
			if(descriere.trim()!=""){
				sql="Update produsepao set descriere='"+descriere+"' where idprod="+ID;
				pstm=connection.prepareStatement(sql);
				pstm.executeUpdate();
				pstm.close();
			}
			System.out.println("Product Updated");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
//	public ArrayList<String> getProductCategories(Connection connection) throws SQLException{
//		PreparedStatement pstm=null;
//		ArrayList<String> categoryList=new ArrayList<>();
//		try{
//			String sql="select * from categories";
//			pstm=connection.prepareStatement(sql);
//			ResultSet rs=pstm.executeQuery();
//			while(rs.next())
//				categoryList.add(rs.getString("numecategorie"));
//		}
//		catch(SQLException e){
//			e.printStackTrace();
//		}finally{
//			if(pstm!=null)
//				pstm.close();
//		}
//		return categoryList;
//	}
}
