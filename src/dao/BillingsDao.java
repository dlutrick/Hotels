package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Billings;

public class BillingsDao {
	private Connection connection;
	private final String DISPLAY_BILLING_BY_ID_QUERY = "SELECT * FROM billing WHERE customer_id = ?";
	private final String ADD_BILLING_BY_ID_QUERY = "INSERT INTO billing(name, required_points, required_description, discount) VALUES(?, ?, ?, ?)";
	private final String DELETE_BILLING_BY_ID = "DELETE FROM billing WHERE customer_id = ?";
	
	public BillingsDao() {
		connection = DBConnection.getConnection();
	}
	
	public Billings displayBillingById(int customerId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DISPLAY_BILLING_BY_ID_QUERY);
		ps.setInt(1, customerId);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return new Billings(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
	}
	
	public void addBillingById(int customerId, String state, String street, String zipcode) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(ADD_BILLING_BY_ID_QUERY);
		ps.setInt(1, customerId);
		ps.setString(2, state);
		ps.setString(3, street);
		ps.setString(4, zipcode);
		ps.executeUpdate();
	}
	
	public void deleteBillingById(int customerId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_BILLING_BY_ID);
		ps.setInt(1, customerId);
		ps.executeUpdate();
	}
}
