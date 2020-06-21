package entity;

public class Rewards {
	private int id;
	private String name;
	private int requiredPoints;
	private String rewardDescription;
	private int discount;
	
	public Rewards(int id, String name, int requiredPoints, String rewardDescription, int discount) {
		this.id = id;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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