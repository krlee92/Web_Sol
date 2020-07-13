package com.lee.game.lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

// []
// List - ���������� �迭
// set - �ߺ��� ������ ������ �˾Ƽ� ����, ���� ���ڴ��
// Map - K-V, ���� x

public class LottoMachine {
	public static void pick(HttpServletRequest request) {

		HashSet<Integer> lotto = new HashSet<Integer>();
		while (true) {
			lotto.add(new Random().nextInt(45) + 1);
			if (lotto.size() == 6) {
				break;
			}
		}
		// Set -> List
		ArrayList<Integer> lotto2 = new ArrayList<Integer>(lotto);
		
		// List���Ŀ� ��ü
		Comparator<Integer> c = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		};
		
		lotto2.sort(c);
		request.setAttribute("lottoBall", lotto2);
	}

}
