package entity;

import java.util.Date;

public class Reservations {
	private int id;
	private int room;
	private Date startDate;
	private Date endDate;
	private int pointsEarned;
	private int customerId;
	private int rewardLevel;
	private int billId;

	private Reservations (int id, int room, Date startDate, Date endDate, int pointsEarned,
			int customerId, int rewardLevel, int billId) {
		this.id = id;
		this.room = room;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pointsEarned = pointsEarned;
		this.customerId = customerId;
		this.rewardLevel = rewardLevel;
		this.billId = billId;
	}
	public int getId() {
		return id;
	}
	public int getRoom() {
		return room;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public int getPointsEarned() {
		return pointsEarned;
	}
	public int getCustomerId() {
		return customerId;
	}
	public int getRewardLevel() {
		return rewardLevel;
	}
	public int billId() {
		return billId;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public void setPointsEarned(int pointsEarned) {
		this.pointsEarned = pointsEarned;
	}
	public void setCustomerId (int customerId) {
		this.customerId = customerId;
	}
	public void setRewardLevel (int rewardLevel) {
		this.rewardLevel = rewardLevel;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
}	
