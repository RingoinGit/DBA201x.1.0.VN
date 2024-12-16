use book_data;
#Yêu cầu 1: Tạo bảng dữ liệu
CREATE TABLE students(Id INT AUTO_INCREMENT PRIMARY KEY, first_name VARCHAR(150) NOT NULL);
CREATE TABLE papers(student_id INT , title VARCHAR(150), grade INT, FOREIGN KEY (student_id) REFERENCES students(Id));


#Yêu cầu 2: Insert dữ liệu vào các bảng students và papers
INSERT INTO students (first_name) VALUES 
('Caleb'), ('Samantha'), ('Raj'), ('Carlos'), ('Lisa');

INSERT INTO papers (student_id, title, grade ) VALUES
(1, 'My First Book Report', 60),
(1, 'My Second Book Report', 75),
(2, 'Russian Lit Through The Ages', 94),
(2, 'De Montaigne and The Art of The Essay', 98),
(4, 'Borges and Magical Realism', 89);


#Yêu cầu 3: Viết truy vấn tất cả bản ghi (các hàng dữ liệu) của bảng students và papers:
select * from students;
select * from papers;


#Yêu cầu 4: Sử dụng phép các Join hợp lý của bảng students và papers để tạo được kết quả theo mẫu
SELECT first_name,title,grade FROM students LEFT JOIN papers ON Id = student_id ORDER BY Id;

SELECT  first_name,
        IFNULL(title,"MISSING"),
        IFNULL(grade,0) 
    FROM students 
    LEFT JOIN papers 
    ON Id = student_id 
    ORDER BY Id;

SELECT first_name,IFNULL(AVG(grade),0) AS average  FROM students LEFT JOIN papers ON Id = student_id GROUP BY first_name ORDER BY average DESC;

SELECT first_name,
    IFNULL(AVG(grade),0) AS average,
    CASE 
        WHEN AVG(grade) >= 80 THEN 'PASSING'
        ELSE 'FAILING'
	END AS passing_status
FROM students 
LEFT JOIN papers ON Id = student_id 
GROUP BY first_name 
ORDER BY average DESC;
