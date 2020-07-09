function check() {
	var tasuInput = document.bbForm.tasu;
	var antaInput = document.bbForm.anta;
	if (isEmpty(tasuInput) || isNotNumber(tasuInput) || isEmpty(antaInput)
			|| isNotNumber(antaInput)) {
		alert("숫자만");
		tasuInput.value = "";
		antaInput.value = "";
		tasuInput.focus();
		return false;
	}
	// JavaScript
	// String -> int : xxx * 1
	if (tasuInput.value * 1 < antaInput.value * 1) {
		alert("말이 되게");
		tasuInput.value = "";
		antaInput.value = "";
		tasuInput.focus();
		return false;
	}
	return true;
}