use mydb

drop table employee;

create table employee(
id int,
name varchar(20),
streetaddress varchar(30),
city varchar(20),
state varchar(20),
zipcode varchar(20),
country varchar(20)
)

select * from employee