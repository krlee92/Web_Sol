function goCoffeeInfo(n){
	location.href = "CoffeeInfoController?name=" + n;
	
}

function deleteCoffee(n){
	location.href = "CoffeeDeleteController?name=" + n;
}										// CoffeeDeleteController�� ������ name= n�̶�� ���� ��� ��
//												?name=" + n;�� ���� ����
//												CoffeeDAO.deleteCoffee()�޼��忡�� String n = requeset.getParameter("name")���� ����.


