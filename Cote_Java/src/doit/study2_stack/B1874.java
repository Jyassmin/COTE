package doit.study2_stack;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// [스택 수열]

public class B1874 {
	public static void main(String[] args) throws IOException {
		
		// 입력 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		int[] arr = new int[n];
		for (int i=0; i<n; i++)
			arr[i] = Integer.valueOf(br.readLine());
		
		
		// 변수 & stack & stringbuffer 생성
		Stack<Integer> stack = new Stack<Integer>();  // push, pop, peek 
		StringBuffer sb = new StringBuffer(); // append, toString
		int push_num = 1; // 1부터 차례대로 증가시켜 push
		
		for (int i = 0; i < n; i++) { // stack을 이용해 arr의 원소를 출력해야함!
			if (stack.peek() < arr[i]) { // 출력대상이 크면 같아질 때 까지 Push하고 pop한번 
				
			} else { // top이 출력대상보다 같거나 크면 -> pop. -> 만약 
				
			}
			
			
			
		}
		
		
		
	}

}
