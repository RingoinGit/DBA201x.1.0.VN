#Yêu cầu 1: Tạo bảng dữ liệu trong cơ sở dữ liệu online_shop
-- Done run online_shop.sql

#Yêu cầu 2: Chạy câu truy vấn và đưa ra nhận xét
create view customer_sale1 as select * from sales s join customers c on c.id = s.customer_id;
-- Truy vấn không chạy được xuất hiện báo lỗi Error Code: 1060. Duplicate column name 'id'. 
-- Do kết quả sau khi join 2 bảng xuất hiện 2 cột tên Id, vi phạm quy tắc tạo view.

create  algorithm=merge view customer_sale2 as select c.id  from sales s join customers c on c.id = s.customer_id;
-- Truy vấn này chạy được, vì kết quả trả về của mệnh đề select chỉ là 1 cột id, không có hàm tổng hợp nào trong mệnh đề select

create  algorithm=temptable view customer_sale3 as select c.id  from sales s join customers c on c.id = s.customer_id;
-- Truy vấn chạy thành công, vì mệnh đề select trả về kết quả chỉ là 1 cột id.

create  algorithm=merge view customer_sale4 as select count(*), c.id  from sales s join customers c on c.id = s.customer_id;
-- Truy vấn chạy được nhưng xuất hiện cảnh báo rằng đã chuyển câu lệnh algorithm từ merge sang undefined 
-- vì không thể áp dụng được merge trong tình huống có hàm tổng hợp trong mệnh đề select 
-- (view tạo bởi thuật toán merge sẽ liên kết với bảng và có thể thực hiện chỉnh sửa bảng từ view.)

create  algorithm=undefined view customer_sale5 as select count(*), c.id  from sales s join customers c on c.id = s.customer_id;
-- Truy vấn này chạy được.
-- Thuật toán undefined là mặc định khi tạo view, nó sẽ tự động lựa chọn thuật toán phù hợp nhất cho view dựa trên mệnh đề select.
