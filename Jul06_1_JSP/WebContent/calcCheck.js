// �����ڵ�

function check() {
	
	var numInput = document.calcFrom.n;
	
	if (isEmpty(numInput)
			|| isNotNumber(numInput)) {
		alert("�Է� �ȹٷ�")
		numInput.value= "";
		numInput.focus();
		return false;
	}
	return true;
}
