package entity;

public class Customers {
		
		private int customersId;
		private String firstName;
		private String lastName;
		private String emailAddress;
		private String phoneNumber;
		private int pointsHeld;
		
		public Customers(int customerId, String firstName, String lastName, String emailAddress, String phoneNumber, int pointsHeld) {
			this.setCustomersId(customerId);
			this.setFirstName(firstName);
			this.setLastName(lastName);
			this.setEmailAddress(emailAddress);
			this.setPhoneNumber(phoneNumber);
			this.setPointsHeld(pointsHeld);
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

		public String getEmailAddress() {
			return emailAddress;
		}

		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public int getPointsHeld() {
			return pointsHeld;
		}

		public void setPointsHeld(int pointsHeld) {
			this.pointsHeld = pointsHeld;
		}	
}
