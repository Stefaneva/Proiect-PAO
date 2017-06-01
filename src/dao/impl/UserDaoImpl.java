package dao.impl;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import connection.MyDBConnection;
import entity.*;
import dao.*;

public class UserDaoImpl implements UserDAO{
	
	public List<User> getAllUsers()
	{
		List<User> userList=null;
		try{
			Connection connection;
			MyDBConnection mdbc=new MyDBConnection();
			mdbc.setConnection();
			connection=mdbc.getConnection();
			String sql="select USER_NAME,PASSWORD,EMAIL,ADDRESS,ID,USER_ROLE from USERS_PROJECT";
			PreparedStatement pstm=connection.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();		
			userList=new ArrayList<>();
			while(rs.next())
			{
				
				System.out.println(rs.getString(1));
				User user=new User();
				user.setName(rs.getString("USER_NAME"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setEmail(rs.getString("EMAIL"));
				user.setAddress(rs.getString("ADDRESS"));
				user.setId(rs.getInt("ID"));
				user.setUserRole(rs.getString("USER_ROLE"));
				userList.add(user);
			}
			mdbc.closeConnection();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return userList;
	}
	public User getUserInfo(int ID, Connection connection)
	{
		User userInfo=null;
		try{
			String sql="select UserName,Email,Address,Phone,Userrole from userspao"//
					+ " where id="+Integer.toString(ID);
			PreparedStatement pstm=connection.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			userInfo=new User();
			while(rs.next())
			{
				userInfo.setName(rs.getString("UserName"));
				userInfo.setEmail(rs.getString("Email"));
				userInfo.setAddress(rs.getString("Address"));
				userInfo.setPhone(Integer.parseInt(rs.getString("Phone")));
				userInfo.setUserRole(rs.getString("Userrole"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return userInfo;
	}
	public void updateUserInfo(int ID, Connection connection,String password,String Email,String phone){
		try{
			String sql=null;
			if(password.trim()!=""){
				sql="Update userspao set Pass='"+password+"' where id="+ID;
				PreparedStatement pstm=connection.prepareStatement(sql);
				pstm.executeUpdate();
			}
			if(Email.trim()!="")
				{
				sql="Update userspao set Email=? where id=?";
				PreparedStatement pstm=connection.prepareStatement(sql);
				pstm.setString(1, Email);
				pstm.setString(2,Integer.toString(ID));
				pstm.executeUpdate();
				}
			if(phone.trim()!=""){
				sql="Update userspao set Phone=? where id=?";
				PreparedStatement pstm=connection.prepareStatement(sql);
				pstm.setInt(1, Integer.parseInt(phone));
				pstm.setString(2,Integer.toString(ID));
				pstm.executeUpdate();
			}
			System.out.println("User Updated");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void saveUser(User userSaved, Connection connection)
	{
		try{
			String sql="INSERT INTO USERSPAO(USERNAME,PASS,EMAIL,ADDRESS,PHONE)"//
						+ " VALUES('"+userSaved.getName()+"','"+userSaved.getPassword()+"','"//
						+userSaved.getEmail()+"','"+userSaved.getAddress()+"',"+userSaved.getPhone()+")";
			PreparedStatement pstm=connection.prepareStatement(sql);
			pstm.executeUpdate();
			System.out.println("SAVE USER TO DB");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
