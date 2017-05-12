package entity;

public class User {
	private String Name;
	private String Password;
	private String Email;
	private String Address;
	private int Id;
	private String UserRole;
	private int phone;
	public User(){
		
	}
	public User(String name,String pass,String email,String address,int phone,String role){
		this.Name=name;
		this.Password=pass;
		this.Email=email;
		this.Address=address;
		this.UserRole=role;
		this.phone=phone;
	}
	
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getName() {
		return Name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUserRole() {
		return UserRole;
	}
	public void setUserRole(String userRole) {
		UserRole = userRole;
	}
	@Override
	public String toString()
	{
		return this.getName()+" "+this.getPassword()+" "+this.getAddress()+" "+this.getEmail()+" "+this.getId()+" "+this.getUserRole();
	}
}
