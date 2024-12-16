select 10 !=10;
-- Sử dụng toán tử '!=' : khác

SELECT 15 > 14 && 99 -  5 <= 94;
-- Sử dụng toán tử '>' : lớn hơn; toán tử '<=' : nhỏ hơn hoặc bằng; toán tử '&&' : AND (và)

SELECT 1 IN (5,3) || 9 BETWEEN 8 AND 10;
-- Sử dụng toán tử 'IN ()' : Hoặc (); toán tử '||' : Hoặc; BETWEEN ... AND ... : Trong đoạn

#Yêu cầu 2: Hãy viết câu truy vấn để thực hiện 6 yêu cầu sau:
use book_data;
#Truy vấn tất cả cuốn sách được xuất bản (released_year) trước năm 1980
SELECT * FROM books WHERE released_year < 1980;

# Truy vấn tất cả cuốn sách được viết bởi Eggers và Chabon.
SELECT * FROM books WHERE author_lname IN("Eggers","Chabon");

# Truy vấn tất cả cuốn sách được viết bởi Lahiri và được xuất bản trước năm 2000
SELECT * FROM books WHERE author_lname = "Lahiri" AND released_year <2000;

# Truy vấn tất cả cuốn sách có số trang (pages) nằm trong khoảng từ 100 đến 200 trang:
SELECT * FROM books WHERE pages BETWEEN 100 AND 200;

# Tạo thêm cột TYPE khi sử dụng SELECT với nguyên tắc sau:
# Nếu title chứa 'stories' thì TYPE sẽ là 'Short Stories'.
# Nếu title chứa 'Just Kids' hoặc title 'A Heartbreaking Work of Staggering Genius' thì TYPE sẽ là 'Memoir'.
# Nếu title không nằm trong hai trường hợp trên thì TYPE sẽ là 'Novel'.
SELECT title, author_lname,
         CASE
             WHEN title LIKE "%stories%" THEN "Short Stories"
             WHEN title LIKE "%Just Kids%" OR title LIKE 'A Heartbreaking Work of Staggering Genius' THEN "Memoir"
             ELSE "Novel"
         END AS TYPE
         FROM books;



