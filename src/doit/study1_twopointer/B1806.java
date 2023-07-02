package doit.study1_twopointer;

//10 15
//5 1 3 5 10 7 4 9 2 8
//(2)

// [부분합]
// 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1806 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
		
		System.out.println(func_min(arr, s));

	}

	private static int func_min(int[] arr, int s) {
		int len = arr.length;
		int start=0, end=0;
		int sum=0;
		int min=len+1; //Integer.MAX_VALUE; // len으로 하면 안된다!!!
		// 왜냐?! 배열 전체의 합만이 s 이상이 되면, min = len이 된다.
		// 그러나 맨 마지막 출력에서, sum이 s를 넘는 경우의 수가 0일 때, return을 0으로 출력해주기 위한
		// if (min == len) 구문이 있다. 그래서 x

		
		// sum >= s 이면 start값 빼고, start증가 & min업데이트 
		// end >= len 이면 종료 
		// sum < s 이면 end값 더하고, end증가 
		while(true) {
			if (sum >= s) {
				min = Math.min(end-start, min);
				sum -= arr[start];
				start++;
				
			} else if (end >= len) {
				break;
				
			} else {
				sum += arr[end++];
			}
		}
		
		
		if (min == len+1) {
			return 0; // 합을 만드는 것이 불가능하다면 0을 출력(문제 잘 읽기!)
		} else {
			return min;		
		}

	}

}
