use mydb

-- identity strategy
create table employee(
	id int PRIMARY KEY AUTO_INCREMENT,
	name varchar(20)
)
-- end identity strategry


-- table strategry
create table employee(
	id int PRIMARY KEY,
	name varchar(20)
)

create table id_gen(
	gen_name varchar(60) PRIMARY KEY,
	gen_val int(20)
)
-- end table strategry



drop table employee

select * from employee;

select * from id_gen;