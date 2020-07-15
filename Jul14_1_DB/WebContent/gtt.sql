create table jul15_coffee(
	c_name varchar2(10 char) primary key,
	c_price number(5) not null
);

INSERT INTO JUL15_COFFEE VALUES('아메리카노', 1500);
INSERT INTO JUL15_COFFEE VALUES('쉐이크', 1500);

SELECT * FROM JUL15_COFFEE;