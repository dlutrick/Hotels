package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Reservations;

public class ReservationsDao {
	
	private static Connection connection;
	
	private final  String SELECT_ALL_RESERVATIONS_QUERY = "SELECT * FROM reservations";
	private final  String SELECT_RESERVATION_BY_ID_QUERY = "SELECT * FROM reservations WHERE id = ?";
	private final  String CREATE_RESERVATION_QUERY = "INSERT INTO reservations (room, start_date, end_date, points_earned, customer_id, reward_level, bill_id) VALUES (?,?,?,?,?,?,?)";
	private final  String UPDATE_RESERVATION_QUERY = "UPDATE reservations SET room = ?, start_date = ?, "
			+ "end_date = ?, points_earned = ?, customer_id = ?, reward_level =? WHERE id = ?";
	private final  String DELETE_RESERVATION_QUERY = "DELETE * FROM reservations where id = ?";
	
	public ReservationsDao() {
		connection = DBConnection.getConnection();
	}
	
	public  List<Reservations> getAllReservations () throws SQLException{
		ResultSet rs = connection.prepareStatement(SELECT_ALL_RESERVATIONS_QUERY).executeQuery();
		List<Reservations> reservations = new ArrayList<Reservations>();
		while(rs.next()) {
			Reservations TempRes = new Reservations(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDate(4), rs.getInt(5), rs.getInt(6), rs.getInt(7),
					rs.getInt(8));
			reservations.add(TempRes);
		}
		return reservations;
	}
	
	public  Reservations getReservation (int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(SELECT_RESERVATION_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return new Reservations(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDate(4), rs.getInt(5), rs.getInt(6), rs.getInt(7),
				rs.getInt(8));
	}
	
	public  void createNewReservation (int room, java.sql.Date startDate, java.sql.Date endDate, 
			int pointsEarned, int customerId, int rewardLevel, int billId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_RESERVATION_QUERY);
		ps.setInt(1, room);
		ps.setDate(2, startDate);
		ps.setDate(3, endDate);
		ps.setInt(4, pointsEarned);
		ps.setInt(5, customerId);
		ps.setInt(6, rewardLevel);
		ps.setInt(7, billId);
		ps.executeUpdate();
	}
	
	public  void updateReservation (int id, int room, java.sql.Date startDate, java.sql.Date endDate, 
			int pointsEarned, int customerId, int rewardLevel, int billId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_RESERVATION_QUERY);
		ps.setInt(1, room);
		ps.setDate(2, startDate);
		ps.setDate(3, endDate);
		ps.setInt(4, pointsEarned);
		ps.setInt(5, customerId);
		ps.setInt(6, rewardLevel);
		ps.setInt(7, billId);
		ps.setInt(8, id);
		ps.executeUpdate();
	}
	
	public  void deleteReservation (int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_RESERVATION_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
		
	}
}
