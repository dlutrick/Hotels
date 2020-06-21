CREATE DATABASE IF NOT EXISTS HotelDB;

USE HotelDB;

DROP TABLE IF EXISTS Reservations;
DROP TABLE IF EXISTS Rewards;
DROP TABLE IF EXISTS Billing;
DROP TABLE IF EXISTS Customers;

CREATE TABLE Customers (
	id INT(11) NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    email VARCHAR(320) NOT NULL,
    phone_number VARCHAR(10) NOT NULL,
    points_held CHAR(8),
    PRIMARY KEY (id)
);

CREATE TABLE Rewards (
    id INT(11) NOT NULL AUTO_INCREMENT,
    customer_id INT(11) NOT NULL,
    required_points INT(11) NOT NULL,
    reward_description VARCHAR(255) NOT NULL,
    discount INT(10) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(customer_id) REFERENCES Customers(id)
);

CREATE TABLE Billing (
	id int(11) NOT NULL AUTO_INCREMENT,
	customer_id INT(11) NOT NULL,
	state VARCHAR(255) NOT NULL,
	street VARCHAR(255) NOT NULL,
	zipcode VARCHAR(255) NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (id) REFERENCES Customers(id)
);

CREATE TABLE Reservations (
	id int(11) NOT NULL AUTO_INCREMENT,
	room int(3) NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE NOT NULL,
	points_earned INT(4) NOT NULL,
	customer_id INT(11) NOT NULL,
	reward_level INT(11) NOT NULL,
	bill_id INT(11) NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (customer_id) REFERENCES Customers(id),
	FOREIGN KEY (reward_level) REFERENCES Rewards(id),
	FOREIGN KEY (bill_id) REFERENCES Billing(id)
);