CREATE TABLE unique_cats (cat_id INT NOT NULL, name VARCHAR(100), age INT , PRIMARY KEY (cat_id));

INSERT INTO unique_cats (cat_id,name,age)
VALUES(1,'Fred',23),(2,'Louis',3),(3,'James',3);

CREATE TABLE unique_cats2 (cat_id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(100), age INT, 
PRIMARY KEY (cat_id));

INSERT INTO unique_cats2(name,age) 
VALUES('Skippy',4),('Jiff',5),('Jiff',3),('Jiff',3),('Jiff',3),('Skippy',4);

desc unique_cats2;

SELECT * FROM unique_cats2;
-- Nhan xet: truong cat_id tu dong them vao va tang gia tri sau moi lan insert.

 CREATE TABLE employee(id INT NOT NULL AUTO_INCREMENT, 
 first_name VARCHAR(255) NOT NULL, 
 last_name VARCHAR(255) NOT NULL, 
 middle_name VARCHAR(255) , 
 age INT NOT NULL, 
 current_status VARCHAR(255) NOT NULL DEFAULT 'employed', 
 PRIMARY KEY (id));

INSERT INTO employee(first_name,last_name,age) VALUES('Dora','Smith',58);

desc employee;

SELECT * FROM employee;

-- Nhan xet: cot id tu dong duoc them vao gia tri, middle_name khong co gia tri (NULL),current_status tu dong them vao gia tri employed.