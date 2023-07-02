package doit.study3_queue;



// 6 # 입력
// 4 # 출력

// [카드2]
// Goal : queue에 2개씩 작업(poll, poll&add)을 해주면서, queue에 1개가 남을 때까지 반복한다.

// n
// queue 생성
// while(que.size() > 1) # que에 최소 2개가 있을 때 아래 poll이 2번실행되니 empty걱정은 x
	// que.poll()
	// que.add(que.poll())
// 마지막 남은거 출력 

import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import java.util.LinkedList;
import java.util.Queue;


public class B2164 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// que 생성 
		Queue<Integer> que = new LinkedList<Integer>();
		for (int i=1; i <= n; i++)
			que.add(i);
		
		// start 
		while (que.size() > 1) {
			que.poll();
			que.add(que.poll());
		}
		
		// print
//		System.out.println(que.peek());
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(que.peek() + "\n"); //버퍼에 있는 값 전부 출력
		bw.flush(); //남아있는 데이터를 모두 출력시킴
		bw.close(); //스트림을 닫음
	}

}
