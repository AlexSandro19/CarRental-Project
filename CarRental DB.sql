DROP DATABASE IF EXISTS carRental;
CREATE DATABASE carRental;

USE carRental;


CREATE TABLE carTypes(
	carType_id		INT				PRIMARY KEY		NOT NULL		AUTO_INCREMENT,
    car_type		VARCHAR(20)		UNIQUE			NOT NULL,
    transmission	VARCHAR(20)						NOT NULL,
    eng_volume		DECIMAL(2,1)					NOT NULL,
    air_con			TINYINT							NOT NULL,
    cruise_control	TINYINT							NOT NULL,
	seats			VARCHAR(3)						NOT NULL,
	hp				int								NOT NULL
);

CREATE TABLE cars(
	car_id			INT				PRIMARY KEY		NOT NULL		AUTO_INCREMENT,
    brand			VARCHAR(20)						NOT NULL,
    model			VARCHAR(20)		UNIQUE			NOT NULL,
    reg_num			VARCHAR(7)		UNIQUE			NOT NULL,
    reg_date		DATE							NOT NULL,
    mileage			INT								NOT NULL,
	carType_id		INT,	
    
    FOREIGN KEY (carType_id)
		REFERENCES carTypes (carType_id)
);

CREATE TABLE customers(
	customer_id		INT				PRIMARY KEY		NOT NULL		AUTO_INCREMENT,
	first_name		VARCHAR(30)						NOT NULL,
    last_name		VARCHAR(30)						NOT NULL,
	address			VARCHAR(40)						NOT NULL,
    city			VARCHAR(20)						NOT NULL,
    zip				VARCHAR(4)						NOT NULL,
    country			VARCHAR(20)						NOT NULL,
    mobile_phone	VARCHAR(8)						NOT NULL,
    addit_phone		VARCHAR(8),
    email			VARCHAR(30)						NOT NULL,
    driver_license	VARCHAR(20)						NOT NULL,
    driver_since	DATE							NOT NULL
);

CREATE TABLE contracts(
	contract_id		INT				PRIMARY KEY		NOT NULL		AUTO_INCREMENT,
	renter_id		INT								NOT NULL,
    car_id			INT								NOT NULL,
    start_date 		DATETIME						NOT NULL,
    end_date		DATETIME						NOT NULL,
	max_km			INT								NOT NULL,
    start_km		INT								NOT NULL,
    
    FOREIGN KEY (renter_id)
		REFERENCES customers (customer_id),
        
	FOREIGN KEY (car_id)
		REFERENCES cars (car_id)
);
