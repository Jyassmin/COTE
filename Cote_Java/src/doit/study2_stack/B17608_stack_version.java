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
	// 가져온 막대기보다 큰 top이 나올 때까지 pop을 하자(자신보다 큰 막대기가 직전에 있도록, 자기보다 작은거는 버림) (만약 stack이 비어있으면 바로 push)
		// stack.pop
	// stack.push (stack이 비었거나, 가져온 막대기 보다 top이 크다면 push) 
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
		 
		int push_num;
		for (int i = 0; i < n; i++) {			
			push_num = Integer.valueOf(br.readLine()); // 막대기 가져옴 
			
			while(!stack.empty() && push_num >= stack.peek()) { // push_num보다 큰 top이 나올 때까지 pop(자기보다 작은거는 어차피 안보이니 버림)
				stack.pop();					
			}
			stack.push(push_num); // stack이 비었거나, 가져온 막대기 보다 top이 크다면 push 
		}
		
		// 출력
		System.out.println(stack.size());
	}
}
