// 보안코딩

function check() {
	
	var numInput = document.calcFrom.n;
	
	if (isEmpty(numInput)
			|| isNotNumber(numInput)) {
		alert("입력 똑바로")
		numInput.value= "";
		numInput.focus();
		return false;
	}
	return true;
}
