# EmployeeManager - RESTful CRUD web-application.

# Description

This simple pet project was created during my studying of the main web technologies based on java. You can do CRUD operations with employees, registration or delete users.

Also, the application has role separation: 

- User can only retrieve employees list and add new employees;
- Admin can do all CRUD operations with employees, has access for the rest-service of the application, can retrieve a list of users and delete them.

# Used technologies:

- Java 8;
- Spring Boot;
- Thymeleaf;
- Spring MVC; 
- Spring Security;
- Spring Data JPA/REST;
- Hibernate; 
- MySQL;
- Tomcat;
- Maven;
- Spring Boot Test;
- Mockito;
- Bootstrap;
- etc.

# Common tasks facing java web app developer were solved:

 - CRUD operations;
 - Validation;
 - Authentication; 
 
 # Installation
 
 1. Uncomment ```spring.jpa.hibernate.ddl-auto = create``` and edit JDBC properties in ```application.properties``` file. 
 
 2. Run the application by the main method in ```EmployeedemoApplication``` class. After the first running hibernate will create tables and mappings automatically.
 
 3. Stop the application and comment ```spring.jpa.hibernate.ddl-auto = create``` again, then fill the data using ```/resources/db/data.sql```
 
 4. Run the application by the main method in ```EmployeedemoApplication``` class.
 
 # Screenshots

![Selection_246](https://user-images.githubusercontent.com/52618297/64115700-f7586800-cd98-11e9-85d4-ca082ab79a6f.png)
![Selection_248](https://user-images.githubusercontent.com/52618297/64121393-663cbd80-cda7-11e9-924d-54cad5d5d9f1.png)
![Selection_249](https://user-images.githubusercontent.com/52618297/64121395-68068100-cda7-11e9-8675-41e95d60a971.png)
