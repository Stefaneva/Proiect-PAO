package dao.impl;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;
import entity.*;
import dao.*;

public class UserDaoImpl implements UserDAO{
	public List<User> getUsers(int Id,Connection connection) throws SQLException{
		List<User> userList=null;
		PreparedStatement pstm=null;
		try{
			String SQL="Select * from userspao where id!=?";
			pstm=connection.prepareStatement(SQL);
			pstm.setInt(1, Id);
			ResultSet rs=pstm.executeQuery();
			userList=new ArrayList<>();
			while(rs.next()){
				User userInfo=new User();
				userInfo.setId(Integer.parseInt(rs.getString("id")));
				userInfo.setName(rs.getString("UserName"));
				userInfo.setPassword(rs.getString("Pass"));
				userInfo.setEmail(rs.getString("Email"));
				userInfo.setAddress(rs.getString("Address"));
				userInfo.setPhone(Integer.parseInt(rs.getString("Phone")));
				userInfo.setUserRole(rs.getString("Userrole"));
				userList.add(userInfo);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			if(pstm!=null)
				pstm.close();
		}
		return userList;
	}
	public User getUserInfo(int ID, Connection connection) throws SQLException
	{
		PreparedStatement pstm=null;
		User userInfo=null;
		try{
			String sql="select UserName,Email,Address,Phone,Userrole from userspao"//
					+ " where id="+Integer.toString(ID);
			pstm=connection.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			userInfo=new User();
			while(rs.next())
			{
				userInfo.setName(rs.getString("UserName"));
				userInfo.setEmail(rs.getString("Email"));
				userInfo.setAddress(rs.getString("Address"));
				userInfo.setPhone(Long.parseLong(rs.getString("Phone")));
				userInfo.setUserRole(rs.getString("Userrole"));
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
		return userInfo;
	}
	public void updateUserInfo(int ID, Connection connection,String password,String Email,String phone) throws SQLException{
		PreparedStatement pstm=null;
		try{
			String sql=null;
			if(password.trim()!=""){
				sql="Update userspao set Pass='"+password+"' where id="+ID;
				pstm=connection.prepareStatement(sql);
				pstm.executeUpdate();
				pstm.close();
			}
			if(Email.trim()!="")
				{
				sql="Update userspao set Email=? where id=?";
				pstm=connection.prepareStatement(sql);
				pstm.setString(1, Email);
				pstm.setString(2,Integer.toString(ID));
				pstm.executeUpdate();
				pstm.close();
				}
			if(phone.trim()!=""){
				sql="Update userspao set Phone=? where id=?";
				pstm=connection.prepareStatement(sql);
				pstm.setLong(1,Long.parseLong(phone));
				pstm.setString(2,Integer.toString(ID));
				pstm.executeUpdate();
				pstm.close();
			}
			System.out.println("User Updated");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void saveUser(User userSaved, Connection connection) throws SQLException
	{
		PreparedStatement pstm=null;
		try{
			String sql="INSERT INTO USERSPAO(USERNAME,PASS,EMAIL,ADDRESS,PHONE)"//
						+ " VALUES('"+userSaved.getName()+"','"+userSaved.getPassword()+"','"//
						+userSaved.getEmail()+"','"+userSaved.getAddress()+"',"+userSaved.getPhone()+")";
			pstm=connection.prepareStatement(sql);
			pstm.executeUpdate();
			System.out.println("SAVE USER TO DB");
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
	public void updateUserRole(int Id,String role,Connection connection) throws SQLException{
		PreparedStatement pstm=null;
		try{
			String sql="Update userspao set Userrole=? where id=?";
			pstm=connection.prepareStatement(sql);
			pstm.setString(1, role);
			pstm.setInt(2, Id);
			pstm.executeUpdate();
			System.out.println("User Role updated");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			if(pstm!=null)
				pstm.close();
		}
	}
	public void blockUser(int Id,String blocked,Connection connection) throws SQLException{
		PreparedStatement pstm=null;
		try{
			String sql="Update userspao set pass=? where id=?";
			pstm=connection.prepareStatement(sql);
			pstm.setString(1,blocked);
			pstm.setInt(2, Id);
			pstm.executeUpdate();
			System.out.println("User blocked");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			if(pstm!=null)
				pstm.close();
		}
	}
}
