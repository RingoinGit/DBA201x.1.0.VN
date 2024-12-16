/*
Yêu cầu: Thực hiện các #Bài tập dưới đây trên Hackerrank:
EASY:
*/

#Bài 1: Weather Observation Station 3
SELECT DISTINCT CITY FROM STATION WHERE ID%2=0;

#Bài 2: Weather Observation Station 6
SELECT DISTINCT CITY FROM STATION WHERE CITY REGEXP "^(a|e|i|o|u)";
-- Bài này có tìm hiểu thêm trên gg vì dùng LIKE dài quá

#Bài 3: Weather Observation Station 7
SELECT DISTINCT CITY FROM STATION WHERE CITY REGEXP "(a|e|i|o|u)$";
-- như trên

#Bài 4: Weather Observation Station 8
SELECT DISTINCT CITY FROM STATION WHERE CITY REGEXP "^[aeiou].+[aeiou]$";
-- như trên, tìm hiểu thêm về regex

#Bài 5: Weather Observation Station 9
SELECT DISTINCT CITY FROM STATION WHERE CITY REGEXP "^[^aeiou]";
-- như trên

#Bài 6: Weather Observation Station 11
SELECT DISTINCT CITY FROM STATION WHERE CITY REGEXP "^[^aeiou]|[^aeiou]$";


#Bài 7: Higher Than 75 Marks 
SELECT NAME FROM STUDENTS WHERE Marks > 75 ORDER BY SUBSTR(NAME,-3),ID ;

#Bài 8: Type of Triangle 
SELECT 
CASE
    WHEN A+B<=C OR A+C<=B OR B+C<=A THEN "Not A Triangle"
    WHEN A=B AND B=C THEN "Equilateral"
    WHEN A=B OR A=C OR B=C THEN "Isosceles"
    ELSE "Scalene"
END AS ""
FROM TRIANGLES;

#Bài 9: Employee Names
SELECT name FROM Employee ORDER BY name;
