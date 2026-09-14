# 🏨 Hotel Reservation Management System

A simple **Hotel Reservation Management System** built using **Java, JDBC, and MySQL**.

## 🛠️ Technologies Used

* ☕ Java
* 🔌 JDBC
* 🐬 MySQL
* 📦 MySQL Connector/J

## ✨ Features

### 👤 Customer Management

* ➕ Add customer
* 📋 View all customers
* 🔍 Find customer
* ✏️ Update customer
* 🗑️ Delete customer

### 🛏️ Room Management

* ➕ Add room
* 📋 View all rooms
* 🔍 Find room
* ✏️ Update room
* 🗑️ Delete room
* 🟢 Check room availability

### 📅 Reservation Management

* ➕ Create reservation
* 📋 View all reservations
* 🔍 Find reservation
* ✏️ Update reservation
* ❌ Cancel reservation

## 🗄️ Database Setup

Before running the application, create the database in **MySQL**.

```sql
CREATE DATABASE hotel_reservation;
```

Select the database:

```sql
USE hotel_reservation;
```

Then create the required tables using the SQL queries provided in the project.

> ⚠️ The application will not work correctly until the database and required tables are created.

## ⚙️ Database Configuration

Copy DBConfigExample.java → DBConfig.java
Open `DBConfig.java` and configure your MySQL credentials:

```java
public static final String URL =
        "jdbc:mysql://localhost:3306/hotel_reservation";

public static final String USERNAME = "root";

public static final String PASSWORD = "your_password";
```

🔹 Replace `your_password` with your MySQL password.

🔹 Make sure the MySQL server is running. 🐬

🔒 **Do not upload your actual password to GitHub.**

## 🔌 JDBC Driver

This project uses **MySQL Connector/J**.

Make sure the MySQL Connector JAR file is available in the project's `lib` folder.

## 🚀 How to Run

1. 📥 Clone the repository
2. ☕ Make sure Java is installed
3. 🐬 Start MySQL Server
4. 🗄️ Create the `hotel_reservation` database
5. 📋 Create the required tables
6. ⚙️ Configure `DBConfig.java`
7. 🔌 Make sure the JDBC driver is available
8. ▶️ Run the `Main` class

## 📁 Project Structure

```text
Hotel-Reservation-System/
│
├── src/
│   └── ...
│
├── lib/
│   └── mysql-connector-j.jar
│
├── .gitignore
└── README.md
```

## 🏗️ Architecture

The project follows a simple layered structure:

```text
Main
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
* ⚙️ **Service** – Handles business logic
* 🗄️ **DAO** – Handles database operations
* 🔌 **JDBC** – Connects Java with MySQL

## 📚 Concepts Practiced

* ☕ Java OOP
* 🔌 JDBC
* 🗄️ SQL
* 🐬 MySQL
* 🔑 Primary Keys
* 🔗 Foreign Keys
* 📊 CRUD Operations
* 🏗️ DAO Pattern
* ⚙️ Service Layer
* 🧹 Exception Handling
* 🔄 `PreparedStatement`
* 📋 `ResultSet`
* 🔑 Generated Keys

## ⚠️ Important

Make sure:

* ✅ MySQL is installed
* ✅ MySQL Server is running
* ✅ Database is created
* ✅ Required tables are created
* ✅ Database username and password are configured
* ✅ MySQL Connector/J is available

## 🎯 Purpose

This project is created for **learning and practicing Java, JDBC, SQL, and MySQL** by building a real-world hotel reservation application.

---

⭐ **If you find this project useful, feel free to star the repository!**
