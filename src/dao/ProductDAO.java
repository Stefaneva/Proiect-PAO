package dao;

import java.sql.Connection;
import java.util.List;

import entity.Products;
import entity.User;

public interface ProductDAO {
	public Products getProductInfo(int ID,Connection connection);
	public List<Products> getAllProducts(Connection connection);
	public List<Products> getProductsByCriteria(String name,String priceMin,String priceMax,Connection connection);
	public List<Products> getProductsByCategory(String category, Connection connection);
	public void saveProduct(Products productSaved, Connection connection);
	public void updateProductInfo(int ID, Connection connection,String pret,String stoc,String descriere, String nrStoc);
}
