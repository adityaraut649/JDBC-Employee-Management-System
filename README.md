# 👔 Employee Management System

A desktop-based **Employee Management System** built using **Java**, **JDBC**, and **MySQL**. The application allows users to efficiently add, view, update, and delete employee records through a clean Java Swing interface.

> **Author:** Aditya Rajendra Raut 

---

## 📋 Table of Contents

- [Abstract](#abstract)
- [Tech Stack](#tech-stack)
- [Database Schema](#database-schema)
- [Features](#features)
- [Class Design](#class-design)
- [Setup & Installation](#setup--installation)
- [Future Enhancements](#future-enhancements)

---

## 📝 Abstract

The Employee Management System is a desktop application built to store and manage employee records. Users can **add, view, update, and delete** employee records saved in a MySQL database. The system is designed to reduce manual data entry effort, improve accuracy, and increase efficiency in data retrieval.

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java | Core application logic |
| Java Swing | Desktop GUI (User Interface) |
| JDBC | Database connectivity bridge |
| MySQL | Relational database for record storage |

---

## 🗄️ Database Schema

**Database:** `employee`  
**Table:** `employee`  
**Primary Key:** `id`

| Field Name | Data Type | Description |
|---|---|---|
| `id` | INT | Unique Employee ID |
| `name` | VARCHAR(50) | Employee Name |
| `gender` | VARCHAR(10) | Gender |
| `salary` | INT | Employee Salary |

---

## ✨ Features

### ➕ Add Employee
Allows the user to insert new employee records. Input is taken via a Swing form, validated, and inserted into the database using a `PreparedStatement` with SQL `INSERT`.

### 👁️ View Employee
Retrieves and displays employee records using SQL `SELECT`. Results are rendered in a Swing `JTable` for easy viewing.

### ✏️ Update Employee
Modifies existing employee details using SQL `UPDATE`. The user provides an employee ID and the updated information.

### 🗑️ Delete Employee
Removes an employee record from the database using SQL `DELETE` by employee ID, with confirmation feedback via dialog boxes.

---

## 🏗️ Class Design

The application follows an **object-oriented, modular design**:

| Class | Responsibility |
|---|---|
| `HomeFrame` | Main dashboard — provides navigation to all modules |
| `AddFrame` | Handles new employee insertion |
| `FetchFrame` | Retrieves and displays employee records |
| `UpdateFrame` | Updates existing employee information |
| `DeleteFrame` | Removes employee records by ID |
| `AllFrame` | Displays all employees in a single view |

---

## ⚙️ Setup & Installation

### Prerequisites
- Java JDK 8+
- MySQL Server running locally
- Any Java IDE (IntelliJ IDEA, Eclipse, NetBeans)
- MySQL JDBC Driver (`mysql-connector-java.jar`)

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/adityaraut649/employee-management-system.git
   cd employee-management-system
   ```

2. **Set up the MySQL database**
   ```sql
   CREATE DATABASE employee;
   USE employee;

   CREATE TABLE employee (
       id     INT PRIMARY KEY,
       name   VARCHAR(50),
       gender VARCHAR(10),
       salary INT
   );
   ```

3. **Update DB credentials** in each Frame class
   ```java
   DriverManager.getConnection(
       "jdbc:mysql://localhost:3306/employee",
       "your_username",
       "your_password"
   );
   ```

4. **Add JDBC driver** to your project's classpath  
   Download: [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)

5. **Run the project**  
   Execute `HomeFrame.java` as the main entry point.

---

## 📸 Screenshots

> Add your screenshots inside a `screenshots/` folder in the repository root.

### ➕ Add Employee
<img width="773" height="623" alt="image" src="https://github.com/user-attachments/assets/9853e7bd-dbc5-4526-8cad-c85610b3bc40" />


### 👁️ View Employee
<img width="824" height="562" alt="image" src="https://github.com/user-attachments/assets/8ddc38f4-ad7d-46e6-a8af-b2e229cda106" />


### ✏️ Update Employee
<img width="860" height="554" alt="image" src="https://github.com/user-attachments/assets/4ea0bea8-f9f2-4bb1-969f-0e829c38d0b9" />


### 🗑️ Delete Employee
<img width="836" height="575" alt="image" src="https://github.com/user-attachments/assets/4d0fb291-2ec1-454a-96db-7ddc57ecaf1b" />


---

## 🚀 Future Enhancements

- Login and authentication system with **role-based access control**
- **Search and filter** functionality for quick employee lookup
- Export employee data to **PDF or Excel** formats
- Improved **input validation** and error handling
- Employee **salary and performance reports**

---

## 👤 Author

**Aditya Rajendra Raut**  
[GitHub](https://github.com/adityaraut649)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
