package entity;

public class Rewards {
	private int id;
	private int customerId;
	private int requiredPoints;
	private String rewardDescription;
	private int discount;
	
	private Rewards(int id, int customerId, int requiredPoints, String rewardDescription, int discount) {
		this.id = id;
		this.customerId = customerId;
		this.requiredPoints = requiredPoints;
		this.rewardDescription = rewardDescription;
		this.discount = discount;
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

	public int getRequiredPoints() {
		return requiredPoints;
	}

	public void setRequiredPoints(int requiredPoints) {
		this.requiredPoints = requiredPoints;
	}

	public String getRewardDescription() {
		return rewardDescription;
	}

	public void setRewardDescription(String rewardDescription) {
		this.rewardDescription = rewardDescription;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
}
