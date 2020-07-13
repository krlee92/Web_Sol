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

	public void 정답뽑기() {
		int 정답 = new Random().nextInt(976) + 12; // 12 ~ 987
		String 정답2 = String.format("%03d", 정답); // 012 ~ 987

		if (정답2.charAt(0) == 정답2.charAt(1) || 정답2.charAt(1) == 정답2.charAt(2) || 정답2.charAt(0) == 정답2.charAt(2)) {
			정답뽑기();
			return ;
		}
		ans = 정답2;
		System.out.println(ans);
	}

	public void judge(HttpServletRequest request) {
		String n = request.getParameter("n");
		int s = 0;
		int b = 0;
		// 자릿수 다른데 숫자가 있기만 하면 B
		// 자릿수 맞고 숫자 맞으면 S
		
		
		// 게임답 : 728
		// 내답 : 237
		for (int j = 0; j < ans.length(); j++) {
			for (int i = 0; i < n.length(); i++) {
				if (n.charAt(i) == ans.charAt(j)) {
					if (i == j) {
						s++;
					} else {
						b++;
					}
					break; // 내답2(첫번째자리)가 게임답 2(두번쨰자리)와 맞으면,
							//게임답 세번째자리와 비교할 필요가 없다. i문 break하는게 효율적이다.
							// break는 무조건 가까운 반복문을 멈춘다. j를 멈추려면 j for문에 이름을 주고 break 이름;
				}
				
			}
		}
		request.setAttribute("s", s);
		request.setAttribute("b", b);
		
		if (s == 3) {
			정답뽑기();
			System.out.println(request.getRemoteAddr());
		}
		
	}
}
