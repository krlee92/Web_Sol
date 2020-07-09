package com.lee.gababo;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
//객체가 없어도 되나


// 객체가 필요한가? - 파란색변수가 있는가?
//		하나 - singleton pattern
//		일반적
//		대량
		
// M
//	singleton이 대부분
//	멤버변수 없음 -> static

public class Referee {
	
	private int win; // 이 심판이 진행하는 게임의 유저 승 수
	private int draw;
	private int lose;
	// Referee 객체 안만들고 gogo 활용하려고 static 활용
//			Referee r = new Referee
//			r.gogo();
	// 한 판 판정하기
	
	private static final Referee REFEREE = new Referee();
	
	private Referee() {
		// TODO Auto-generated constructor stub
	}
	
	public static Referee getReferee() {
		return REFEREE;
	}



	public void gogo(HttpServletRequest request) {
		int h = Integer.parseInt(request.getParameter("h"));
		int ch = new Random().nextInt(3) + 1;
		request.setAttribute("userHand", h + ".png");
		request.setAttribute("comHand", ch + ".png");
		
		int t = h - ch;
		if (t == 0) {
			request.setAttribute("result", "무");
			draw ++;
		} else if (t == -1 || t == 2) {
			request.setAttribute("result", "패");
			lose ++;
		} else {
			request.setAttribute("result", "승");
			win ++;
		}
		
		request.setAttribute("win", win);
		request.setAttribute("draw", draw);
		request.setAttribute("lose", lose);
		
		
		
		
		
		
	}
	
}
