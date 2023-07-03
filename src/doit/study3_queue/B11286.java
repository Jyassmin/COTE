package doit.study3_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B11286 {
    public  static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int temp;

        PriorityQueue<Integer> pque =  new PriorityQueue<>((o1, o2) -> { // 우선순위큐는 기본적으로 최소우선순위이기에 이를 재정의한다.
            int first_abs = Math.abs(o1); // 첫번째 수
            int second_abs = Math.abs(o2); // 두번째 수 (얘가 작으면 첫번째랑 바꿔야함) -> return 1
            if (first_abs == second_abs) {
                return (o1 > o2) ? 1 : -1;
            }
            return first_abs - second_abs; // first가 더 크면 양수를 리턴하여 switch한다.(0이면 같은수, 음수면 그대로 배치한다는 뜻)
        });

        for (int i = 0; i<n; i++) {
            temp = Integer.parseInt(br.readLine());
            if (temp == 0) {
                if (pque.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(pque.poll());

            } else {
                pque.add(temp);
            }
        }
    }
}
