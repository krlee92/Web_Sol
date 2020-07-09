function check() {

	var idInput = document.jul06Form.id;
	var pwInput = document.jul06Form.pw;
	var pwChkInput = document.jul06Form.pwCheck;
	var ageInput = document.jul06Form.age;
	var photoInput = document.jul06Form.photo;
	
	if (isEmpty(idInput) 
			|| lessThan(idInput, 4) 
			|| containsHS(idInput)){
		alert("id�ȹٷ�")
		idInput.value = "";
		idInput.focus();
		return false;
	}
	
	if (isEmpty(pwInput) 
			|| lessThan(pwInput, 3)
			|| notEquals(pwInput, pwChkInput)
			|| notContains(pwInput, "1234567890")
			|| notContains(pwInput, "QWERTYUIOPASDFGHJKLZXCVBNM")){
		alert("pw�ȹٷ�")
		pwInput.value = "";
		pwInput.focus();
		return false;
	}
	
	if (isEmpty(ageInput) 
			|| isNotNumber(ageInput)) {
		alert("���� �ȹٷ�")
		ageInput.value = "";
		ageInput.focus();
		return false;
	}
	
	// png�� jpg�� gif�� bmp�� �ʼ��� �ϰ�
	// type="file"�� input.value�� ���ϸ�
	// ���ǽ��� ( ���þ��� || ������ �ƴ�)
	// �����̾ƴ�= png���ƴϰ�, jpg���ƴϰ�,...
	if (isEmpty(photoInput)	||
			(isNotType(photoInput,"png")
			&& isNotType(photoInput,"gif")
			&& isNotType(photoInput,"jpg")
			&& isNotType(photoInput,"bmp"))
			){
		alert("�����ȹٷ�");
		return false;
	}
	
	return true;
}

	
