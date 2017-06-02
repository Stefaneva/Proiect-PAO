package entity;

public class User {
	private int id;
	private String name;
	private String password;
	private String email;
	private String address;
	private String userRole;
	private long phone;
	public User(){
		
	}
	public User(String name,String pass,String email,String address,long phone){
		this.name=name;
		this.password=pass;
		this.email=email;
		this.address=address;
//		this.UserRole=role;
		this.phone=phone;
	}
	
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	@Override
	public String toString()
	{
		return this.getName()+" "+this.getPassword()+" "+this.getAddress()+" "+this.getEmail()+" "+this.getId()+" "+this.getUserRole();
	}
}
