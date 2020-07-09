function check() {
	var nameInput = document.bmiForm.n;
	var heightInput = document.bmiForm.h;
	var weightInput = document.bmiForm.w;
	var photoInput = document.bmiForm.p;

	if (isEmpty(nameInput)) {
		alert("�̸�!");
		nameInput.value = "";
		nameInput.focus();
		return false;
	}
	if (isEmpty(heightInput) || isNotNumber(heightInput)) {
		alert("Ű!");
		heightInput.value = "";
		heightInput.focus();
		return false;
	}
	if (isEmpty(weightInput) || isNotNumber(weightInput)) {
		alert("������!");
		weightInput.value = "";
		weightInput.focus();
		return false;
	}
	if (isEmpty(photoInput)
			|| (isNotType(photoInput, "png") && isNotType(photoInput, "gif")
					&& isNotType(photoInput, "jpg") && isNotType(photoInput,
					"bmp"))) {
		alert("����!");
		return false;
	}

	return true;
}