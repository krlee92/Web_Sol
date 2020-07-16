function goCoffeeInfo(n){
	location.href = "CoffeeInfoController?name=" + n;
	
}

function deleteCoffee(n){
	location.href = "CoffeeDeleteController?name=" + n;
}										// CoffeeDeleteController에 변수명 name= n이라는 값을 들고 감
//												?name=" + n;이 없이 가면
//												CoffeeDAO.deleteCoffee()메서드에서 String n = requeset.getParameter("name")값이 없음.


