use hr;
#1. Truy vấn first name, last name, job id và salary của các nhân viên có tên bắt đầu bằng chữ “S”.
Select first_name, last_name, job_id from employees where substr(first_name,1,1) = 'S';

#2. Viết truy vấn để tìm các nhân viên có số lương (salary) cao nhất.
select employee_id, first_name, last_name, job_id, salary from employees where salary = (select max(salary) from employees) ;

#3. Viết truy vấn để tìm các nhân viên có số lương lớn thứ hai. 
#Ví dụ có 5 nhân viên có mức lương lần lượt là 4, 4, 3, 3, 2 thì kết quả  đúng của mức lương lớn thứ hai sẽ là 3,3
with table_3 as(
select *, DENSE_RANK() OVER (ORDER BY salary DESC) 'RANK' from employees
)
select employee_id, first_name, last_name, job_id, salary from table_3 
	where table_3.RANK = 2;
    
#4. Viết truy vấn để tìm các nhân viên có số lương lớn thứ ba. Tương tự như yêu cầu 3
with table_4 as(
select *, DENSE_RANK() OVER (ORDER BY salary DESC) 'RANK' from employees
)
select employee_id, first_name, last_name, job_id, salary from table_4 
	where table_4.RANK = 3;

#5. Viết truy vấn để hiển thị mức lương của nhân viên cùng với người quản lý tương ứng, tên nhân viên và quản lý kết hợp từ first_name và last_name.
select concat(emp.first_name,' ',emp.last_name) employee,
        emp.salary emp_sal,
        concat(mgr.first_name,' ',mgr.last_name) manager,
        mgr.salary mgr_sal
 from employees emp
 join employees mgr on emp.manager_id = mgr.employee_id;

#6. Viết truy vấn để tìm số lượng nhân viên cần quản lý của mỗi người quản lý, tên quản lý kết hợp từ first_name và last_name.
 select 
 man.employee_id employee_id,
     concat(man.first_name,' ', man.last_name) manager_name,
     count(emp.employee_id) as number_of_reportees
 from employees emp 
 join employees man 
 on emp.manager_id = man.employee_id
 group by man.employee_id, man.first_name, man.last_name
 order by number_of_reportees desc;

#7. Viết truy vấn để tìm được số lượng nhân viên trong mỗi phòng ban sắp xếp theo thứ tự số nhân viên giảm dần.
select dept.department_name,
 count(emp.employee_id) emp_count
 from employees emp
 join departments dept on emp.department_id = dept.department_id
 group by dept.department_name
 order by emp_count desc;

#8. Viết truy vấn để tìm số lượng nhân viên được thuê trong mỗi năm sắp xếp theo thứ tự số lương nhân viên giảm dần.
select year(hire_date) hired_year, count(*) employees_hired_count
 from employees
 group by year(hire_date)
 order by employees_hired_count desc;

#9. Viết truy vấn để lấy mức lương lớn nhất, nhỏ nhất và mức lương trung bình của các nhân viên (làm tròn mức lương trung bình về số nguyên).
select min(salary) min_sal, 
 max(salary) max_sal,
 round(avg(salary)) avg_sal
 from employees;

#10. Viết truy vấn để chia nhân viên thành ba nhóm dựa vào mức lương, tên nhân viên được kết hợp từ first_name và last_name, kết quả sắp xếp theo tên thứ tự tăng dần.
select concat(first_name,' ',last_name) employee, salary,
 case
 when salary >=2000 and salary < 5000 then "low" 
 when salary >=5000 and salary < 10000 then "mid"
 else
 "high"
 end as salary_level
 from employees
 order by employee;

#11. Viết truy vấn hiển thị họ tên nhân viên và số điện thoai theo định dạng (_ _ _)-(_ _ _)-(_ _ _ _). Tên nhân viên kết hợp từ first_name và last_name, kết quả hiển thị như bảng dưới đây:
select concat(first_name, ' ', last_name) employee,
 replace(phone_number,'.','-') phone_number
 from employees;

#12. Viết truy vấn để tìm các nhân viên gia nhập vào tháng 08-1994, tên nhân viên kết hợp từ first_name và last_name.
select concat(first_name, ' ', last_name) employee, hire_date
 from employees
 where date_format(hire_date,'%Y-%m') = '1994-08';

#13. Viết truy vấn để tìm những nhân viên có mức lương cao hơn mức lương trung bình của các nhân viên, kết quả sắp xếp theo thứ tự tăng dần của department_id.
select 
 concat(emp.first_name,last_name) 'name', emp.employee_id, dept.department_name department, dept.department_id, emp.salary
 from departments dept
 join employees emp on dept.department_id = emp.department_id
 where emp.salary > (select avg(salary) from employees)
 order by dept.department_id;


#14. Viết truy vấn để tìm mức lương lớn nhất ở mỗi phòng ban, kết quả sắp xếp theo thứ tự tăng dần của department_id.
select 
 dept.department_id, dept.department_name department, max(emp.salary)maximum_salary
 from departments dept
 join employees emp on dept.department_id = emp.department_id
 group by dept.department_name,
 dept.department_id
 order by dept.department_id ;

#15. Viết truy vấn để tìm 5 nhân viên có mức lương thấp nhất.
select 
 first_name, last_name, employee_id, salary
 from employees
 order by salary
 limit 5;

#16. Viết truy vấn để hiển thị tên nhân viên theo thứ tự ngược lại.
select lower(first_name) 'name', 
lower(reverse(first_name)) name_in_reverse
 from employees;

#17. Viết truy vấn để tìm những nhân viên đã gia nhập vào sau ngày 15 của tháng.
select employee_id,
 concat(first_name, ' ' , last_name) employee, hire_date
 from employees
 where day(hire_date)> 15;

#18. Viết truy vấn để tìm những quản lý và nhân viên làm trong các phòng ban khác nhau, kết quả sắp xếp theo thứ tự tăng dần của tên người quản lý (tên nhân viên và quản lý kết hợp từ first_name và last_name).
select 
  concat(mgr.first_name,' ',mgr.last_name) manager,
  concat(emp.first_name,' ',emp.last_name) employee,
  mgr.department_id mgr_dept, emp.department_id emp_dept
  from employees emp
  join employees mgr on emp.manager_id = mgr.employee_id
  where emp.department_id != mgr.department_id
  order by manager;

