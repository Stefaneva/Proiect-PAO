package dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import entity.User;

public interface UserDAO {
	public List<User> getUsers(int Id,Connection connection) throws SQLException;
	public User getUserInfo(int ID, Connection connection) throws SQLException;
	public void updateUserInfo(int ID, Connection connection,String password,String Email,String phone) throws SQLException;
	public void saveUser(User userSaved, Connection connection) throws SQLException;
	public void updateUserRole(int Id,String role,Connection connection) throws SQLException;
	public void blockUser(int Id,String blocked,Connection connection) throws SQLException;
}
