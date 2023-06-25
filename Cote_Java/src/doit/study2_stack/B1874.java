package doit.study2_stack;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// [스택 수열]
//8
//4
//3
//6
//8
//7
//5
//2
//1

public class B1874 {
	public static void main(String[] args) throws IOException {
		
		// 입력 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		int[] arr = new int[n]; // 출력 대상
		for (int i=0; i<n; i++)
			arr[i] = Integer.valueOf(br.readLine());
		
		
		// stack & stringbuffer(+,-저장) & 변수(1씩 증가) 생성
		Stack<Integer> stack = new Stack<Integer>();  // push, pop, peek 
		StringBuffer sb = new StringBuffer(); // append, toString
		int push_num = 1; // 1부터 차례대로 증가시켜 push
		boolean flag = true; // NO가 출력된다면 flag를 false로 바꾸고 sb출력하지 말도록. 
		
		
		
		// 출력 대상을 하나씩 출력해야함(push_num이 출력대상보다 같거나 작은 경우와 큰경우로 나누자)
		for (int i = 0; i < n; i++) {
			if (push_num <= arr[i]) {  // 1. push_num이 같거나 작은경우 
				while(push_num <= arr[i]) { // 출력 대상과 같아질 때까지(Push & 1증가 & pop 1회)
					stack.push(push_num);
					push_num++;
					sb.append("+");
				}
				stack.pop(); // 위 while문에서 push_num이 출력대상과 같을 때 탈출하니, pop은 출력 대상!
				sb.append("-");
				
				
			} else { // 2. push_num이 큰 경우 -> pop(push_num은 항상 증가하기 때문에 pop으로만 숫자를 줄일 수 있다.)  
				if (arr[i] == stack.pop()) { // top에 있는게 출력대상과 같다면 -
					sb.append("-");
				} else { // 여기서 같지 않으면 다 틀림(NO)
					System.out.println("NO");
					flag = false; // 결과출력x 
					break;
				}
				
			}				
		}
		
		// 결과 출력(NO가 아닐 때) 
		if (flag) {
			for (char e : sb.toString().toCharArray()) {
				System.out.println(e);
			}
		}
		
		
	}

}






/* 교재방법(else)
} else { // push_num이 큰경우 
	int top = stack.pop();
	if (top > arr[i]) {
		System.out.println("NO");
		flag = false;
		break;
	} else {
		sb.append("-");
	}
*/			