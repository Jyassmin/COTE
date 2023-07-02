package doit.study3_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//4 2 10
//7 4 5 6
//= 8

// [트럭]
// bridge라는 queue를 만들고, 이 위에 트럭이 올라오면 sum_wei에 합산. 트럭이 나가면 sum_wei에 감산.
// 그렇게 bridge에 아무것도 없으면 끝.

// 그렇다면 각 트럭마다 W만큼의 시간을 bridge에 머물러야하는데, 이를 어떻게 구현할 것인가?
// 각 트럭마다의 time 변수를 만들어서 w가 되면 탈출하도록 해야하는데, 몇개의 트럭이 동시에 올라갈지 모르기에, 몇개의 몇수를 만들어야하는지도 모른다.(잘못된 접근)
// 그래서! stack에 w만큼의 0을 offer하여 초기 세팅한다.
// 이렇게하면, 0을 다 빼는 데에 w의 시간이 걸리기 때문이다.

// [sudo]
// n, w, l 입력
// stack_wei 생성
// stack_bridge 생성 & w만큼의 0을 offer

// sum_wei = 0
// while(!stack_bridge.empty())
	// time++
	// sum_weight -= stack.bridge.poll

	// if (!stack_wei.empty())
		// if (stack_wei.peek() + sum_wei < l)
			// sum_wei += stack_wei.peek
			// stack_bridge.offer(stack_wei.peek)
		// else
			// stack_bridge.offer(0); # 시간끌기
public class B1333 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		Queue<Integer> stack_wei = new LinkedList<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i= 0; i< n; i++) {
			stack_wei.offer(Integer.parseInt(st.nextToken()));
		}
		Queue<Integer> stack_bridge = new LinkedList<Integer>();
		for(int i =0; i<w ; i++) {
			stack_bridge.add(0);
		}
		
		int sum_wei = 0; // bridge위의 누적무게
		int time = 0;
		while(!stack_bridge.isEmpty()) {
			time++;
			sum_wei -= stack_bridge.poll();
			
			if (!stack_wei.isEmpty()) {
				if (stack_wei.peek() + sum_wei <= l) {
					sum_wei += stack_wei.peek();
					stack_bridge.offer(stack_wei.peek());
					
				} else {	
				 stack_bridge.offer(0);
				}
			}
		}
		
		// 출력
		System.out.println(time);
		
		
	}

}
