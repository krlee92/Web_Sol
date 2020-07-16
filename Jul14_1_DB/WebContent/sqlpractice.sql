create table jul15_coffee(
	c_name varchar2(10 char) primary key,
	c_price number(5) not null
);

INSERT INTO JUL15_COFFEE VALUES('아메리카노', 1500);
INSERT INTO JUL15_COFFEE VALUES('쉐이크', 1500);

SELECT * FROM JUL15_COFFEE;

-- 총 데이터 수
select count(*) from JUL15_COFFEE;

-- 메뉴명 기준 정렬해서 4 ~ 6번까지 조회
-- rownum은 select할때마다 부여됨
-- rownum정렬은 1번부터만 됨. 4번부터 x
-- 그래서 rn으로 치환해서 그거 4~6정렬
select rownum, rn, c_name, c_price
from(
	select rownum as rn, c_name, c_price
	from (
		select *
		from JUL15_COFFEE
		order by c_name
	)
)
where rn >= 4 and rn <= 6;

delete from JUL15_COFFEE where c_name = 'ㄹㄴㄹ' ;

update jun25_menu
set m_price =6000;


