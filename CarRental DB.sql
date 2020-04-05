DROP DATABASE IF EXISTS carRental;
CREATE DATABASE carRental;

USE carRental;

-- Create all tables

CREATE TABLE carTypes(
	carType_id		INT				PRIMARY KEY						AUTO_INCREMENT,
    car_type		VARCHAR(20)		UNIQUE			NOT NULL,
    transmission	VARCHAR(20)						NOT NULL,
    eng_volume		INT 							NOT NULL,
    air_con			TINYINT(1)						NOT NULL,
    cruise_control	TINYINT(1)						NOT NULL,
	seats			VARCHAR(15)						NOT NULL,
	hp				int								NOT NULL
);

CREATE TABLE brandModels(
	brandModel_id 	INT				PRIMARY KEY						AUTO_INCREMENT,
	brand			VARCHAR(20)						NOT NULL,
    model			VARCHAR(20)		UNIQUE			NOT NULL
);

CREATE TABLE cars(
	car_id			INT				PRIMARY KEY						AUTO_INCREMENT,
    brandModel_id	INT 							NOT NULL,
    reg_num			VARCHAR(7)		UNIQUE			NOT NULL,
    reg_date		DATE							NOT NULL,
    mileage			INT								NOT NULL,
	carType_id		INT,	
    
    FOREIGN KEY (carType_id)
		REFERENCES carTypes (carType_id),
        
	FOREIGN KEY (brandModel_id)
		REFERENCES brandModels (brandModel_id)
);

CREATE TABLE zip_codes(
	zip				INT				PRIMARY KEY						AUTO_INCREMENT,
    city			VARCHAR(20)						NOT NULL,
    country			VARCHAR(20)						NOT NULL
);

CREATE TABLE customers(
	customer_id		INT				PRIMARY KEY						AUTO_INCREMENT,
	first_name		VARCHAR(30)						NOT NULL,
    last_name		VARCHAR(30)						NOT NULL,
	st_address		VARCHAR(40)						NOT NULL,
    zip				INT								NOT NULL,
    mobile_phone	VARCHAR(8)						NOT NULL,
    addit_phone		VARCHAR(8),
    email			VARCHAR(30)						NOT NULL,
    driver_license	VARCHAR(8)						NOT NULL,
    driver_since	DATE							NOT NULL,
    
    FOREIGN KEY (zip)
		REFERENCES zip_codes (zip)
);

CREATE TABLE contracts(
	contract_id		INT				PRIMARY KEY						AUTO_INCREMENT,
	renter_id		INT,
    car_id			INT,
    start_date 		DATETIME						NOT NULL,
    end_date		DATETIME						NOT NULL,
	max_km			INT								NOT NULL,
    start_km		INT								NOT NULL,
    
    FOREIGN KEY (renter_id)
		REFERENCES customers (customer_id)	ON DELETE SET NULL,
        
	FOREIGN KEY (car_id)
		REFERENCES cars (car_id)	ON DELETE SET NULL
);


-- Insert data into tables 

INSERT INTO carTypes VALUES
(1, "Luxury", "automatic", 3980, 1, 1, 5, 362),
(2, "Family", "automatic", 3500, 1, 0, 7, 296),
(3, "Sport", "manual", 3700, 0, 0, 2, 350);

INSERT INTO brandModels VALUES
(1, "Mercedes-Benz", "S Class"),
(2, "Toyota", "Sienna"),
(3, "Nissan", "370Z");

INSERT INTO cars VALUES
(1, 1, "AW20325", "2018-04-10", 500, 1),
(2, 2, "RE11454", "2016-06-25", 0, 2),
(3, 3, "MT63852", "2012-08-01", 1000, 3);

INSERT INTO zip_codes VALUES
(2000, "Frederiksberg", "Danmark"),
(2100, "København Ø", "Danmark"),
(2150, "Nordhavn", "Danmark"),
(2200, "København N", "Danmark"),
(2300, "København S", "Danmark"),
(2400, "København NV", "Danmark"),
(2450, "København SV", "Danmark"),
(2500, "Valby", "Danmark"), 
(5000, "Odense C", "Danmark"), 
(5029, "Odense C", "Danmark"), 
(5100, "Odense C", "Danmark"), 
(5200, "Odense V", "Danmark"), 
(5210, "Odense NV", "Danmark");

INSERT INTO customers VALUES
(1, "Felix", "Maxwell", "59 Peter Bangs Vej", 2000, "58964714", "25852447", "fm@gmail.com", "63256325", "2000-05-20"),
(2, "Kila", "Brenton", "Vigerslev Allé 64", 2500, "36259874", NULL,  "kb@outlook.com", "31796482", "1998-01-18"),
(3, "Jonh", "Walker", "24 Lahnsgade", 5000, "55846221", NULL, "jw@yahoo.com", "48426862", "2010-06-30");

INSERT INTO contracts VALUES
(1, 3, 2, "2020-03-10 09:00:00", "2020-03-17 09:00:00", 1000, 25000),
(2, 1, 1, "2020-04-15 11:00:00", "2020-04-19 11:00:00", 500, 15000),
(3, 2, 3, "2020-05-21 14:00:00", "2020-05-25 14:00:00", 300,  10000);



