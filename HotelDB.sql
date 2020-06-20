CREATE DATABASE IF NOT EXISTS HotelDB;

USE HotelDB;

DROP TABLE if exists Customers;
DROP TABLE IF EXISTS Rewards;
DROP TABLE IF EXISTS Billing;

CREATE TABLE Customers (
	id INT(11) NOT NULL auto_increment,
	first_name VARCHAR(20) NOT NULL,
        last_name VARCHAR(20) NOT NULL,
        email VARCHAR (320) NOT NULL,
        phone_number (10) NOT NULL,
        points_held CHAR(8)
        PRIMARY KEY (id)
);

CREATE TABLE Billing(
    id INT(11) NOT NULL AUTO_INCREMENT,
    customer_id INT(11) NOT NULL,
    state VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    zipcode VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
    FOREIGN KEY(customer_id) REFERENCES customers(id)
);

CREATE TABLE Rewards(
    id INT(11) NOT NULL AUTO_INCREMENT,
    customer_id INT(11) NOT NULL,
    required_points INT(11) NOT NULL,
    reward_description VARCHAR(255) NOT NULl,
    discount INT(10) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(customer_id) REFERENCES customers(id)
);

