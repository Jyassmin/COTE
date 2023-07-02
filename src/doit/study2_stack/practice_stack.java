package doit.study2_stack;

import java.util.Stack;

// stack & Stringbuffer 다루기  
public class practice_stack {
	public static void main(String[] args) {
		
		// 1.Stack
		Stack<Integer> stack = new Stack<Integer>();	// 객체 만드는 거기 때문에 ()빼먹지 말
		
		for (int i=1; i<11; i++) { // 스택에 1~10 넣고 
			stack.push(i);
		}
		
		while(!stack.empty())
			System.out.printf("%d ", stack.pop()); // 빌 때까지 pop하라.
		
		/* size()로 빌 때까지 출력하려하면 size가 실시간으로 업데이트 되어서 끝까지 pop못함. 
		for (int i=0; i<stack.size(); i++) { // stack이 빌 때까지 삭제 및 확인 
			stack.pop();
			System.out.printf("%d ", stack.size());
			System.out.printf("%d ", i);
			//System.out.printf("%d ", stack.pop());
		}
		System.out.print(stack);
		*/
		
		/* 기타 stack 메소드 
		stack.size(); 사이즈 확인 
		stack.empty();     // stack이 비어있는 check (비어있다면 true)
		stack.contains(1) // stack에 1이 있는지 check (있다면 true)
		*/
		
		
		
		// 2. StringBuffer
		System.out.println("");
		for (int i=1; i<11; i++) { // 스택에 1~10 넣고 
			stack.push(i);
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i<10; i++) {
			sb.append(String.valueOf(stack.pop()) + " ");			
		}
		System.out.println("");
		System.out.print(sb);	// sb와 sb.toString의 출력값은 같다.
		System.out.println("");
		System.out.print(sb.getClass());	// 다만 sb는 여전히 StringBuffer이
		System.out.println("");
		System.out.print(sb.toString().getClass());  // to.String은 String을 반환하여 이후의 String 메소드를 활용할 수 있다.
	}

}
