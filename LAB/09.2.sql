use book_data;
#Yêu cầu 1: Tạo bảng dữ liệu	
CREATE TABLE reviewers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100)
);

CREATE TABLE series(
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) not null,
    released_year YEAR(4),
    genre VARCHAR(100)
);

CREATE TABLE reviews (
    id INT AUTO_INCREMENT PRIMARY KEY,
    rating FLOAT(2,1),
    series_id INT,
    reviewer_id INT,
    FOREIGN KEY(series_id) REFERENCES series(id),
    FOREIGN KEY(reviewer_id) REFERENCES reviewers(id)
);

#Yêu cầu 2: Insert dữ liệu vào các bảng Reviewers, Series và Reviews	
INSERT INTO series (title, released_year, genre) VALUES
    ('Archer', 2009, 'Animation'),
    ('Arrested Development', 2003, 'Comedy'),
    ("Bob's Burgers", 2011, 'Animation'),
    ('Bojack Horseman', 2014, 'Animation'),
    ("Breaking Bad", 2008, 'Drama'),
    ('Curb Your Enthusiasm', 2000, 'Comedy'),
    ("Fargo", 2014, 'Drama'),
    ('Freaks and Geeks', 1999, 'Comedy'),
    ('General Hospital', 1963, 'Drama'),
    ('Halt and Catch Fire', 2014, 'Drama'),
    ('Malcolm In The Middle', 2000, 'Comedy'),
    ('Pushing Daisies', 2007, 'Comedy'),
    ('Seinfeld', 1989, 'Comedy'),
    ('Stranger Things', 2016, 'Drama');
 
 
INSERT INTO reviewers (first_name, last_name) VALUES
    ('Thomas', 'Stoneman'),
    ('Wyatt', 'Skaggs'),
    ('Kimbra', 'Masters'),
    ('Domingo', 'Cortes'),
    ('Colt', 'Steele'),
    ('Pinkie', 'Petit'),
    ('Marlon', 'Crafford');
    
 
INSERT INTO reviews(series_id, reviewer_id, rating) VALUES
    (1,1,8.0),(1,2,7.5),(1,3,8.5),(1,4,7.7),(1,5,8.9),
    (2,1,8.1),(2,4,6.0),(2,3,8.0),(2,6,8.4),(2,5,9.9),
    (3,1,7.0),(3,6,7.5),(3,4,8.0),(3,3,7.1),(3,5,8.0),
    (4,1,7.5),(4,3,7.8),(4,4,8.3),(4,2,7.6),(4,5,8.5),
    (5,1,9.5),(5,3,9.0),(5,4,9.1),(5,2,9.3),(5,5,9.9),
    (6,2,6.5),(6,3,7.8),(6,4,8.8),(6,2,8.4),(6,5,9.1),
    (7,2,9.1),(7,5,9.7),
    (8,4,8.5),(8,2,7.8),(8,6,8.8),(8,5,9.3),
    (9,2,5.5),(9,3,6.8),(9,4,5.8),(9,6,4.3),(9,5,4.5),
    (10,5,9.9),
    (13,3,8.0),(13,4,7.2),
    (14,2,8.5),(14,3,8.9),(14,4,8.9);



#Yêu cầu 3: Viết truy vấn tất cả bản ghi (các hàng dữ liệu) của bảng reviewers, series và reviews:	
SELECT * FROM reviewers;
SELECT * FROM series;
SELECT * FROM reviews;


#Yêu cầu 4: Sử dụng phép join bảng series và reviews
SELECT title,rating FROM series INNER JOIN reviews ON series.id = series_id ORDER BY title;

#Yêu cầu 5: Viết truy vấn để tính trung bình rating của mỗi series trong bảng series
SELECT title,AVG(rating) AS avg_rating 
    FROM series 
    JOIN reviews ON series.id = series_id 
    GROUP BY series.id 
    ORDER BY avg_rating;

#Yêu cầu 6: Viết truy vấn để tìm trung bình rating của mỗi thể loại (genre) trong bảng series
SELECT genre,ROUND(AVG(rating),2) AS avg_rating 
    FROM series 
    JOIN reviews ON series.id = series_id 
    GROUP BY genre 
    ORDER BY genre;

#Yêu cầu 7: Viết truy vấn để tính trung bình rating của mỗi người review trong bảng reviewers
SELECT first_name,last_name,ROUND(rating,1)
    FROM reviewers 
    JOIN reviews ON reviewers.id = reviewer_id 
    ORDER BY reviewers.id;

#Yêu cầu 8: Viết truy vấn để tìm những series chưa được review trong bảng series	
SELECT title AS unreviewed_series 
    FROM series 
    LEFT JOIN reviews 
    ON series.id = reviews.series_id 
    WHERE rating IS NULL;

#Yêu cầu 9: Viết truy vấn để thống kê số review của mỗi người reviewers
SELECT first_name,last_name,
    IFNULL(COUNT(reviews.reviewer_id),0) AS 'COUNT',
    IFNULL(MIN(rating),0) AS 'MIN',
    IFNULL(MAX(rating),0) AS 'MAX',
    ROUND(IFNULL(AVG(rating),0),2) AS 'AVG',
    CASE 
		WHEN IFNULL(COUNT(reviews.reviewer_id),0) = 0 THEN 'INACTIVE'
		ELSE 'ACTIVE'
    END AS 'STATUS'
FROM reviewers 
LEFT JOIN reviews 
ON reviewers.id = reviews.reviewer_id 
GROUP BY reviewers.id
ORDER BY reviewers.id;

#Yêu cầu 10: Viết truy vấn để join ba bảng reviewers, reviews, series
SELECT title,rating,CONCAT(first_name," ", last_name) AS reviewers
FROM series 
INNER JOIN reviews ON series.id = reviews.series_id
INNER JOIN reviewers ON reviewers.id = reviews.reviewer_id
ORDER BY title;



