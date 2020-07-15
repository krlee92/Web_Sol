function coffeeRegCheck() {
	var nameInput = document.coffeeRegForm.c_name;
	var priceInput = document.coffeeRegForm.c_price;

	if (isEmpty(nameInput)) {
		alert("메뉴명!");
		nameInput.value = "";
		nameInput.focus();
		return false;
	}
	if (isEmpty(priceInput) || isNotNumber(priceInput)) {
		alert("가격!");
		priceInput.value = "";
		priceInput.focus();
		return false;
	}

	return true;
}