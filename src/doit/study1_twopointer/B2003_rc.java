package doit.study1_twopointer;

//4 2
//1 1 1 1

//10 5
//1 2 3 4 2 5 3 1 1 2
//정렬 : 1 1 1 2 2 2 3 3 4 5  -> 이 케이스를 보니 마지막 5하나만 있을 때는 count로 인정하지 않음. 수의 합으로만 가능!


//[수들의 합 2]
//배열의 크기(n)가 주어지고, 만들고자하는 숫자(m)가 주어진다.
//배열을 받아 투포인터를 사용하여 m을 만들면 된다. 그 때 count!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2003_rc {
	public static void main(String args[]) throws IOException {
		// 입력 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		
		// 배열 생성 
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		
		System.out.println(twoPointer(arr, m));
	}
	
	static int twoPointer(int[] arr, int m) {
		int count = 0;
		int start = 0, end = 0;
		int len = arr.length;
		int sum = 0;
		
		while(true) {
			if(sum >= m) { // sum >= m 이면 값을 줄여야하므로 현재 start의 값을 더하고, 한 칸 전진.
				sum -= arr[start];
				start++;
			}
			else if(end >= len) { // sum < M 때문에 값을 늘리려고 end를 증가시키다 len만큼 커지게 되면 끝!
				break; // 다만, end가 len일 때(마지막까지 도달했을 때) sum이 M보다 커서 start를 증가시키며 sum을 줄이다가 sum이 m과 같을 수도 있어서, 
				       // 이 break문은 while문의 조건으로 사용하지 말고, (sum > m)보다 뒤에 위치해야한다.  
			}
			else { // sum < M 이면 값을 늘려야 하므로 현재 end를 한 칸 앞으로 이동시키고, sum에 더한다.
				sum += arr[end];
				end++;
			}
			
			if(sum == m) {
				count++;
			}
		}
		
		return count;
	}
}