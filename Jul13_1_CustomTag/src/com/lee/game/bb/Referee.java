package com.lee.game.bb;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class Referee {

	private String ans;

	private static final Referee REFEREE = new Referee();

	private Referee() {
		// TODO Auto-generated constructor stub
	}

	public static Referee getReferee() {
		return REFEREE;
	}

	public void ����̱�() {
		int ���� = new Random().nextInt(976) + 12; // 12 ~ 987
		String ����2 = String.format("%03d", ����); // 012 ~ 987

		if (����2.charAt(0) == ����2.charAt(1) || ����2.charAt(1) == ����2.charAt(2) || ����2.charAt(0) == ����2.charAt(2)) {
			����̱�();
			return ;
		}
		ans = ����2;
		System.out.println(ans);
	}

	public void judge(HttpServletRequest request) {
		String n = request.getParameter("n");
		int s = 0;
		int b = 0;
		// �ڸ��� �ٸ��� ���ڰ� �ֱ⸸ �ϸ� B
		// �ڸ��� �°� ���� ������ S
		
		
		// ���Ӵ� : 728
		// ���� : 237
		for (int j = 0; j < ans.length(); j++) {
			for (int i = 0; i < n.length(); i++) {
				if (n.charAt(i) == ans.charAt(j)) {
					if (i == j) {
						s++;
					} else {
						b++;
					}
					break; // ����2(ù��°�ڸ�)�� ���Ӵ� 2(�ι����ڸ�)�� ������,
							//���Ӵ� ����°�ڸ��� ���� �ʿ䰡 ����. i�� break�ϴ°� ȿ�����̴�.
							// break�� ������ ����� �ݺ����� �����. j�� ���߷��� j for���� �̸��� �ְ� break �̸�;
				}
				
			}
		}
		request.setAttribute("s", s);
		request.setAttribute("b", b);
		
		if (s == 3) {
			����̱�();
			System.out.println(request.getRemoteAddr());
		}
		
	}
}
