package application;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import dao.ReservationsDao;
import dao.CustomersDao;
import entity.Customers;
import entity.Reservations;

public class Menu {
	
	private ReservationsDao ReservationDao = new ReservationsDao();
	private CustomersDao CustomerDao = new CustomersDao();
	private Scanner scanner = new Scanner(System.in);
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
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			
			System.out.println("Press enter to continue...");
			scanner.nextLine();
		} while (!selection.equals("-1"));
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
	}

	private void displayAllReservations() throws SQLException {
		List<Reservations> reservations = ReservationDao.getAllReservations();
		for (Reservations reservation : reservations) {
		System.out.println("Reservation ID: " + reservation.getCustomerId() + ", " + "Room Number: " + reservation.getRoom() + ", " + "Start Date: " +
				reservation.getStartDate() + ", " + "End Date: " + reservation.getEndDate() + ", " + "Points Earned: " + reservation.getPointsEarned() + ", " +
				"Reward Level" + reservation.getRewardLevel() + ", " + "Customer ID: " + reservation.getCustomerId() + ", " + "Bill ID" + reservation.getBillId());
		}
		
	}

	private void printMenu() {
		System.out.println("Please Select an Option... \n-----------------------");
		for(int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
	private void displayCustomers() throws SQLException {
		List<Customers> customers = CustomerDao.getCustomers();
		for(Customers customer : customers) {
			System.out.println(customer.getCustomersId() + ": " + "First Name: " + customer.getFirstName()+ ", " + 
							   " Last Name: " +  customer.getLastName() + ", " + "Email Address: " + customer.getEmailAddress() +
							   ", " + " Phone Number: " + customer.getPhoneNumber() + ", " + "Point's Held: " + customer.getPointsHeld());
		}
	}
	
	
	private void displayCustomer() throws SQLException {
		System.out.print("Enter the Customer ID: ");
		int id = Integer.parseInt(scanner.nextLine());
		Customers customers = CustomerDao.getCustomerById(id);
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
		
		CustomerDao.addCustomer(firstName, lastName, emailAddress, phoneNumber);
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
		
		CustomerDao.updateExistingCustomer(id, firstName, lastName, email, phoneNumber);
	}
	
	public void deleteCustomer() throws SQLException {
		System.out.print("Enter Customer ID to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		CustomerDao.DeleteCustomerByID(id);
	}
}
