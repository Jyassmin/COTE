package doit.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
4
2 1 1 0
*/

public class B1138_한줄로서기 {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] front_num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            front_num[i] = Integer.parseInt(st.nextToken());
        }

        // 결과 담을 배열
        LinkedList<Integer> result_list = new LinkedList<Integer>(); // 속도는 거이 같으나 매모리면에서 얘가 더 우수.
        //ArrayList<Integer> result_list = new ArrayList<Integer>();


        // 로직
        for (int i=n-1; i>=0; i--) {
            int count = 0;
            int idx = 0;

            while (front_num[i] != count) {
                if (i+1 < result_list.get(idx))
                    count++;
                    idx++;
            }
            result_list.add(idx, i+1);
        }

        for (int e : result_list) {
            System.out.printf("%d ", e);
        }
    }
}
