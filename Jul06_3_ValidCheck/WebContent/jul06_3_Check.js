function check() {

	var idInput = document.jul06Form.id;
	var pwInput = document.jul06Form.pw;
	var pwChkInput = document.jul06Form.pwCheck;
	var ageInput = document.jul06Form.age;
	var photoInput = document.jul06Form.photo;
	
	if (isEmpty(idInput) 
			|| lessThan(idInput, 4) 
			|| containsHS(idInput)){
		alert("id똑바로")
		idInput.value = "";
		idInput.focus();
		return false;
	}
	
	if (isEmpty(pwInput) 
			|| lessThan(pwInput, 3)
			|| notEquals(pwInput, pwChkInput)
			|| notContains(pwInput, "1234567890")
			|| notContains(pwInput, "QWERTYUIOPASDFGHJKLZXCVBNM")){
		alert("pw똑바로")
		pwInput.value = "";
		pwInput.focus();
		return false;
	}
	
	if (isEmpty(ageInput) 
			|| isNotNumber(ageInput)) {
		alert("나이 똑바로")
		ageInput.value = "";
		ageInput.focus();
		return false;
	}
	
	// png나 jpg나 gif나 bmp를 필수로 하게
	// type="file"의 input.value는 파일명
	// 조건식은 ( 선택안함 || 사진이 아님)
	// 사진이아님= png도아니고, jpg도아니고,...
	if (isEmpty(photoInput)	||
			(isNotType(photoInput,"png")
			&& isNotType(photoInput,"gif")
			&& isNotType(photoInput,"jpg")
			&& isNotType(photoInput,"bmp"))
			){
		alert("사진똑바로");
		return false;
	}
	
	return true;
}

	
