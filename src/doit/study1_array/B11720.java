package doit.study1_array;

// [숫자의 합 구하기] 
// n이 최대 100이므로, 100자리의 숫자를 int, long에 담을 수 없음.
// 그렇기 때문에 숫자를 string으로 받고 배열에 담아 계산

// string을 배열에 char형으로 담는 방법 : toCharArray;
// char형태의 '1'을 숫자 1로 바꾸는 방법 : -48 or '0'(아스키코드 이용)

import java.util.Scanner;

public class B11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력받기 n, s1
		int n = sc.nextInt();
		String s1 = sc.next();
		sc.close();
		
		// arr_c로 변환 
		char[] arr_c = s1.toCharArray();
		
		// sum생성
		int sum = 0;
		
		// for문으로 누적합산(아스키코드로) 
		for (int i=0; i<arr_c.length; i++) {
			sum += arr_c[i] - '0';
		}
		System.out.println(sum);

	}

} 
