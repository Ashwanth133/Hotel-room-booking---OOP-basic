# Hotel Room Booking System (Java + JDBC)

## 📌 Description
This project is a **console-based Hotel Room Booking System** developed using **Java, JDBC, and PostgreSQL**.  
It follows a **layered architecture (DAO, Service, Model)** to ensure clean code structure, modularity, and easy maintenance.

The system allows users to book rooms, manage availability, and automatically release rooms when bookings expire.

---

## 🚀 Features
- Room booking and availability management  
- Automatic release of expired bookings  
- Database interaction using JDBC  
- Clean separation of concerns using DAO pattern  

---

## 🛠 Technologies Used
- Java  
- JDBC  
- PostgreSQL  

---

## 🧱 Project Structure
src/
├── config/ # Database configuration
├── dao/ # Data Access Objects
├── model/ # Entity classes
├── service/ # Business logic
└── Main.java # Application entry point


---

## ⚙️ How to Run the Project
1. Create a PostgreSQL database
2. Set database credentials using environment variables
3. Compile and run `Main.java`
4. Follow console instructions to book rooms

---

## 🔐 Note
Database credentials are not hard-coded for security reasons.  
Please configure them using environment variables or a local configuration file.

---

## 📚 Concepts Used
- DAO (Data Access Object) Pattern  
- JDBC  
- Layered Architecture  
- SQL  

---

## 👨‍💻 Author
Ashwanth
