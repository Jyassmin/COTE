package doit.study2_stack;

//6
//6
//9
//7
//6
//4
//6
// (3)

// [막대기]
// 스택문제이지만, 숫자를 거꾸로 하나씩 받으면서 현재max값보다 크면 result++하는 코드로 풀 수 있을 것 같다. 
// stack사용하는 것보다 이게 메모리도 작고, 더 빠름.

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B17608 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = 1; // 현재 max보다 큰게 있다면 +1!(최소 하나는 보이기에 1로 시작)
		
		// n입력 
		int n = Integer.valueOf(br.readLine());
		
		//배열 생성 
		int[] arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = Integer.valueOf(br.readLine());
		}
		
		
		// 뒤에서 바라보는 것이기 때문에, 거꾸로 읽는다.
		int max = arr[n-1]; // max의 초기값은 거꾸로 읽을 때의 처음 값인 arr[n-1]
		
		for (int i=n-1; i>=0; i--) {
			if (max < arr[i]) { // max값보다 더 큰게 있다면 count하고, max를 업데이트
				result = result + 1;
				max = arr[i];
			}
		}
		
		//출력
		System.out.println(result);

	}

}

