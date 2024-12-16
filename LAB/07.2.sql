/*
Lab 7.2 - GROUP BY và các hàm tổng hợp (Aggregate Function) (Hackerrank - 3)

Yêu cầu: Các bạn sẽ thực hiện các #Bài tập dưới đây trên Hackerrank:
EASY:
*/
#Bài 1: Revising Aggregations - The Sum Function
SELECT SUM(POPULATION) FROM CITY WHERE DISTRICT = "California";

#Bài 2: Revising Aggregations - Averages
SELECT AVG(POPULATION) FROM CITY WHERE DISTRICT = "California";

#Bài 3: Average Population
SELECT ROUND(AVG(POPULATION),0) FROM CITY;

#Bài 4: Japan Population
SELECT SUM(POPULATION) FROM CITY WHERE COUNTRYCODE = "JPN";

#Bài 5: Population Density Difference
SELECT MAX(POPULATION) - MIN(POPULATION) FROM CITY;

#Bài 6: The Blunder
SELECT ROUND(AVG(Salary)-AVG(REPLACE(Salary,"0",""))+0.4,0) FROM EMPLOYEES;

#Bài 7: Top Earners
SELECT CONCAT(MAX(salary*months)," ",COUNT(salary)) FROM Employee WHERE salary*months = (SELECT MAX(salary*months) FROM Employee);

#Bài 8: Weather Observation Station 2
SELECT ROUND(SUM(LAT_N),2), " " , ROUND(SUM(LONG_w),2) FROM STATION;

#Bài 9: Weather Observation Station 4
SELECT COUNT(CITY) - COUNT(DISTINCT CITY) FROM STATION ;

#Bài 10: Weather Observation Station 5
(SELECT CITY, LENGTH(CITY) FROM STATION ORDER BY LENGTH(CITY),CITY LIMIT 1)
UNION ALL
(SELECT CITY, LENGTH(CITY) FROM STATION ORDER BY LENGTH(CITY) DESC,CITY LIMIT 1);

#Bài 11: Weather Observation Station 13
SELECT ROUND(SUM(LAT_N),4) FROM STATION WHERE LAT_N BETWEEN 38.7881 AND 137.2344;

#Bài 12: Weather Observation Station 14
SELECT ROUND(MAX(LAT_N),4) FROM STATION WHERE LAT_N < 137.2345;

#Bài 13: Weather Observation Station 15
SELECT ROUND(LONG_W,4) FROM STATION WHERE LAT_N = (SELECT MAX(LAT_N) FROM STATION WHERE LAT_N < 137.2345);

#Bài 14: Weather Observation Station 16
SELECT ROUND(MIN(LAT_N),4) FROM STATION WHERE LAT_N > 38.7780;

#Bài 15: Weather Observation Station 17
SELECT ROUND(LONG_W,4) FROM STATION WHERE LAT_N = (SELECT MIN(LAT_N) FROM STATION WHERE LAT_N > 38.7780);

#Bài 16: Weather Observation Station 18
SELECT ROUND(MAX(LAT_N)-MIN(LAT_N)+MAX(LONG_W)-MIN(LONG_W),4) FROM STATION;

#Bài 17: New Companies
SELECT 
DISTINCT company_code AS cpn,founder,
(SELECT COUNT(DISTINCT lead_manager_code) FROM Lead_Manager WHERE company_code = cpn),
(SELECT COUNT(DISTINCT senior_manager_code) FROM Senior_Manager WHERE company_code = cpn),
(SELECT COUNT(DISTINCT manager_code) FROM Manager WHERE company_code = cpn),
(SELECT COUNT(DISTINCT employee_code) FROM Employee WHERE company_code = cpn)
FROM Company
ORDER BY company_code;

#Bài 18: Weather Observation Station 19
SELECT ROUND(SQRT(POWER(MAX(LAT_N)-MIN(LAT_N),2)+POWER(MAX(LONG_W)-MIN(LONG_W),2)),4) FROM STATION;


