package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Rewards;

public class RewardsDao {
	private Connection connection;
	private final String GET_REWARD_BY_ID = "SELECT * FROM Rewards WHERE id = ?";
	private final String ADD_REWARD_By_ID = "INSERT INTO Rewards(name, required_points, reward_description, discount) VALUES(?, ?, ?, ?";
	private final String DELETE_REWARD_BY_ID = "DELETE FROM Rewards WHERE id = ?";
	private final String UPDATE_REWARD_BY_ID = "UPDATE Rewards SET name = ?, required_points = ?, reward_description = ?, discount = ? WHERE id = ?";
	
	public RewardsDao() {
		connection = DBConnection.getConnection();
	}
	
	public void updateRewardById(String name, int requiredPoints, String rewardDescription, int discount, int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_REWARD_BY_ID);
		ps.setString(1, name);
		ps.setInt(2, requiredPoints);
		ps.setString(3, rewardDescription);
		ps.setInt(4, discount);
		ps.setInt(5, id);
		ps.executeUpdate();
	}
	
	public Rewards getRewardById(int customerId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_REWARD_BY_ID);
		ps.setInt(1, customerId);
		ResultSet rs = ps.executeQuery();
		return new Rewards(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
	}
	
	public void addReward(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(ADD_REWARD_By_ID);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public void deleteRewardById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_REWARD_BY_ID);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
}
