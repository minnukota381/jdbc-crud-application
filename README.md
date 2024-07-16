# JDBC CRUD Operations with Multiple Databases

This project demonstrates basic CRUD (Create, Read, Update, Delete) operations using JDBC (Java Database Connectivity) with different databases like MySQL, PostgreSQL, and more. It provides a simple yet comprehensive example of how to interact with databases in Java using JDBC.

## Features

- **CRUD Operations:** Demonstrates how to perform Create, Read, Update, and Delete operations on databases.
- **Database Support:** Includes examples for MySQL and PostgreSQL databases. Easily extendable for other databases.
- **Reusable DAOs:** Uses Data Access Objects (DAOs) for each database interaction, ensuring clean and modular code.

## Technologies Used

- Java
- JDBC
- MySQL
- PostgreSQL

## Setup Instructions

1. **Clone the repository:**

   ```bash
   git clone https://github.com/minnukota381/jdbc-crud-application.git
   cd jdbc-crud-application
   ```

2. **Import into your IDE:**
   - Import the project into your preferred Java IDE (like Eclipse or IntelliJ IDEA).

3. **Configure Database:**
   - Create databases named `jdbc_mysql_db` and `jdbc_postgres_db` in MySQL and PostgreSQL respectively.
   - Update `src/main/resources/config.properties` with your database credentials.

4. **Run the Application:**
   - Build and run the project from your IDE.
   - The application will perform CRUD operations on both MySQL and PostgreSQL databases.

## Usage

- Each database operation is encapsulated within its own DAO class (`UserDAO`, `ProductDAO`, etc.).
- Modify the DAO classes as needed for your specific database schema and requirements.

## Contributing

Contributions are welcome! If you'd like to enhance the project, follow these steps:

1. Fork the project.
2. Create your feature branch (`git checkout -b feature/AmazingFeature`).
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`).
4. Push to the branch (`git push origin feature/AmazingFeature`).
5. Open a pull request.

## License

Distributed under the MIT License. See `LICENSE` for more information.
