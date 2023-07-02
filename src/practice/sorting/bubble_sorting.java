package practice.sorting;

import java.util.Scanner;

// 버블정렬(내림차순) : j와 j+1을 비교하면서 증가.
// 15 93 26 8 43 10 25 88 75 19

public class bubble_sorting {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		for (int i = 0; i<10; i++)
			arr[i] = sc.nextInt();
		
		func_bubble(arr);

	}
	
	public static void func_bubble(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) { // 길이-1 하는 이유 : 2개씩 비교하기 때문에 왼쪽 덱스는 마지막에 n-1 까지옴. 
			for (int j = 0; j < arr.length -1 - i; j++) {
				if (arr[j] < arr[j+1]) {
					func_swap(arr, j, j+1);
				}
			}
			for ( int k : arr) {
				System.out.printf("%d ", k);
			}
			System.out.println("");
		}
		
		
	}
	
	public static void func_swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
