
#Yêu cầu 1: Tạo database online_shop và table book, bookview
create database online_shop;
use online_shop;
create table book(id int primary key auto_increment, name varchar(50) not null, notes varchar(100));

#Yêu cầu 2: Tạo một view bookview
create view bookview as select * from book;

#Yêu cầu 3: Insert dữ liệu vào view
insert into bookview (id, name) values (2, "War and Peace");


#Yêu cầu 4: Xoá bookview sau đó hiển thị dữ liệu trong bảng book
drop view bookview;
select * from book;

/* dữ liệu insert vào view đã được cập nhập vào trong table, vì view chỉ liên kết đến 1 table, khi thao tác qua view sql sẽ thao tác tới bảng chính
 . Kiểu như view là rút gọn của mệnh đề select ,và trong mệnh đề selecct đã đáp ứng được các điều kiện sau:

Mệnh đề SELECT không chứa từ khóa DISTINCT.
Mệnh đề SELECT không chứa các hàm tổng.
Mệnh đề SELECT không chứa các hàm tập hợp.
Mệnh đề SELECT không chứa các toán tử tập hợp.
Mệnh đề SELECT không chứa một mệnh đề ORDER BY.
Mệnh đề FROM không chứa nhiều bảng.
Mệnh đề WHERE không chứa các truy vấn phụ.
Truy vấn không chứa GROUP BY hoặc HAVING.
Các cột được ước lượng không bị cập nhật.
Tất cả các cột NOT NULL từ bảng ban đầu phải được bao trong view để cho truy vấn INSERT vận hành.
Vì thế, nếu một view thỏa mãn tất cả các qui tắc trên, thì bạn có cập nhật một view. 
*/