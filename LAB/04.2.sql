-- CONCAT
SELECT CONCAT(author_fname," ", author_lname) AS "full name" FROM books;

-- CONCAT_WS
SELECT CONCAT_WS(" - ",author_fname, author_lname) AS "full name" FROM books;

-- SUBSTRING
SELECT SUBSTRING("data analyst",-7);

-- REPLACE
SELECT REPLACE ("data analyst",'analyst','science');
SELECT REPLACE(title," ","->") FROM books;

-- REVERSE
SELECT REVERSE("data analyst");

-- CHAR_LENGTH
SELECT CHAR_LENGTH("database");
SELECT CHAR_LENGTH(title) FROM books;

-- UPPER
SELECT UPPER("database");
SELECT UPPER(title) FROM books;

-- LOWER
SELECT LOWER("DATABASE");
SELECT LOWER(title) FROM books;




