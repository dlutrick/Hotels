package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Billings;

public class BillingsDao {
	private Connection connection;
	private final String DISPLAY_BILLING_BY_ID_QUERY = "SELECT * FROM Billing WHERE customer_id = ?";
	private final String ADD_BILLING_BY_ID_QUERY = "INSERT INTO Billing(name, required_points, required_description, discount) VALUES(?, ?, ?, ?)";
	private final String DELETE_BILLING_BY_ID = "DELETE FROM Billing WHERE id = ?";
	private final String UPDATE_BILLING_INFO_BY_ID = "UPDATE Billing SET state = ?, street = ?, zipcode = ? WHERE customer_id = ?";
	
	public BillingsDao() {
		connection = DBConnection.getConnection();
	}
	
	public void updateBillingInfoById(String state, String street, String zipcode, int customerId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_BILLING_INFO_BY_ID);
		ps.setString(1, street);
		ps.setString(2, state);
		ps.setString(3, zipcode);
		ps.setInt(4, customerId);
		ps.executeUpdate();
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
	
	public void deleteBillingById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_BILLING_BY_ID);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
}
