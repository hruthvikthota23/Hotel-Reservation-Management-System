# 🏨 Hotel Reservation Management System

A simple **Hotel Reservation Management System** built using **Java, JDBC, and MySQL**.

## 🛠️ Technologies Used

* ☕ Java
* 🔌 JDBC
* 🐬 MySQL

## ✨ Features

* 👤 Add and view customers
* 🛏️ Add and view rooms
* 📅 Create and view reservations
* ✏️ Update customer, room, and reservation details
* 🗑️ Delete customers and rooms
* ❌ Cancel reservations

## 🗄️ Database Setup

Before running the application, create the database in MySQL:

```sql
CREATE DATABASE hotel_reservation;
```

Select the database:

```sql
USE hotel_reservation;
```

Then create the required tables using the SQL queries provided in the project.

## ⚙️ Database Configuration

Open `DBConfig.java` and update your MySQL credentials:

```java
USERNAME = "root";
PASSWORD = "your_password";
```

Make sure **MySQL Server is running** before starting the application. ▶️

## 🔌 JDBC Driver

The project uses the **MySQL Connector/J** JDBC driver.

Make sure the MySQL Connector JAR is available in the `lib` folder.

## 🚀 How to Run

1. 📥 Clone the repository
2. 🗄️ Create the `hotel_reservation` database
3. 📋 Create the required tables
4. ⚙️ Configure your MySQL username and password
5. 🐬 Start MySQL Server
6. ▶️ Run the `Main` class

## 📁 Project Structure

```text
src/
├── model/
├── dao/
├── service/
├── util/
└── Main.java

lib/
└── mysql-connector-j.jar
```

## 🎯 Purpose

This project is created for **learning and practicing**:

* ☕ Java
* 🔌 JDBC
* 🗄️ SQL
* 🐬 MySQL
* 🏗️ DAO and Service Layer concepts

---

⭐ **Feel free to explore, use, and improve this project!**
