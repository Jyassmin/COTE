package doit.study3_queue;

//5  # n
//0
//2 3 2
//0
//0
//0

//-1
//3
//2
//-1

// [크리스마스 선물]
// 최대우선순위 큐를 사용
// 0일때
    // que가 안비어있다면
        // poll 출력
    // 비어있다면
        // -1 출력
// 0이 아니면 a만큼 충전한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B14235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Integer> pque = new PriorityQueue<Integer>((o1, o2) -> {return o2 - o1;}); // 최대우선순위큐

        int a;
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            if (a == 0) {
                if (!pque.isEmpty())
                    System.out.println(pque.poll());
                else
                    System.out.println(-1);

            } else {
                for (int j = 0; j < a; j++)
                    pque.add(Integer.parseInt(st.nextToken()));
            }
        }
    }



}
