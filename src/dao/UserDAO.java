package dao;


import java.sql.Connection;
import java.util.List;
import entity.User;

public interface UserDAO {
	public User getUserInfo(int ID, Connection connection);
	public void saveUser(User userSaved, Connection connection);
	public void updateUserInfo(int ID, Connection connection,String password,String Email,String phone);
}
