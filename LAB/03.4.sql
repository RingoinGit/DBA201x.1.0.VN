use cat_app;
select * from cats;

UPDATE cats SET name = 'Jack' WHERE name = 'jackson';
select * from cats;

UPDATE cats SET name= 'Bitish Shorthair' WHERE name = 'Ringo';
select * from cats;

UPDATE cats SET age = 12 WHERE breed = 'Maine Coon';
select * from cats;

DELETE FROM cats where age = 4;
select * from cats;

DELETE FROM cats where cat_id = age;
select * from cats;

DELETE FROM cats;
select * from cats;
