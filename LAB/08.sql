#Yêu cầu 1: Thực hiện các truy vấn
SELECT CURTIME();
SELECT CURDATE();
SELECT NOW();
SELECT DAYOFWEEK(CURDATE());
SELECT DAYOFWEEK(NOW());
SELECT DATE_FORMAT(NOW(), '%w') + 1;
SELECT DAYNAME(NOW());
SELECT DATE_FORMAT(NOW(), '%W');
SELECT DATE_FORMAT(CURDATE(), '%m/%d/%Y');
SELECT DATE_FORMAT(NOW(), '%M %D at %h:%i');

#Yêu cầu 2: TẠO BẢNG tweets , NHẬP LIỆU VÀ TRUY VẤN
use book_data;
create table tweets(
content varchar(140),
username varchar(20),
created_at timestamp default( now())) ;
insert into tweets(content,username) values
	('this is my first tweet', 'coltscat'),
	('this is my second tweet', 'coltscat');
SELECT * FROM tweets;
-- NHẬN XÉT CỘT created_at: THỜI GIAN ĐƯỢC TẠO TỰ ĐỘNG VÀ ĐỒNG THỜI KHI NHẬP DỮ LIỆU
