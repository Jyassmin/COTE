package doit.study1_twopointer;

//4 2
//1 1 1 1

//10 5
//1 2 3 4 2 5 3 1 1 2
// 정렬 : 1 1 1 2 2 2 3 3 4 5  -> 이 케이스를 보니 마지막 5하나만 있을 때는 count로 인정하지 않음. 수의 합으로만 가능!

 
//[수들의 합 2]
//배열의 크기(n)가 주어지고, 만들고자하는 숫자(m)가 주어진다.
//배열을 받아 투포인터를 사용하여 m을 만들면 된다. 그 때 count!

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class B2003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력 받기 
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i=0; i<n; i++)
			arr[i] = Integer.valueOf(st.nextToken());
		// Arrays.sort(arr); 이문제는 sorting하면 안됌. 
		
		// 변수 정의
		int index_start = 0;
		int index_end = 0;
		int sum = arr[0];
		int result=0;
		
		// 투포인트(핵심!)
		// sum < m 이면, index_end를 ++, sum += arr[index_end]
		// sum == m 이면, result++, index_end++, sum += arr[index_end]  (result 먼저 계산!)
		// sum > m 이면, sum -= arr[index_end], index_start ++ 		  	(sum을 먼저 계산!)  
		while (true) { 
			if (index_start == index_end) { // 하나의 숫자가 m이랑 같을 수 있는데, 이는 count하지 않기에 sum==m 조건의 if문을 만나기 전에 end를 하나 증가시키자.
				index_end++;
				if (index_end == n) // 종료조건 : sum이 n보다 작으면 end가 증가하는데 그러다 n이 되어버리면 stop(여기서 n은 마지막index + 1임) 
					break;
				sum += arr[index_end];
				
			} else if (sum == m) {
				result++; // 종료 되기 전에 count를 해야해서 조건을 우선적으로 써줘야함.
				index_end++;
				if (index_end == n) // 종료조건 
					break;
				sum += arr[index_end];
				
			} else if (sum > m){
				sum -= arr[index_start++];
				
			} else {
				index_end++;
				if (index_end == n) // 종료조건  
					break;
				sum += arr[index_end];
			}
		}
		
		System.out.print(result);
		
		

	}

}
