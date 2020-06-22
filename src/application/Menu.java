package application;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.BillingsDao;
import dao.CustomersDao;
import dao.ReservationsDao;
import dao.RewardsDao;
import entity.Customers;
import entity.Reservations;

public class Menu {
	private Scanner scanner = new Scanner(System.in);
	private BillingsDao billingsDao = new BillingsDao();
	private RewardsDao rewardsDao = new RewardsDao();
	private ReservationsDao ReservationDao = new ReservationsDao();
	private CustomersDao customerDao = new CustomersDao();
	private List<String> options = Arrays.asList(
			"Display Customers",
			"Display a Customer",
			"Add a new Customer",
			"Update an Existing Customer",
			"Delete a Customer",
			"Display all Reservations",
			"Display a Reservation",
			"Add a new Reservation",
			"Update a Reservation",
			"Delete a Reservation",
			"Display Billing By ID", 
			"Add Billing By ID", 
			"Delete Billing By ID", 
			"Update Billing By ID", 
			"Get Reward By ID", 
			"Add Reward", 
			"Delete Reward",
			"Update Reward By ID",
			"Delete a Reservation");
    
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
				if(selection.equals("1")) {
					displayCustomers();
				} else if (selection.equals("2")) {
					displayCustomer();
				} else if (selection.equals("3")) {
					addCustomer();
				} else if (selection.equals("4")) {
					updateCustomer();
				} else if (selection.equals("5")) {
					deleteCustomer();
				} else if (selection.equals("6")) {
					displayAllReservations();
				} else if (selection.equals("7")) {
					displayReservation();
				} else if (selection.equals("8")) {
					addReservation();
				} else if (selection.equals("9")) {
					updateReservation();
				} else if (selection.equals("10")) {
					deleteReservation();
				} else if (selection.equals("11")) {
					displayBillingById();
				} else if (selection.equals("12")) {
					addBillingById();
				} else if (selection.equals("13")) {
					deleteBillingById();
				} else if (selection.equals("14")) {
					updateBillingById();
				} else if (selection.equals("15")) {
					displayRewardById();
				} else if (selection.equals("16")) {
					addRewardById();
				} else if (selection.equals("17")) {
					deleteRewardById();
				} else if (selection.equals("18")) {
					updateRewardById();
				}
			} catch(SQLException e) {
				e.getStackTrace();
			}
			
		} while(!selection.equals("-1"));
	}
	
	public void printMenu() {
		int number = 1;
		System.out.println("Please make a selection...");
		for(String option : options) {
			System.out.println(number + ")" + " " + option);
			number++;
		}
	}
	
	public void updateRewardById() throws SQLException {
		System.out.println("Enter ID: ");
		int id = scanner.nextInt();
		System.out.println("Enter Name: ");
		String name = scanner.nextLine();
		System.out.println("Enter Required Points: ");
		int requiredPoints = scanner.nextInt();
		System.out.println("Enter Reward Description: ");
		String rewardDescription = scanner.nextLine();
		System.out.println("Enter Discount: ");
		int discount = scanner.nextInt();
		rewardsDao.updateRewardById(name, requiredPoints, rewardDescription, discount, id);
	}
	
	public void updateBillingById() throws SQLException {
		System.out.println("Enter customer ID: ");
		int customerId = scanner.nextInt();
		System.out.println("Enter state: ");
		String state = scanner.nextLine();
		System.out.println("Enter street: ");
		String street = scanner.nextLine();
		System.out.println("Enter zipcode: ");
		String zipcode = scanner.nextLine();
		billingsDao.updateBillingInfoById(state, street, zipcode, customerId);
	}
	
	public void displayBillingById() throws SQLException {
		System.out.println("Please enter a customer ID: ");
		int customerId = scanner.nextInt();
		billingsDao.displayBillingById(customerId);
	}
	
	public void addBillingById() throws SQLException {
		System.out.println("Please enter a customer ID: ");
		int customerId = scanner.nextInt();
		System.out.println("Please enter state: ");
		String state = scanner.nextLine();
		System.out.println("Please enter street: ");
		String street = scanner.nextLine();
		System.out.println("Please enter zipcode: ");
		String zipcode = scanner.nextLine();
		
		billingsDao.addBillingById(customerId, state, street, zipcode);
	}
	
	public void deleteBillingById() throws SQLException {
		System.out.println("Please enter an ID: ");
		int id = scanner.nextInt();
		
		billingsDao.deleteBillingById(id);
	}
	
	public void displayRewardById() throws SQLException {
		System.out.println("Please enter an ID: ");
		int id = scanner.nextInt();
		rewardsDao.getRewardById(id);
	}
	
	public void addRewardById() throws SQLException {
		System.out.println("Please enter an ID: ");
		int id = scanner.nextInt();
		rewardsDao.addReward(id);
	}
	
	public void deleteRewardById() throws SQLException {
		System.out.println("Please enter an ID: ");
		int id = scanner.nextInt();
		rewardsDao.deleteRewardById(id);
	}
	
	private void deleteReservation() throws SQLException {
		System.out.println("Warning, This will Delete Reservation. \n PLease enter Reservation ID:");
		int id = Integer.parseInt(scanner.nextLine());
		ReservationDao.deleteReservation(id);
	}

	private void updateReservation() throws SQLException {
		System.out.println("Please enter Reservation ID:");
		int id = Integer.parseInt(scanner.nextLine());
		
		System.out.print("Please enter Room Number: ");
		int room = Integer.parseInt(scanner.nextLine());
		
		System.out.print("Please enter Start Date as YYYY-MM-DD: ");
		Date startDate = java.sql.Date.valueOf(scanner.nextLine());
		
		System.out.print("Please enter End Date as YYYY-MM-DD: ");
		Date endDate = java.sql.Date.valueOf(scanner.nextLine());
		
		System.out.print("Please enter Points Earned: ");
		int pointsEarned = Integer.parseInt(scanner.nextLine());
		
		System.out.print("Please enter Customer ID number: ");
		int customerId = Integer.parseInt(scanner.nextLine());
		
		System.out.print("Please enter Customers Reward Level: ");
		int rewardLevel = Integer.parseInt(scanner.nextLine());
		
		System.out.print("Please enter Billing ID: ");
		int billId = Integer.parseInt(scanner.nextLine());
		
		ReservationDao.updateReservation(id, room, startDate, endDate, pointsEarned, customerId, rewardLevel, billId);
		
	}

	private void addReservation() throws SQLException {
		System.out.print("Please enter Room Number: ");
		int room = Integer.parseInt(scanner.nextLine());
		
		System.out.print("Please enter Start Date as YYYY-MM-DD: ");
		Date startDate = java.sql.Date.valueOf(scanner.nextLine());
		
		System.out.print("Please enter End Date as YYYY-MM-DD: ");
		Date endDate = java.sql.Date.valueOf(scanner.nextLine());
		
		System.out.print("Please enter Points Earned: ");
		int pointsEarned = Integer.parseInt(scanner.nextLine());
		
		System.out.print("Please enter Customer ID number: ");
		int customerId = Integer.parseInt(scanner.nextLine());
		
		System.out.print("Please enter Customers Reward Level: ");
		int rewardLevel = Integer.parseInt(scanner.nextLine());
		
		System.out.print("Please enter Billing ID: ");
		int billId = Integer.parseInt(scanner.nextLine());
		
		ReservationDao.createNewReservation(room, startDate, endDate, pointsEarned, customerId, rewardLevel, billId);
		
	}

	private void displayReservation() throws SQLException {
		System.out.print("Enter the Customer ID: ");
		int id = Integer.parseInt(scanner.nextLine());
		Reservations tempRes = ReservationDao.getReservation(id);
		System.out.println("Reservation ID: " + tempRes.getCustomerId() + ", " + "Room Number: " + tempRes.getRoom() + ", " + "Start Date: " +
				tempRes.getStartDate() + ", " + "End Date: " + tempRes.getEndDate() + ", " + "Points Earned: " + tempRes.getPointsEarned() + ", " +
				"Reward Level" + tempRes.getRewardLevel() + ", " + "Customer ID: " + tempRes.getCustomerId() + ", " + "Bill ID" + tempRes.getBillId());
		}

	private void displayAllReservations() throws SQLException {
		List<Reservations> reservations = ReservationDao.getAllReservations();
		for (Reservations reservation : reservations) {
		System.out.println("Reservation ID: " + reservation.getCustomerId() + ", " + "Room Number: " + reservation.getRoom() + ", " + "Start Date: " +
				reservation.getStartDate() + ", " + "End Date: " + reservation.getEndDate() + ", " + "Points Earned: " + reservation.getPointsEarned() + ", " +
				"Reward Level" + reservation.getRewardLevel() + ", " + "Customer ID: " + reservation.getCustomerId() + ", " + "Bill ID" + reservation.getBillId());
		}
		
	}
  
	private void displayCustomers() throws SQLException {
		List<Customers> customers = customerDao.getCustomers();
		for(Customers customer : customers) {
			System.out.println(customer.getCustomersId() + ": " + "First Name: " + customer.getFirstName()+ ", " + 
							   " Last Name: " +  customer.getLastName() + ", " + "Email Address: " + customer.getEmailAddress() +
							   ", " + " Phone Number: " + customer.getPhoneNumber() + ", " + "Point's Held: " + customer.getPointsHeld());
		}
	}
	
	
	private void displayCustomer() throws SQLException {
		System.out.print("Enter the Customer ID: ");
		int id = Integer.parseInt(scanner.nextLine());
		Customers customers = customerDao.getCustomerById(id);
		System.out.println(customers.getCustomersId() + ": " + "First Name: " + customers.getFirstName()+ ", " + 
				   " Last Name: " +  customers.getLastName() + ", " + "Email Address: " + customers.getEmailAddress() +
				   ", " + " Phone Number: " + customers.getPhoneNumber() + ", " + "Point's Held: " + customers.getPointsHeld());
	}
	
	private void addCustomer() throws SQLException {
		
		System.out.print("Please enter Customer's First Name: ");
		String firstName = scanner.nextLine();
		
		System.out.print("Please enter Customer's Last Name: ");
		String lastName = scanner.nextLine();
		
		System.out.print("Please enter Customer's Email Address: ");
		String emailAddress = scanner.nextLine();
		
		System.out.print("Please enter Customers Phone Number: ");
		String phoneNumber = scanner.nextLine();
		
		customerDao.addCustomer(firstName, lastName, emailAddress, phoneNumber);
	}
	
	public void updateCustomer() throws SQLException {
		System.out.print("Please enter the customer ID you want to update: ");
		int id = Integer.parseInt(scanner.nextLine());
		
		System.out.print("Please enter the First Name: ");
		String firstName = scanner.nextLine();
		
		System.out.print("Please enter the Last Name: ");
		String lastName = scanner.nextLine();
		
		System.out.print("Please enter the Email Address: ");
		String email = scanner.nextLine();
		
		System.out.print("Please enter the Phone Number: ");
		String phoneNumber = scanner.nextLine();
		
		customerDao.updateExistingCustomer(id, firstName, lastName, email, phoneNumber);
	}
	
	public void deleteCustomer() throws SQLException {
		System.out.print("Enter Customer ID to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		customerDao.DeleteCustomerByID(id);
	}
}

