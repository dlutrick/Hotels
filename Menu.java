package Application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.CustomerDao;
import entity.Customers;

public class Menu {
	
	private CustomerDao CustomerDao = new CustomerDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Customers",
			"Display a Customer",
			"Add a new Customer",
			"Update an Existing Customer",
			"Delete a Customer");
	
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
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			
			System.out.println("Press enter to continue...");
			scanner.nextLine();
		} while (!selection.equals("-1"));
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
							   " Last Name: " +  customer.getLastName() + ", " + "Email Address: " + customer.getEmail_address() +
							   ", " + " Phone Number: " + customer.getPhone_number() + ", " + "Point's Held: " + customer.getPoints_held());
		}
	}
	
	
	private void displayCustomer() throws SQLException {
		System.out.print("Enter the Customer ID: ");
		int id = Integer.parseInt(scanner.nextLine());
		Customers customers = CustomerDao.getCustomerById(id);
		System.out.println(customers.getCustomersId() + ": " + "First Name: " + customers.getFirstName()+ ", " + 
				   " Last Name: " +  customers.getLastName() + ", " + "Email Address: " + customers.getEmail_address() +
				   ", " + " Phone Number: " + customers.getPhone_number() + ", " + "Point's Held: " + customers.getPoints_held());
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
	
	
	
	









