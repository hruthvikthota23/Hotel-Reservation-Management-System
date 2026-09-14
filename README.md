# 🏨 Hotel Reservation Management System

A console-based **Hotel Reservation Management System** developed using **Java, JDBC, and MySQL**.  
The application allows users to manage customers, rooms, and hotel reservations through a simple menu-driven interface.

## 🛠️ Technologies Used

- ☕ Java
- 🔌 JDBC
- 🐬 MySQL
- 📦 MySQL Connector/J

## ✨ Features

### 👤 Customer Management
- ➕ Add customer
- 📋 View all customers
- 🔍 Find customer
- ✏️ Update customer
- 🗑️ Delete customer

### 🛏️ Room Management
- ➕ Add room
- 📋 View all rooms
- 🔍 Find room
- ✏️ Update room
- 🗑️ Delete room
- 🟢 Check room availability

### 📅 Reservation Management
- ➕ Create reservation
- 📋 View all reservations
- 🔍 Find reservation
- ✏️ Update reservation
- ❌ Cancel reservation

## 🗄️ Database Setup

Before running the application, make sure **MySQL Server** is installed and running. 🐬

The project contains a SQL script:

```text
database/database.sql
````

Run this file in MySQL Workbench or MySQL Command Line.

The script creates the:

```text
hotel_reservation
```

database and the required tables:

* 👤 `customers`
* 🛏️ `rooms`
* 📅 `reservations`

## ⚙️ Database Configuration

The actual `DBConfig.java` file is excluded from GitHub to protect database credentials. 🔒

Copy:

```text
DBConfigExample.java
```

to:

```text
DBConfig.java
```

Then configure your MySQL credentials:

```java
public static final String URL =
        "jdbc:mysql://localhost:3306/hotel_reservation";

public static final String USERNAME = "root";

public static final String PASSWORD = "your_password";
```

Replace `your_password` with your MySQL password.

⚠️ **Never upload your actual database password to GitHub.**

## 🔌 JDBC Driver

This project uses **MySQL Connector/J** to connect Java with MySQL.

The JDBC driver should be available in:

```text
lib/
```

## 🚀 How to Run

1. 📥 Clone the repository.
2. ☕ Make sure Java is installed.
3. 🐬 Start MySQL Server.
4. 🗄️ Run `database/database.sql`.
5. ⚙️ Create and configure `DBConfig.java`.
6. 🔌 Add the MySQL Connector/J driver.
7. ▶️ Run the `Main` class.

## 🏗️ Architecture

The project follows a simple layered architecture:

```text
Main
 ↓
UI
 ↓
Service
 ↓
DAO
 ↓
JDBC
 ↓
MySQL
```

* 🎯 **Model** – Represents application data
* 🖥️ **UI** – Handles user interaction
* ⚙️ **Service** – Handles business logic
* 🗄️ **DAO** – Handles database operations
* 🔌 **JDBC** – Connects Java with MySQL

## 📁 Project Structure

```text
HotelReservationManagementSystem/
│
├── src/
│   └── com/
│       ├── dao/
│       ├── model/
│       ├── service/
│       ├── ui/
│       ├── util/
│       └── hotelreservation/
│
├── database/
│   └── database.sql
│
├── lib/
│   └── mysql-connector-j.jar
│
├── .gitignore
└── README.md
```

## 📚 Concepts Practiced

* ☕ Java OOP
* 🔌 JDBC
* 🗄️ SQL & MySQL
* 📊 CRUD Operations
* 🔑 Primary & Foreign Keys
* 🔄 `PreparedStatement`
* 📋 `ResultSet`
* 🔑 Generated Keys
* 🏗️ DAO Pattern
* ⚙️ Service Layer
* 🧹 Exception Handling
* ♻️ Try-with-resources

## 🎯 Purpose

This project was created to practice **Java, JDBC, SQL, and MySQL** by building a real-world hotel reservation application.

## 🔮 Future Improvements

* 🔐 User authentication
* 💳 Payment management
* 🧾 Invoice generation
* 🧪 Unit testing
* 🌐 Web interface
* 🍃 Spring Boot integration

---

⭐ **If you find this project useful, feel free to star the repository!**

### 👨‍💻 Author

**Sunny**

```

This is the version I'd recommend for your repository: **enough information for someone to clone and run it, without making the README unnecessarily long.**
```
