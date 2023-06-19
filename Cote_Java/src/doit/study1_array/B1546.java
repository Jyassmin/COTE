package doit.study1_array;

// 최대값을 100점으로하여 시험점수를 조작하는 문제이다.
// 배열에 저장하는건 공간낭비이다.
// 그렇기에 sum을 통해 점수를 누적하고,
// 제일큰수를 n_max에 저장한다 
// 그렇게 sum에다가 큰수를 나누고 *100을 한 것이 조작점수의 합산이 되고
// n을 한 번 더 나누면 평균이 된다.

import java.util.Scanner;

public class B1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int temp;
		int sum = 0;
		int n_max=0;
		
		for (int i=0; i<n; i++) {
			temp = sc.nextInt();
			sum += temp;
			if (n_max < temp)
				n_max = temp;
		}
		sc.close();
		
		System.out.println(sum * 100.0 / n_max / n); // 75.0
		System.out.println(sum / n_max * 100.0 / n); // 66.66666666666667
		System.out.println( 1.0 * sum / n_max * 100.0 / n); // 66.66666666666667
				

	}

}
