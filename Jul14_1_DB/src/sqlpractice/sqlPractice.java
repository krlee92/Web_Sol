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
		
		// test()��� �ҽ� ��ſ� a��� �ᵵ �� x
		// test()�Լ��� ���� ����� a�� ���� o
		int a = test();
		
		
		// �ΰ� ���̰� ����
		for (int i = 0; i < 10; i++) {
			System.out.println(a);
		}
		// a��°� �ϳ��� 10�����
		
		System.out.println("------");
		for (int i = 0; i < 10; i++) {
			System.out.println(test());
		}
		// test�޼��� ��������� 10�� �����Ͽ� ���
		
		
		
		
		
		
		
		
		
		
		
		
		int �ѵ����ͼ� = 10;
		int ���������纸���ٰ��� = 3;
		
		
		int ���������� = (int) Math.ceil(�ѵ����ͼ� / (double)���������纸���ٰ���); // �ڹ��� �ø�
//		System.out.println(����������);
		
		int ��������ȣ = 4;
		int ���۵����͹�ȣ = ���������纸���ٰ��� *(��������ȣ -1) + 1;
		int �������͹�ȣ =
				(��������ȣ == ����������) ? �ѵ����ͼ� :
					���۵����͹�ȣ + ���������纸���ٰ��� -1;
		
		System.out.println(���۵����͹�ȣ);
		System.out.println(�������͹�ȣ);
	}
}
