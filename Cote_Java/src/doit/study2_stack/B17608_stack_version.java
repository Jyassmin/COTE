package doit.study2_stack;

//6
//6
//9
//7
//6
//4
//6
// (3)


//[막대기]
//스택을 활용해서 풀어보자.
// Goal : stack에는 보이는 막대기만 남겨두고, 마지막에 남은 갯수를 출력하자.

// stack을 생성해서 막대기를 하나씩 가져온다.
	// push_num이 top보다 작으면(만약 stack이 비어있으면 바로 push)
		// stack에 추가 
	// push_num이 top보다 같거나 크면 
		// push_num보다 큰 top이 나올 때까지 pop을 하자(자신보다 큰 막대기가 직전에 있도록, 자기보다 작은거는 버림)
		// stack에 추가
// 스택size 출력 

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608_stack_version {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		
		// 입력 
		int n = Integer.valueOf(br.readLine());
		
		// 막대기를 하나씩 push 
		int push_num;
		for (int i = 0; i < n; i++) {			
			push_num = Integer.valueOf(br.readLine());
			
			if (stack.empty() || push_num < stack.peek()) { // push_num이 top보다 작으면 바로 push(비어있어도 바로 push! 여기서 empty메소드 먼저 써줘야 오류 안뜸) 
				stack.push(push_num);

			} else { // push_num이 top보다 같거나 크면 
				while(!stack.empty() && push_num >= stack.peek()) { // push_num보다 큰 top이 나올 때까지 pop(자기보다 작은거는 보이니 버림)
					stack.pop();					
				}
				stack.push(push_num);
			
			} 
		}
		
		// 출력
		System.out.println(stack.size());
	}
}

