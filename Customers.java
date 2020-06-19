package entity;

public class Customers {
	
	private int customersId;
	private String firstName;
	private String lastName;
	private String email_address;
	private String phone_number;
	private int points_held;
	
	public Customers(int customerId, String firstName, String lastName, String email_address, String phone_number, int points_held) {
		this.setCustomersId(customerId);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail_address(email_address);
		this.setPhone_number(phone_number);
		this.setPoints_held(points_held);
	}

	public int getCustomersId() {
		return customersId;
	}

	public void setCustomersId(int customersId) {
		this.customersId = customersId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public int getPoints_held() {
		return points_held;
	}

	public void setPoints_held(int points_held) {
		this.points_held = points_held;
	}
}