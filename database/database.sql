-- 🏨 Hotel Reservation Management System Database

CREATE DATABASE hotel_reservation;

USE hotel_reservation;

SELECT DATABASE();

-- 👤 Customers Table
CREATE TABLE customers(
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    contact VARCHAR(10) NOT NULL,
    address VARCHAR(150) NOT NULL
);

-- 🛏️ Rooms Table
CREATE TABLE rooms(
    room_id INT PRIMARY KEY AUTO_INCREMENT,
    room_no INT NOT NULL UNIQUE,
    room_type VARCHAR(50) NOT NULL,
    price DECIMAL(10,2) DEFAULT 700.00,
    status VARCHAR(50) NOT NULL DEFAULT 'Available'
);

-- 📅 Reservations Table
CREATE TABLE reservations(
    reservation_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT NOT NULL,
    room_id INT NOT NULL,
    check_in DATE NOT NULL,
    check_out DATE NOT NULL,
    reservation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) NOT NULL DEFAULT 'Confirmed',
    FOREIGN KEY(customer_id) 
        REFERENCES customers(customer_id),
    FOREIGN KEY(room_id) 
        REFERENCES rooms(room_id)
);