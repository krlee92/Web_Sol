function bbCheck() {
	
var n = document.bb.n;
	
	if (isEmpty(n)
			|| lessThan(n, 3)
			|| moreThan(n, 3)
			|| isNotNumber(n)) {
		alert("���ڸ� �ȳ־��ų� 3�ڸ������ƴϰų� ���ڰ��ƴϰų�");
		n.value = "";
		n.focus();	
		return false;
	}
	
	if (n.value[0] == n.value[1]
			|| n.value[0] == n.value[2]
			|| n.value[1] == n.value[2]){
		alert("���� 3�ڸ� �ٸ���");
		n.value = "";
		n.focus();
		return false;
	}
	
}

function bCheck() {
	
	
}


function calcCheck() {
	var xInput = document.calcForm.x;
	var yInput = document.calcForm.y;
	
	if (isEmpty(xInput) 
			|| isNotNumber(xInput)){
		alert("���ڸ�")
		xInput.value ="";
		xInput.focus();
		return false;
	}
	if (isEmpty(yInput) 
			|| isNotNumber(yInput)){
		alert("���ڸ�")
		yInput.value ="";
		yInput.focus();
		return false;
	}
	
}
return true;