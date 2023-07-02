package doit.study1_twopointer;

//10 2
//3 -2 -4 -9 0 3 7 13 8 -3
//(21)

//10 5
//3 -2 -4 -9 0 3 7 13 8 -3
//(31)

// [수열]
// 1. 투포인터 방법
// 2. 중첩 for문 방법 

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2559 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int len = Integer.valueOf(st.nextToken());
		
		
		// 배열 입력 
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++)
			arr[i] = Integer.valueOf(st.nextToken());
		
		
		// 첫 sum 계산 
		int sum = 0;
		for (int i = 0; i < len; i++)
			sum += arr[i];
		
		// max 찾기 
		int max_num = sum;
		for (int i = len; i<n; i++) { // j는 endpoint
			sum = sum + arr[i] - arr[i-len];
			if (max_num < sum)
				max_num = sum;
		}
		
		System.out.print(max_num);
		
		
		/*
		// 중첩 for문으로 구현.        이거는 왜 안되지??? 예제 입력은 맞음.
		
		// two pointer
		int max_num=0;
		int sum;
		for (int i=0; i < n-len+1; i++) {
			sum=0;
			for (int j=i; j<i+len; j++)
				sum += arr[j];
			
			if (max_num < sum)
				max_num = sum;
		}
		System.out.print(max_num);
		*/

	}

}
