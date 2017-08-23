package csdc.demo.domain;

import java.util.Date;

public class Customer {
	private Integer id;
	private String customerName;
	private String email;
	private Date time;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName
				+ ", email=" + email + ", time=" + time + "]";
	}
	
}
