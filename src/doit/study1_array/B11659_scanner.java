package doit.study1_array;

//5 3
//5 4 3 2 1
//1 3
//2 4
//5 5

// 구간합 구하기 4
import java.util.Scanner;

public class B11659_scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int add_counts = sc.nextInt();
		int[] arr = new int[n];
		int[] arr_s = new int[n];
		int a, b;
		
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		arr_s[0] = arr[0];
		for (int i=1; i<n; i++) {
			arr_s[i] = arr_s[i-1] + arr[i];
		}
		
		for (int i=0; i<add_counts; i++) {
			a = sc.nextInt() - 1; // 번째 -> index로 
			b = sc.nextInt() - 1; 
			if (a == 1) {
				System.out.println(arr_s[b]);
			} else {
				System.out.println(arr_s[b] - arr_s[a-1]);
			}
			
		}
		sc.close();
		
		

	}

}
