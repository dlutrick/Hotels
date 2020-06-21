CREATE DATABASE IF NOT EXISTS HotelDB;

use HotelDB;

DROP TABLE IF EXISTS Reservations;
DROP TABLE IF EXISTS Rewards;
DROP TABLE IF EXISTS Billing;
DROP TABLE IF EXISTS Customers;

CREATE TABLE Reservations(
	id int(11) NOT NULL auto_increment,
	room int(3) NOT NULL,
	start_date date NOT NULL,
	end_date date NOT NULL,
	points_earned int(4) NOT NULL,
	customer_id int(11) NOT NULL,
	reward_level int(11) NOT NULL,
	bill_id int(11) NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (customer_id) REFERENCES Customers(id),
	FOREIGN KEY (reward_level) REFERENCES Rewards(id),
	FOREIGN KEY (bill_id) REFERENCES Billing(id)

CREATE TABLE Rewards(
  id INT(11) NOT NULL AUTO_INCREMENT,
  customer_id INT(11) NOT NULL,
  required_points INT(11) NOT NULL,
  reward_description VARCHAR(255) NOT NULl,
  discount INT(10) NOT NULL,
  RIMARY KEY(id),
   FOREIGN KEY(customer_id) REFERENCES customers(id)
);

CREATE TABLE Billing(
	id int(11) NOT NULL auto_increment,
	customer_id int(11) NOT NULL,
	state varchar(255) NOT NULL,
	street varchar(255) NOT NULL,
	zipcode varchar(255) NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (id) REFERENCES Customers(id)
);

CREATE TABLE Customers (
	id INT(11) NOT NULL auto_increment,
	first_name VARCHAR(20) NOT NULL,
  last_name VARCHAR(20) NOT NULL,
  email VARCHAR (320) NOT NULL,
  phone_number (10) NOT NULL,
  points_held CHAR(8)
  PRIMARY KEY (id)
);