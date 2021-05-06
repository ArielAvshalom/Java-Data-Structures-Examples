CREATE TABLE orders
(
	order_id INT,
	order_date DATE,
	customer_name VARCHAR(250),
	city VARCHAR(100),	
	order_amount MONEY
);
 
INSERT INTO orders values('1001','04/01/2017','David Smith','GuildFord',10000);
INSERT INTO orders values('1002','04/02/2017','David Jones','Arlington',20000);
INSERT INTO orders values('1003','04/03/2017','John Smith','Shalford',5000);
INSERT INTO orders values('1004','04/04/2017','Michael Smith','GuildFord',15000);
INSERT INTO orders values('1005','04/05/2017','David Williams','Shalford',7000);
INSERT INTO orders values('1006','04/06/2017','Paum Smith','GuildFord',25000);
INSERT INTO orders values('1007','04/10/2017','Andrew Smith','Arlington',15000);
INSERT INTO orders values('1008','04/11/2017','David Brown','Arlington',2000);
INSERT INTO orders values('1009','04/20/2017','Robert Smith','Shalford',1000);
INSERT INTO orders values('1010','04/25/2017','Peter Smith','GuildFord',500);

select *, sum(order_amount) over (partition by city) from orders;

select *, avg(order_amount) over (partition by city) from orders;


select *, rank() over(order by order_amount DESC) from orders;

select *, dense_rank() over(order by order_amount asc) from orders;

select *, ntile(5) over(order by order_amount) from orders;