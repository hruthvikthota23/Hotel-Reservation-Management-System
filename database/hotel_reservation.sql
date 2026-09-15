-- =========================================================
-- 🏨 HOTEL RESERVATION MANAGEMENT SYSTEM
-- =========================================================

-- Create Database
CREATE DATABASE hotel_reservation;

-- Select Database
USE hotel_reservation;

-- Verify Current Database
SELECT DATABASE();


-- =========================================================
-- 👤 CUSTOMERS TABLE
-- =========================================================

CREATE TABLE customers (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(100) NOT NULL,
    contact     VARCHAR(10)  NOT NULL,
    address     VARCHAR(150) NOT NULL
);


-- =========================================================
-- 🛏️ ROOMS TABLE
-- =========================================================

CREATE TABLE rooms (
    room_id   INT PRIMARY KEY AUTO_INCREMENT,
    room_no   INT          NOT NULL UNIQUE,
    room_type VARCHAR(50)  NOT NULL,
    price     DECIMAL(10,2) DEFAULT 700.00,
    status    VARCHAR(50)  NOT NULL DEFAULT 'Available'
);


-- =========================================================
-- 📅 RESERVATIONS TABLE
-- =========================================================

CREATE TABLE reservations (
    reservation_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id    INT NOT NULL,
    room_id        INT NOT NULL,
    check_in      DATE NOT NULL,
    check_out     DATE NOT NULL,
    reservation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status         VARCHAR(50) NOT NULL DEFAULT 'Confirmed',

    FOREIGN KEY (customer_id)
        REFERENCES customers(customer_id),

    FOREIGN KEY (room_id)
        REFERENCES rooms(room_id)
);


-- =========================================================
-- 👤 INSERT SAMPLE CUSTOMERS
-- =========================================================

INSERT INTO customers (name, contact, address) VALUES
    ('Rahul Sharma', '9876543210', 'Hyderabad'),
    ('Priya Reddy', '9876543211', 'Bangalore'),
    ('Arjun Kumar', '9876543212', 'Chennai'),
    ('Sneha Patel', '9876543213', 'Mumbai'),
    ('Vikram Singh', '9876543214', 'Delhi'),
    ('Ananya Rao', '9876543215', 'Pune'),
    ('Kiran Reddy', '9876543216', 'Vijayawada'),
    ('Neha Verma', '9876543217', 'Kolkata'),
    ('Rohit Mehta', '9876543218', 'Ahmedabad'),
    ('Pooja Nair', '9876543219', 'Kochi');


-- =========================================================
-- 🛏️ INSERT SAMPLE ROOMS
-- =========================================================

INSERT INTO rooms (room_no, room_type, price) VALUES

    -- Single Rooms
    (101, 'Single', 700.00),
    (102, 'Single', 750.00),
    (103, 'Single', 800.00),
    (104, 'Single', 850.00),
    (105, 'Single', 900.00),

    -- Double Rooms
    (106, 'Double', 1200.00),
    (107, 'Double', 1300.00),
    (108, 'Double', 1400.00),
    (109, 'Double', 1500.00),
    (110, 'Double', 1600.00),

    -- Deluxe Rooms
    (111, 'Deluxe', 1800.00),
    (112, 'Deluxe', 2000.00),
    (113, 'Deluxe', 2200.00),
    (114, 'Deluxe', 2400.00),
    (115, 'Deluxe', 2500.00),

    -- Suite Rooms
    (116, 'Suite', 3000.00),
    (117, 'Suite', 3500.00),
    (118, 'Suite', 4000.00),
    (119, 'Suite', 4500.00),
    (120, 'Suite', 5000.00);