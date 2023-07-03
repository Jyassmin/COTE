package doit.study3_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//15
//push 1
//push 2
//front
//back
//size
//empty
//pop
//pop
//pop
//size
//empty
//pop
//push 3
//empty
//front
    //1
    //2
    //2
    //0
    //1
    //2
    //-1
    //0
    //1
    //-1
    //0
    //3

// [큐]
// push, pop, size, empty, front, back 를 받아 push를 제외한 나머지 5개에서 출력을 한다.

public class B10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        String order;
        Integer temp;
        Queue<Integer> que = new LinkedList<>();
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            order = st.nextToken();

            switch (order) {
                case "push" :
                    que.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    temp = que.poll();
                    if (temp == null)
                        System.out.println(-1);
                    else
                        System.out.println(temp);
                    break;
                case "size" :
                    System.out.println(que.size());
                    break;
                case "empty" :
                    System.out.println(que.isEmpty() ? 1 : 0);
                    break;
                case "front" :
                    if (que.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(que.peek());
                    break;
                case "back" :
                    if (que.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(que.toArray()[que.toArray().length-1]);
                    break;
            }

        }
    }
}
