CREATE DATABASE IF exists reservations;

use reservations;

DROP TABLE if exists Customers;
DROP TABLE if exists Reservations;
DROP TABLE if exists Rewards;
DROP TABLE if exists Billing;

CREATE TABLE Customers (
	id INT(11) NOT NULL auto_increment,
	first_name VARCHAR(20) NOT NULL,
        last_name VARCHAR(20) NOT NULL,
        email VARCHAR (320) NOT NULL,
        phone_number (10) NOT NULL,
        points_held CHAR(8)
        PRIMARY KEY (id)
);


