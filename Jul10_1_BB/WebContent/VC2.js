function check() {
	var n = document.bb.n;
	
	if (isEmpty(n)
			|| lessThan(n, 3)
			|| moreThan(n, 3)
			|| isNotNumber(n)) {
		alert("���ڸ� �ȳ־��ų� 3�ڸ������ƴϰų� ���ڰ��ƴϰų�");
		n.value = "";
		n.focus();	
		return false;
	}
	
	if (n.value[0] == n.value[1]
			|| n.value[0] == n.value[2]
			|| n.value[1] == n.value[2]){
		alert("���� 3�ڸ� �ٸ���");
		n.value = "";
		n.focus();
		return false;
	}
			
	return true;		
			
	
}