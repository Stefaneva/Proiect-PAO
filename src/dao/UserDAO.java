package dao;


import java.sql.Connection;
import java.util.List;
import entity.User;

public interface UserDAO {
	public List<User> getAllUsers();
	public User getUserInfo(int ID, Connection connection);
	public void saveUser(User userSaved, Connection connection);
//	public void updateUser(User user);
//	public void deleteUSer(User user);
}
