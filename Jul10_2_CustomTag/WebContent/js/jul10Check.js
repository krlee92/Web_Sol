function aCheck() {

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
