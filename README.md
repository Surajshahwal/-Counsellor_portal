# 🎓 Counsellor Portal

> A full-featured web application for managing student enquiries in a training institute — built with Spring Boot, Thymeleaf, and MySQL.

---

## 📌 Project Overview

**Counsellor Portal** is a real-time Spring Boot web application designed to streamline the student enquiry management process in training institutes. It provides counsellors with a centralized platform to register, authenticate, track student enquiries through their lifecycle, and gain actionable insights through a live dashboard.

Whether a student is just enquiring about a course or has already enrolled, the portal helps counsellors stay organized and respond efficiently — reducing manual effort and improving conversion tracking.

---

## ✨ Features

### 👤 Counsellor Management
- Secure **Registration** with form validation
- **Login & Logout** with session management
- Profile-linked enquiry tracking

### 📋 Enquiry Management
- **Add New Enquiry** — capture student name, phone, course, and class mode
- **View All Enquiries** — paginated list with sortable columns
- **Filter Enquiries** — by Course Name and/or Status (Open / Enrolled / Lost)
- **Update Enquiry Status** — move enquiries through the pipeline in real time

### 📊 Dashboard & Reporting
Real-time summary cards displaying:
| Metric | Description |
|--------|-------------|
| 📁 Total Enquiries | All enquiries logged by the counsellor |
| 🟡 Open Enquiries | Enquiries yet to be converted |
| ✅ Enrolled Enquiries | Successfully converted students |
| ❌ Lost Enquiries | Enquiries that did not convert |

---

## 🛠️ Technologies Used

### Backend
| Technology | Purpose |
|------------|---------|
| Java 17 | Core programming language |
| Spring Boot | Application framework & auto-configuration |
| Spring MVC | Web layer & REST/controller handling |
| Spring Data JPA | ORM abstraction layer |
| Hibernate | JPA implementation & database interaction |
| Maven | Dependency management & build tool |

### Frontend
| Technology | Purpose |
|------------|---------|
| Thymeleaf | Server-side HTML templating engine |
| HTML5 | Page structure |
| CSS3 | Styling |
| Bootstrap | Responsive UI components |

### Database & DevOps
| Technology | Purpose |
|------------|---------|
| MySQL | Relational database |
| Git & GitHub | Version control & source hosting |

---

## 📂 Project Structure

```
CounsellorPortal/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/counsellorportal/
│       │       ├── controller/       # MVC Controllers (web layer)
│       │       ├── service/          # Business logic interfaces & implementations
│       │       ├── repository/       # Spring Data JPA repositories
│       │       ├── entity/           # JPA entity classes (DB table mappings)
│       │       ├── dto/              # Data Transfer Objects
│       │       ├── config/           # Spring Security / app configuration
│       │       └── utils/            # Utility/helper classes
│       └── resources/
│           ├── templates/            # Thymeleaf HTML templates
│           ├── static/               # CSS, JS, images
│           └── application.properties
├── pom.xml
└── README.md
```

---

## 🗄️ Database Design

### `counsellors_tbl`
| Column | Type | Description |
|--------|------|-------------|
| `counsellor_id` | INT (PK) | Auto-generated primary key |
| `name` | VARCHAR | Full name of the counsellor |
| `email` | VARCHAR (UNIQUE) | Login email |
| `pwd` | VARCHAR | Encrypted password |
| `phno` | VARCHAR | Contact phone number |
| `created_date` | DATE | Account creation date |
| `updated_date` | DATE | Last profile update date |

### `enquiries_tbl`
| Column | Type | Description |
|--------|------|-------------|
| `enq_id` | INT (PK) | Auto-generated enquiry ID |
| `student_name` | VARCHAR | Full name of the student |
| `student_phno` | VARCHAR | Student contact number |
| `course_name` | VARCHAR | Course the student is enquiring about |
| `class_mode` | VARCHAR | Offline / Online / Hybrid |
| `enquiry_status` | ENUM | `OPEN` / `ENROLLED` / `LOST` |
| `counsellor_id` | INT (FK) | Linked counsellor |
| `created_date` | DATE | Date enquiry was created |
| `updated_date` | DATE | Date of last status update |

> **Relationship:** One counsellor can have many enquiries (`@OneToMany` — `counsellors_tbl` → `enquiries_tbl`).

---

## ⚙️ Setup & Installation

### Prerequisites
Make sure the following are installed on your system:
- Java 17+
- Maven 3.6+
- MySQL 8.0+
- Git

### Step-by-Step Setup

**1. Clone the Repository**
```bash
git clone https://github.com/your-username/counsellor-portal.git
cd counsellor-portal
```

**2. Create the MySQL Database**
```sql
CREATE DATABASE counsellor_portal_db;
USE counsellor_portal_db;
```
Then run the provided SQL scripts (if any) to initialize schema and seed data.

**3. Configure `application.properties`**

Update `src/main/resources/application.properties` with your database credentials:
```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/counsellor_portal_db
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Server Port (optional)
server.port=8080
```

**4. Build & Run the Application**
```bash
mvn clean install
mvn spring-boot:run
```

**5. Access the Application**

Open your browser and navigate to:
```
http://localhost:8080
```

---

## 📸 Application Screens

| Screen | Description |
|--------|-------------|
| 🖊️ **Registration Page** | New counsellor sign-up with form validation |





| 🔐 **Login Page** | Secure authentication with session creation |
| 📊 **Dashboard** | Summary cards with live enquiry stats |
| ➕ **Add Enquiry** | Form to capture a new student enquiry |
| 📋 **View Enquiries** | Filterable, paginated table of all enquiries |
| ✏️ **Update Enquiry** | Change enquiry status and update details |

---

## 🔄 Application Flow

```
User visits app
     │
     ▼
[Registration / Login]
     │
     ▼
[Dashboard] ──────────────────────────────────────┐
     │                                             │
     ▼                                             ▼
[Add New Enquiry]                     [View / Filter Enquiries]
     │                                             │
     ▼                                             ▼
[Enquiry Saved to DB]           [Update Status: OPEN → ENROLLED / LOST]
     │                                             │
     └────────────── Dashboard Refreshes ──────────┘
```

---

## 🚧 Future Enhancements

- [ ] Role-based access control (Admin vs Counsellor)
- [ ] Email notifications on status updates
- [ ] Export enquiries to Excel/PDF
- [ ] Pagination & sorting on enquiry list
- [ ] REST API layer for mobile integration
- [ ] Chart-based analytics on the dashboard
- [ ] Forgot Password / OTP verification

---

## 🤝 Contributing

Contributions, bug reports, and feature requests are welcome!

1. Fork the repository
2. Create a new branch: `git checkout -b feature/your-feature-name`
3. Commit your changes: `git commit -m "Add: your feature description"`
4. Push to the branch: `git push origin feature/your-feature-name`
5. Open a Pull Request

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).

---

## 👨‍💻 Author

**Suraj Kumar Shah**
Java Full Stack Developer

[![GitHub](https://img.shields.io/badge/GitHub-SurajKumarShah-black?style=flat&logo=github)](https://github.com/your-username)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Connect-blue?style=flat&logo=linkedin)](https://linkedin.com/in/your-profile)

---

> ⭐ If you found this project helpful, please consider giving it a star on GitHub!
