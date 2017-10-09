
# WALKOVER CRUD REST APIs

This projects includes 5 endpoints for simple crud application. It uses spring
as design framework, Hibernate as ORM, PostgreSQL as Database and Maven as
build tool and Tomcat (as Server)

# Pre-requisites & Configuration
Please make sure you have following configuration done-
1. Tomcat Server Installed and Configured in IDE.
2. Maven Installed
3. PostgreSQL installed and having following configuration done-
 - PostgreSQl running on Default port: 5432
 - User 'postgres' with password 'root'
 - A Db named 'employee_db' created and a table named 'employee' inside
   mentioned db created.
 - Create Query for Employee table: 
    CREATE TABLE employee(
      id INT PRIMARY KEY     NOT NULL,
      first_name           TEXT    NOT NULL,
      last_name            TEXT     NOT NULL,
      email        TEXT,
      phone         TEXT
    );
 

# Execution Steps
Please use the following steps for setting up the project-
1. Download and Copy Project a comvenient directory.
2. Using command line, Go to the Base of Project and run following command to
   install maven dependendies -
   - mvn install
3. Import Project into an IDE (Eclipse, IntelliJ etc.)
4. Configure tomcat server in IDE.
5. Click on Project, Select Run As -> Run as Server.
6. Check http://localhost:8080/walkover-crud-rest-apis/ for Welcome Page.

# Usage

Following five operations/endpoints are served by this project- 

1. Creating an Employee -
   Request- POST /create
   Request JSON body Sample - 
    {
        "id": 1,
        "firstName": "Abhishek",
        "lastName": "Soni",
        "email": "abhisheksoni301991@gmail.com",
        "phone": "9619588918"
    }

    Sample Request- http://localhost:8080/walkover-crud-rest-apis/employee/create

2. List employee by Id -
   Request- GET /{id}
   Sample Request - http://localhost:8080/walkover-crud-rest-apis/employee/1

3. List all Employees -
   Request- GET /list
   Sample Request - http://localhost:8080/walkover-crud-rest-apis/employee/list

4. Update an Employee by Id-
   Request- POST /update/{id}
   Request JSON body Sample - 
    {
        "id": 1,
        "firstName": "Abhishek",
        "lastName": "Soni",
        "email": "abhisheksoni301991@gmail.com",
        "phone": "9619588918"
    }

    Sample Request - http://localhost:8080/walkover-crud-rest-apis/update/1

5. Delete an Employee-
   Request- GET /delete/{id}
   Sample Request- http://localhost:8080/walkover-crud-rest-apis/delete/1

# Contact
For any Query or Information, Please feel free to contact me on Below details- 
Abhishek Soni
(+91)-9819588918, 7987745331
abhisheksoni301991@gmail.com, absoni30@gmail.com
