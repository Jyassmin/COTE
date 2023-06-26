package doit.study2_stack;

//4
//3 5 2 7
// (5 7 7 -1)

//4
//9 5 4 8
// (-1 8 8 -1)

//[오큰수]
// 자신보다 오른쪽에 있는 수 중 가장 왼쪽에 있는 수를 구하라.

// 2중 for문으로 구하면 쉽지만, O(n2)의 시간복잡도로 시간초과가 될 것이다.
// 따라서 배열을 거꾸로 가져오면서, stack에 차례대로 넣고, top과 비교하면서 결과배열을 만들자. 

// n
// for (n)  : 배열생성 
	// arr
	// max

// result_arr;
// for (n-1 .. 0) : 거꾸로 하나씩 가져온다  
	// 스택이 비어있거나 max이면 
		// push(push_num)
		// result_arr에 -1 삽입 
	
	// push_num이 peek보다 같거나 작으면 
		// push(push_num)
		// result_arr에 peek 삽입

	// push_num이 peek보다 크면 
		// while(push_num > peek) // empty조심 
			// pop()
		// push(push_num) 

// result_num 출력 

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class B17298 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		
		int n = Integer.valueOf(br.readLine());
		int[] arr = new int[n];
		int[] result_arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
			if (max < arr[i])
				max = arr[i];
		}
		
		for (int i = n-1; i >=0; i--) {
			while (!stack.empty() && arr[i] >= stack.peek()) // 자기보다 더 큰 top이 나올때까지.
				stack.pop();
			
			if (stack.empty() || arr[i]==max) {
				result_arr[i] = -1;
				stack.push(arr[i]);
				
			} else {
				result_arr[i] = stack.peek(); // peek다음 push해야함! 
				stack.push(arr[i]);
			}
		}
		
		
		//배열값을 sb로 옮김
	    StringBuffer sb = new StringBuffer();
	    for(int i = 0; i < n; i++) {
	       sb.append(result_arr[i]).append(" ");
	    }
	    System.out.println(sb);
	    
	    /* 이거는 print가 4번 사용되기 때문에 시간이 초과된다. 
		for (int i=0; i<n; i++)
			System.out.printf("%d ", result_arr[i]);
		*/
	}
}
