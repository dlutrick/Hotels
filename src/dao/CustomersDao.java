package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Customers;

public class CustomerDao {

	private Connection connection;
	private final String GET_CUSTOMERS_QUERY = "SELECT * FROM Customers";
	private final String GET_CUSTOMER_BY_ID_QUERY = "SELECT * FROM Customers WHERE id = ?";
	private final String ADD_NEW_CUSTOMER_QUERY = "INSERT INTO Customers(first_name, last_name, email, phone_number) VALUES(?,?,?,?)";
	private final String UPDATE_EXISTING_CUSTOMER_QUERY = "UPDATE Customers SET first_name = ?,  last_name = ?, email = ?, phone_number = ? WHERE id =?";
	private final String DELETE_CUSTOMER_BY_ID_Q_QUERY = "DELETE FROM Customers WHERE id = ?";
	
	public CustomerDao() {
		connection = DBconnection.getConnection();
	}
	
	public List<Customers> getCustomers() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_CUSTOMERS_QUERY).executeQuery();
		List<Customers> customers = new ArrayList<Customers>();
		
		while (rs.next()) {
			customers.add(populateCustomers(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
		}
		return customers;
	}
	
	public Customers getCustomerById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_CUSTOMER_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateCustomers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
	}
	
	public void addCustomer(String firstName, String lastName, String emailAddress, String phoneNumber) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(ADD_NEW_CUSTOMER_QUERY);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, emailAddress);
		ps.setString(4, phoneNumber);
		ps.executeUpdate();
	}
	
	public void updateExistingCustomer(int id, String firstName, String lastName, String emailAddress, String phoneNumber) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_EXISTING_CUSTOMER_QUERY);
		ps.setInt(1, id);
		ps.setString(2, firstName);
		ps.setString(3, lastName);
		ps.setString(4, emailAddress);
		ps.setString(5, phoneNumber);
		ps.executeUpdate();
	}
	
	public void DeleteCustomerByID(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_CUSTOMER_BY_ID_Q_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	
	
	private Customers populateCustomers(int id, String firstName, String lastName, String emailAddress, String phoneNumber, int points) {
		return new Customers(id, firstName, lastName, emailAddress, phoneNumber, points);
	}
	
}

