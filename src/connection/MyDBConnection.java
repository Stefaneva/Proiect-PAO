/*Clasa de conectare la BD veche(ptr apk non-web)*/

//package connection;
//
//import java.sql.*;
//
//public class MyDBConnection{
//	private Connection connection;
//
//	public Connection getConnection() {
//		return this.connection;
//	}
//
//	public void setConnection() {
//		try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//		}
//		catch(Exception e){
//		      //Handle errors for Class.forName
//		      e.printStackTrace();
//		}
//		try{
//			String user="eva_stefan";
//			String password="darkdragonses9";
//			this.connection = DriverManager.getConnection("jdbc:oracle:thin:@193.226.51.37:1521:o11g",user,password);
//			
//		}
//		catch(SQLException se){
//			se.printStackTrace();
//		}
//	}
//	public void closeConnection()
//	{
//		try {
//			this.connection.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//}

