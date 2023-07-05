package doit.study3_queue;

//3
//10
//20
//40
//// 100

// [카드 정렬하기]
// 이문제는 시간제한이 2초이므로, o^2미만의복잡도로 해결해야한다. -> nlogn인 우선순위큐를 사용해보자.
// 작은것을 우선적을 더해나가는 것이기 때문에, 입력을 받을 때마다 최소우선순위에 더한다.
// sum을 que[0] + que[1]으로 초기화하고
// que[2]부터는 sum = sum*2 + que.poll로 더한다.
// n이 1 or 2 일 수도 있으니 이를 위한 예외처리만 하면 될 듯.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 최소우선순위큐 생성
        long temp;
        PriorityQueue<Long> pque = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pque.add(Long.parseLong(br.readLine()));
        }

        // 이렇게 짧게 가능
//        while (n-- > 0) {
//            pq.offer(Long.parseLong(br.readLine()));
//        }

        // start
        long sum = 0;
        long num1, num2;
        while(pque.size() > 1) { // 최소 2개인걸 뽑아서, sum에 누적시킨 뒤, 합한 덱을 다시 최소큐에 넣어 반복.
            num1 = pque.poll();
            num2 = pque.poll();
            sum += num1 + num2;

            pque.add(num1+num2);
        }

        System.out.println(sum);


//        // sum 초기 세팅(처음 2개)
//        long sum = 0;
//        for (int i =0; i<2; i++)
//            if (!pque.isEmpty())
//                sum += pque.poll();
//
//        // pque 빌 때까지, sum*2 + poll
//        while (!pque.isEmpty()) {
//            sum = sum*2 + pque.poll();
//        }
    }
}
