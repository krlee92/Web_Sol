function check() {
	var tasuInput = document.bbForm.tasu;
	var antaInput = document.bbForm.anta;
	if (isEmpty(tasuInput) || isNotNumber(tasuInput) || isEmpty(antaInput)
			|| isNotNumber(antaInput)) {
		alert("���ڸ�");
		tasuInput.value = "";
		antaInput.value = "";
		tasuInput.focus();
		return false;
	}
	// JavaScript
	// String -> int : xxx * 1
	if (tasuInput.value * 1 < antaInput.value * 1) {
		alert("���� �ǰ�");
		tasuInput.value = "";
		antaInput.value = "";
		tasuInput.focus();
		return false;
	}
	return true;
}