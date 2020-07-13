function bbCheck() {
	
var n = document.bb.n;
	
	if (isEmpty(n)
			|| lessThan(n, 3)
			|| moreThan(n, 3)
			|| isNotNumber(n)) {
		alert("숫자를 안넣었거나 3자리수가아니거나 숫자가아니거나");
		n.value = "";
		n.focus();	
		return false;
	}
	
	if (n.value[0] == n.value[1]
			|| n.value[0] == n.value[2]
			|| n.value[1] == n.value[2]){
		alert("숫자 3자리 다르게");
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
		alert("숫자만")
		xInput.value ="";
		xInput.focus();
		return false;
	}
	if (isEmpty(yInput) 
			|| isNotNumber(yInput)){
		alert("숫자만")
		yInput.value ="";
		yInput.focus();
		return false;
	}
	
}
return true;