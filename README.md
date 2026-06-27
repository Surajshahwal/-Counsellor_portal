# 🎓 Counsellor Portal

> A Spring Boot web application for managing student enquiries in a training institute. The application enables counsellors to register, log in, manage student enquiries, update enquiry status, and monitor their performance through an interactive dashboard.

---

# 📌 Project Overview

Counsellor Portal is a real-time web application developed using **Java, Spring Boot, Thymeleaf, Spring Data JPA, Hibernate, and MySQL**.

The system is designed to simplify the student enquiry management process within a training institute. Each counsellor can securely manage their own enquiries, track student progress, and monitor overall performance using a personalized dashboard.

---

# ✨ Features

## 👤 Counsellor Management

* Counsellor Registration
* Secure Login & Logout
* Session Management
* Individual Dashboard

## 📋 Student Enquiry Management

* Add New Student Enquiry
* View All Enquiries
* Filter Enquiries by Course
* Filter Enquiries by Status
* Update Enquiry Details
* Change Enquiry Status

  * Open
  * Enrolled
  * Lost

## 📊 Dashboard Analytics

Dashboard displays:

* 📁 Total Enquiries
* 🟡 Open Enquiries
* ✅ Enrolled Enquiries
* ❌ Lost Enquiries

---

# 🛠️ Tech Stack

## Backend

* Java 17
* Spring Boot
* Spring MVC
* Spring Data JPA
* Hibernate
* Maven

## Frontend

* Thymeleaf
* HTML5
* CSS3
* Bootstrap

## Database

* MySQL

## Tools

* Git
* GitHub
* Eclipse / IntelliJ IDEA

---

# 📂 Project Structure

```text
Counsellor_portal
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── controller
│   │   │   ├── service
│   │   │   ├── repository
│   │   │   ├── entity
│   │   │   ├── dto
│   │   │   └── exception
│   │   │
│   │   └── resources
│   │       ├── templates
│   │       ├── static
│   │       └── application.properties
│   │
│   └── test
│
├── screenshots
├── pom.xml
└── README.md
```

---

# 🗄️ Database Design

## counsellors_tbl

| Column        | Description         |
| ------------- | ------------------- |
| counsellor_id | Primary Key         |
| name          | Counsellor Name     |
| email         | Unique Email        |
| pwd           | Password            |
| phno          | Phone Number        |
| created_date  | Record Created Date |
| updated_date  | Record Updated Date |

---

## enquiries_tbl

| Column         | Description            |
| -------------- | ---------------------- |
| enq_id         | Primary Key            |
| student_name   | Student Name           |
| student_phno   | Student Phone Number   |
| course_name    | Course Name            |
| class_mode     | Online / Offline       |
| enquiry_status | Open / Enrolled / Lost |
| counsellor_id  | Foreign Key            |
| created_date   | Record Created Date    |
| updated_date   | Record Updated Date    |

### Relationship

```
One Counsellor
        │
        │ 1
        │
        ▼
Many Enquiries
```

---

# ⚙️ Installation & Setup

## Clone Repository

```bash
git clone https://github.com/Surajshahwal/-Counsellor_portal.git
```

Move into the project directory:

```bash
cd -Counsellor_portal
```

---

## Configure Database

Create a MySQL database:

```sql
CREATE DATABASE counsellor_portal_db;
```

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/counsellor_portal_db
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## Run the Project

```bash
mvn clean install
```

```bash
mvn spring-boot:run
```

Application URL

```
http://localhost:8080
```

---

# 📸 Application Screens

## 📝 Registration Page

> Add screenshot here

```
screenshots/registration.png
```

---

## 🔐 Login Page

> Add screenshot here

```
screenshots/login.png
```

---

## 📊 Dashboard

> Add screenshot here

```
screenshots/dashboard.png
```

---

## ➕ Add Enquiry

> Add screenshot here

```
screenshots/add-enquiry.png
```

---

## 📋 View Enquiries

> Add screenshot here

```
screenshots/view-enquiries.png
```

---

## ✏️ Update Enquiry

> Add screenshot here

```
screenshots/update-enquiry.png
```

---

# 🔄 Application Flow

```text
Registration
      │
      ▼
Login
      │
      ▼
Dashboard
      │
      ├─────────────► Add Enquiry
      │
      ├─────────────► View Enquiries
      │
      ├─────────────► Filter Enquiries
      │
      └─────────────► Update Status
                         │
                         ▼
                   Dashboard Updated
```

---

# 🚀 Future Enhancements

* Spring Security
* Forgot Password
* Email Notification
* Excel Export
* PDF Report
* Pagination
* Sorting
* REST APIs
* JWT Authentication
* Docker Support
* AWS Deployment

---

# 🤝 Contributing

Contributions are always welcome.

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to your branch
5. Create a Pull Request

---

# 👨‍💻 Author

**Suraj Kumar Shah**

Java Full Stack Developer

GitHub: https://github.com/Surajshahwal

LinkedIn: https://www.linkedin.com/in/suraj-kumar-shah-600155271/

---

⭐ If you like this project, don't forget to **Star** this repository.
