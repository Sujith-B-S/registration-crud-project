create database Registration
create table using mysql workbench
CREATE TABLE Registration (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Email VARCHAR(100) NOT NULL UNIQUE,
    DateOfBirth DATE NOT NULL,
    // Add any other required fields
);


download the repository and open in eclipse
run the Project by right clicking the name of the project and run project
it requires tomcat should be firstly downlodaded and setted 
