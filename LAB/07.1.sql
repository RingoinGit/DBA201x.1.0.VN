-- LAB 7.1:
use book_data;
# Yêu cầu 1: Viết truy vấn để đếm số lượng cuốn sách trong bảng books	2
SELECT COUNT(*) FROM books;

# Yêu cầu 2: Viết truy vấn để tìm số lượng cuốn sách được xuất bản trong mỗi năm	2
SELECT COUNT(stock_quantity) AS number_book,released_year FROM books GROUP BY released_year ORDER BY released_year;

# Yêu cầu 3: Viết truy vấn để tìm tổng số lượng cuốn sách tồn kho (sử dụng cột stock_quantity)	3
SELECT SUM(stock_quantity) AS sum_stock FROM books;

# Yêu cầu 4: Viết truy vấn để tìm số năm trung bình xuất bản các cuốn sách của mỗi tác giả	3
SELECT CONCAT(author_fname," ",author_lname) AS author_name, AVG(released_year) AS avg_released_year FROM books GROUP BY author_name;

# Yêu cầu 5: Viết truy vấn để tìm tên đầy đủ của tác giả đã viết cuốn sách có số trang nhiều nhất
SELECT CONCAT(author_fname, " ", author_lname) AS author_fullname, pages FROM books WHERE pages = (SELECT MAX(pages) FROM books);
