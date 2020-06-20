package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.BillingsDao;
import dao.RewardsDao;

public class Menu {
	private Scanner scanner = new Scanner(System.in);
	private BillingsDao billingsDao = new BillingsDao();
	private RewardsDao rewardsDao = new RewardsDao();
	private List<String> options = Arrays.asList(
			"Display Billing By ID", 
			"Add Billing By ID", 
			"Delete Billing By ID", 
			"Get Reward By ID", 
			"Add Reward", 
			"Delete Reward");
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
				if(selection.equals("1")) {
					displayBillingById();
				} else if(selection.equals("2")) {
					addBillingById();
				} else if(selection.equals("3")) {
					deleteBillingById();
				} else if(selection.equals("4")) {
					displayRewardById();
				} else if(selection.equals("5")) {
					addRewardById();
				} else if(selection.equals("6")) {
					deleteRewardById();
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
		System.out.println("Please enter a customer ID: ");
		int customerId = scanner.nextInt();
		
		billingsDao.deleteBillingById(customerId);
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
}
