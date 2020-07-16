package sqlpractice;

import java.util.Random;

import org.apache.jasper.tagplugins.jstl.core.If;

// 1p : 1, 2, 3
// 2p : 4, 5, 6
// 3p : 7, 8, 9
// 4p : 10

public class sqlPractice {
	
	
	public static int test () {
		int r = new Random().nextInt(20);
		return r;
	}
	
	public static void main(String[] args) {
		
		// test()라는 소스 대신에 a라고 써도 됨 x
		// test()함수의 수행 결과를 a에 저장 o
		int a = test();
		
		
		// 두개 차이가 뭔지
		for (int i = 0; i < 10; i++) {
			System.out.println(a);
		}
		// a출력값 하나를 10번출력
		
		System.out.println("------");
		for (int i = 0; i < 10; i++) {
			System.out.println(test());
		}
		// test메서드 랜덤결과를 10번 수행하여 출력
		
		
		
		
		
		
		
		
		
		
		
		
		int 총데이터수 = 10;
		int 한페이지당보여줄갯수 = 3;
		
		
		int 총페이지수 = (int) Math.ceil(총데이터수 / (double)한페이지당보여줄갯수); // 자바의 올림
//		System.out.println(총페이지수);
		
		int 페이지번호 = 4;
		int 시작데이터번호 = 한페이지당보여줄갯수 *(페이지번호 -1) + 1;
		int 끝데이터번호 =
				(페이지번호 == 총페이지수) ? 총데이터수 :
					시작데이터번호 + 한페이지당보여줄갯수 -1;
		
		System.out.println(시작데이터번호);
		System.out.println(끝데이터번호);
	}
}
