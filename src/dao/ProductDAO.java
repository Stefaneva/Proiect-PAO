package dao;

import java.sql.Connection;
import java.util.List;

import entity.Products;

public interface ProductDAO {
	//public Products getProductInfo(int ID,Connection connection);
	public List<Products> getAllProducts(Connection connection);
	
}
