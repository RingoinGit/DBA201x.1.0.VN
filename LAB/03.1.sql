use cat_app;
create table people (first_name varchar(20),last_name varchar(20), age int);
INSERT INTO people (first_name,last_name,age) 
VALUES ("Tina","Bencher",13) ,("Bob","Belcher",42) ,("Linda","Belcher",45) ,("Philip","Frond",38) ,("Calvin","FisChoeder",70);

SELECT * FROM people;
DROP TABLE people;
show tables;