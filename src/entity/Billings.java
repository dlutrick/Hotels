package entity;

public class Billings {

	private int id;
	private int customerId;
	private String state;
	private String street;
	private String zipcode;
	
	private Billings(int id, int customerId, String state, String street, String zipcode) {
		this.id = id;
		this.customerId = customerId;
		this.state = state;
		this.street = street;
		this.zipcode = zipcode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
}
