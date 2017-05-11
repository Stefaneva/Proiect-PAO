package validators;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginValidator {

	/*public int authentication(String userName,String password){
		if(userName!=null&&!(userName.trim().equals("")))
		{
			try{
				Connection connection;
				MyDBConnection mdbc=new MyDBConnection();
				mdbc.setConnection();
				connection=mdbc.getConnection();
//				String SQL="select USER_NAME,PASSWORD,ID from USERS_PROJECT";
				String SQL="select USERNAME,PASS,ID from USERSPAO";
				PreparedStatement pstm=connection.prepareStatement(SQL);
				ResultSet rs=pstm.executeQuery();
				while(rs.next())
				{
					String us=rs.getString("USERNAME");
					String pass=rs.getString("PASS");
					int id=Integer.parseInt(rs.getString("ID"));
					System.out.println(us+" "+pass);
					if(us.equals(userName)&&pass.equals(password))
						return id;
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return 0;
	}*/
	public int authentication(String userName,String password,Connection connection){
		if(userName!=null&&!(userName.trim().equals("")))
		{
			try{
				String SQL="select USERNAME,PASS,ID from USERSPAO";
				PreparedStatement pstm=connection.prepareStatement(SQL);
				ResultSet rs=pstm.executeQuery();
				while(rs.next())
				{
					String us=rs.getString("USERNAME");
					String pass=rs.getString("PASS");
					int id=Integer.parseInt(rs.getString("ID"));
					if(us.equals(userName)&&pass.equals(password))
					return id;
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return 0;
	}
}
