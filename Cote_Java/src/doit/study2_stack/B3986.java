package doit.study2_stack;

//3
//ABAB
//AABB
//ABBA
// (2)

//3
//AAA
//AA
//AB
// (1)

// [좋은단어]
// 위 예제를 보면 push_num이 top과 같으면 pop하고, 다르면 push하고, 남은게 0개이면 좋은단어, 1개라도 남으면 x. 

// n
// for(n)
	// char_array생성해서 단어 입력받음 
	// for (char_array)
		// if (!empty && push_num == peek)
			// pop
		// else
			// push

	// if (stack.size <= 2)
		// result++

// result출력 

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class B3986 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = 0;
		
		// 입력 
		int n = Integer.valueOf(br.readLine());
		
		for (int i = 0; i < n; i++) {
			Stack<Character> stack = new Stack<Character>();
			char[] arr = String.valueOf(br.readLine()).toCharArray();
			
			for (char e : arr) {
				if (!stack.empty() && e == stack.peek()) {
					stack.pop();					
				} else {
					stack.push(e);
				}
			}
			
			if (stack.size() == 0)
				result++;
		}
		
		// 출력 
		System.out.println(result);
			
	}

}
