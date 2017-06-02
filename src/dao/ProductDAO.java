package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Products;


public interface ProductDAO {
	public Products getProductInfo(int ID,Connection connection) throws SQLException;
	public List<Products> getAllProducts(Connection connection) throws SQLException;
	public List<Products> getProductsByCriteria(String name,String priceMin,String priceMax,Connection connection) throws SQLException;
	public List<Products> getProductsByCategory(String category, Connection connection) throws SQLException;
	public void saveProduct(Products productSaved, Connection connection) throws SQLException;
	public void updateProductInfo(int ID, Connection connection,String pret,String stoc,String descriere, String nrStoc) throws SQLException;
//	public ArrayList<String> getProductCategories(Connection connection) throws SQLException;
}
