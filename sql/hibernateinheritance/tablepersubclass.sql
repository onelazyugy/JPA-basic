use mydb;

drop table payment;
drop table card;
drop table bankcheck;


create table payment(
	id int PRIMARY KEY,
	amount decimal(8,3)
);

create table card(
	id int ,
	cardnumber varchar(20),
	 FOREIGN KEY (id)
	REFERENCES payment(id)
)

create table bankcheck(
	id int ,
	checknumber varchar(20),
	FOREIGN KEY (id)
	REFERENCES payment(id)
)

select * from payment;
select * from card;
select * from bankcheck;