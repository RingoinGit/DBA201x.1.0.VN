#Bài 1: Population Census
SELECT SUM(CITY.POPULATION) 
    FROM CITY 
    INNER JOIN COUNTRY ON  CITY.COUNTRYCODE = COUNTRY.CODE
    WHERE COUNTRY.CONTINENT = 'Asia';

#Bài 2: African Cities
SELECT CITY.NAME 
    FROM CITY 
    INNER JOIN COUNTRY ON  CITY.COUNTRYCODE = COUNTRY.CODE
    WHERE COUNTRY.CONTINENT = 'Africa';

#Bài 3: Average Population of Each Continent
SELECT COUNTRY.CONTINENT,FLOOR(AVG(CITY.POPULATION))
    FROM COUNTRY 
    INNER JOIN CITY ON  CITY.COUNTRYCODE = COUNTRY.CODE
    GROUP BY COUNTRY.CONTINENT;

#Bài 4: Top Competitors
SELECT Hackers.hacker_id,Hackers.name FROM Hackers
    INNER JOIN Submissions ON Hackers.hacker_id = Submissions.hacker_id 
    INNER JOIN Challenges ON Challenges.challenge_id = Submissions.challenge_id 
    INNER JOIN Difficulty 
        ON (Difficulty.difficulty_level = Challenges.difficulty_level AND Difficulty.score = Submissions.score)
    GROUP BY Hackers.hacker_id,Hackers.name
    HAVING COUNT(Challenges.challenge_id) >1
    ORDER BY COUNT(Challenges.challenge_id) DESC,Hackers.hacker_id;   
    
    
#Bài 5: The PADS 
(SELECT CONCAT(Name,'(',SUBSTR(Occupation,1,1),')') 
    FROM OCCUPATIONS)
UNION
    (SELECT CONCAT('There are a total of ',COUNT(*),' ',LOWER(Occupation),'s.')
    FROM OCCUPATIONS GROUP BY Occupation) 
ORDER BY 1;


#Bài 6: Ollivander's Inventory
SELECT Wands.id,Wands_Property.age,Wands.coins_needed,Wands.power
    FROM Wands JOIN Wands_Property ON Wands.code = Wands_Property.code 
    WHERE Wands_Property.is_evil = 0 
        AND Wands.coins_needed = (
            SELECT MIN(coins_needed) 
            FROM Wands wa INNER JOIN Wands_Property wp
            ON wa.code = wp.code 
            WHERE wa.code = Wands.code AND wa.power = Wands.power )
    ORDER BY 4 DESC, 2 DESC;


#Bài 7: Challenges
WITH new_table AS(
        SELECT 
        hackers.hacker_id AS id,hackers.name AS name,COUNT(challenges.challenge_id) AS total
        FROM Hackers LEFT JOIN Challenges ON hackers.hacker_id = challenges.hacker_id
        GROUP BY hackers.hacker_id,hackers.name),
        same_challenges_created AS(
        SELECT
        total AS same_number_of_challenges FROM new_table
        GROUP BY total
        HAVING COUNT(total) >1
        ORDER BY total DESC LIMIT 1,18446744073709551615)
SELECT id,name,total FROM new_table
    WHERE total NOT IN(SELECT same_number_of_challenges FROM same_challenges_created)
    ORDER BY total DESC,id;


#Bài 8: Contest Leaderboard
SELECT nw.hacker_id,h.name,SUM(nw.mx_scores) AS scrs 
    FROM (
        SELECT hacker_id, challenge_id,MAX(s.score) AS mx_scores
        FROM submissions s
        WHERE s.score != 0
        GROUP BY hacker_id,challenge_id
        ORDER BY hacker_id ) nw
    JOIN hackers h ON h.hacker_id = nw.hacker_id
    GROUP BY nw.hacker_id,h.name
    ORDER BY scrs DESC,nw.hacker_id;

#Bài 9: SQL Project Planning
Select  
a.start_date as a,
(select min(b.end_date) from projects b where b.end_date not in (select start_date from projects) and b.end_date > a.start_date) as c
from projects a where a.start_date not in (select end_date from projects )
order by c-a,a; 

#Bài 10: Placements
with newtable as(
    (select s.id as id, s.name as name,p.salary as salary, pp.salary as fsalary 
	from students s 
    inner join friends f on s.id = f.id 
    inner join packages p on s.id = p.id 
    inner join packages pp on pp.id = f.friend_id))
select newtable.name from newtable where newtable.fsalary > newtable.salary 
order by newtable.fsalary;

#Bài 11: Symmetric Pairs
SELECT distinct * 
FROM 
(   SELECT X, Y 
        FROM Functions 
        WHERE X <= Y 
    UNION ALL
    SELECT Y, X 
        FROM Functions 
        WHERE X > Y
) a 
GROUP BY X, Y 
HAVING COUNT(*) > 1 
ORDER BY X , Y ;
#Bài 12: Interviews
-- Chưa tìm ra phương án