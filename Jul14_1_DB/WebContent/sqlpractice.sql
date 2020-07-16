create table jul15_coffee(
	c_name varchar2(10 char) primary key,
	c_price number(5) not null
);

INSERT INTO JUL15_COFFEE VALUES('�Ƹ޸�ī��', 1500);
INSERT INTO JUL15_COFFEE VALUES('����ũ', 1500);

SELECT * FROM JUL15_COFFEE;

-- �� ������ ��
select count(*) from JUL15_COFFEE;

-- �޴��� ���� �����ؼ� 4 ~ 6������ ��ȸ
-- rownum�� select�Ҷ����� �ο���
-- rownum������ 1�����͸� ��. 4������ x
-- �׷��� rn���� ġȯ�ؼ� �װ� 4~6����
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

delete from JUL15_COFFEE where c_name = '������' ;

update jun25_menu
set m_price =6000;


