package com.lee.gababo;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
//��ü�� ��� �ǳ�


// ��ü�� �ʿ��Ѱ�? - �Ķ��������� �ִ°�?
//		�ϳ� - singleton pattern
//		�Ϲ���
//		�뷮
		
// M
//	singleton�� ��κ�
//	������� ���� -> static

public class Referee {
	
	private int win; // �� ������ �����ϴ� ������ ���� �� ��
	private int draw;
	private int lose;
	// Referee ��ü �ȸ���� gogo Ȱ���Ϸ��� static Ȱ��
//			Referee r = new Referee
//			r.gogo();
	// �� �� �����ϱ�
	
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
			request.setAttribute("result", "��");
			draw ++;
		} else if (t == -1 || t == 2) {
			request.setAttribute("result", "��");
			lose ++;
		} else {
			request.setAttribute("result", "��");
			win ++;
		}
		
		request.setAttribute("win", win);
		request.setAttribute("draw", draw);
		request.setAttribute("lose", lose);
		
		
		
		
		
		
	}
	
}
