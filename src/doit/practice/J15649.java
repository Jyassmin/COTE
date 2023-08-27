package doit.practice;

// 4 4

//1 2 3 4
//1 2 4 3
//1 3 2 4
//1 3 4 2
//1 4 2 3
//1 4 3 2
//2 1 3 4
//2 1 4 3
//2 3 1 4
//2 3 4 1
//2 4 1 3
//2 4 3 1
//3 1 2 4
//3 1 4 2
//3 2 1 4
//3 2 4 1
//3 4 1 2
//3 4 2 1
//4 1 2 3
//4 1 3 2
//4 2 1 3
//4 2 3 1
//4 3 1 2
//4 3 2 1


// 반복으로 모든 경우의 수를 만든다.
// 각 경우에서 중복된 숫자가 있는지 확인하는 메소드 호출(set.size활용)
// 중복이 아니면 arraylist에 삽입

// arraylist 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class J15649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];
        for (int i=0; i<m; i++)
            arr[i] = 1;

        ArrayList<int[]> arr_result = new ArrayList<>();
        int end = (int) Math.pow(n, m);
        for (int i=0; i<end; i++) {
            for (int j=m-1; j>=0; j--) {
                if (arr[j] == n+1) {
                    arr[j-1] = arr[j-1]+1;
                    arr[j] = 1;
                }
            }
            arr_result.add(arr.clone()); // 주의! clone하지 않으면 주소값이 다 같이져버려서, 하나만 바꿔도 다 바뀜

            arr[m-1] = arr[m-1]+1;
        }

        for (int[] a : arr_result) {
            if (!func_overlap(a, m)) {
                for (int b : a)
                    System.out.printf("%d ", b);
                System.out.println();
            }
        }
//        for (int[] e : arr_result) {
//            for (int k = 0; k < m; k++)
//                System.out.printf("%d ", e[k]);
//            System.out.println();
//        }
    }

    private static boolean func_overlap(int[] arr, int m) {
        // 중복값이 있는지 확인하는 메소드
        Set<Integer> hs = new HashSet<Integer>();
        for (int e : arr)
            hs.add(e);

        return hs.size() != m;
    }


}

