function aCheck() {

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
