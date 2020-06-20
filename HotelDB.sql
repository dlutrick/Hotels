CREATE DATABASE IF NOT EXISTS HotelDB;
use HotelDB;
DROP TABLE IF EXISTS Reservations;
DROP TABLE IF EXISTS Rewards;
DROP TABLE IF EXISTS Billing;
DROP TABLE IF EXISTS Customers;
CREATE TABLE Customers(
	id int(11) NOT NULL auto_increment,
	first_name varchar(20) NOT NULL,
	last_name varchar(20) NOT NULL,
	email varchar(30) NOT NULL,
	phone_number int(10) NOT NULL,
	points_held int(4),
	PRIMARY KEY (id)
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
CREATE TABLE Rewards(
	id int(11) NOT NULL auto_increment,
	name varchar(10) NOT NULL,
	req_points int(10) NOT NULL,
	reward_desc varchar(255) NOT NULL,
	discount int(3) NOT NULL,
	PRIMARY KEY (id)
);
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
);