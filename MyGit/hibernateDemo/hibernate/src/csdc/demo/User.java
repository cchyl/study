package csdc.demo;

public class User {
	private int uid;
	private String userName;
	private String password;
	private String address;
	
	public User() {
		super();
	}

	public User(int uid, String userName, String password, String address) {
		super();
		this.uid = uid;
		this.userName = userName;
		this.password = password;
		this.address = address;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}
