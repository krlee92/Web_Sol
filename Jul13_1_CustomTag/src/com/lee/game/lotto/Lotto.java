package com.lee.game.lotto;

import java.util.HashSet;
import java.util.Random;

public class Lotto {

	public static void main(String[] args) {
		
//		HashSet�� �ߺ��˻� �˾Ƽ� ����.

		HashSet<Integer> lotto = new HashSet<Integer>();
		while (true) {
			lotto.add(new Random().nextInt(45) + 1);

			if (lotto.size() == 6) {
				break;
			}
		}

	}

}
