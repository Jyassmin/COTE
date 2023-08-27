package doit.study5_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class B2667 {
    static int[][] map;
    static int count;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        // 문자열, 문자하나씩 int로 가져오기.
//         case1 : string으로 한 줄 읽고, charAt()으로 원소하나씩 가져와 형변환
        String temp;
        for (int i=0; i<n; i++) {
            temp = br.readLine();
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j))); // String.valueOf : char -> String -> Integer
        }

        // case2 (best)
        // map[i][j] = str.charAt(j) - '0';로 아스키코드 사용

        // case3 : br을 split("")하여 String[]로 저장해주고, 원소 형변환
//        String[] temp;
//        for (int i=0; i<n; i++) {
//            temp = br.readLine().split("");
//            for (int j=0; j<n; j++)
//                map[i][j] = Integer.parseInt(temp[j]);
//        }


        int n_building = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (map[i][j] == 1) {
                    n_building++;
                    count=0;
                    DFS(i,j);
                    arr.add(count);
                }
            }
        }
        //정렬 출력
        Collections.sort(arr); //Collections.sort(arr, Collections.reverseOrder());
        System.out.println(n_building);
        for (int e : arr)
            System.out.println(e);
    }

    static void DFS(int i, int j) {
        if (i<0 || j<0 || i>n-1 || j>n-1) {
            return;
        }
        count++;
        map[i][j] = 0; // 방문체크 필수!

        if (j+1!=n && map[i][j+1] == 1)
            DFS(i, j+1);

        if (j!=0 && map[i][j-1] == 1)
            DFS(i, j-1);

        if (i+1!=n && map[i+1][j] == 1)
            DFS(i+1, j);

        if (i!=0 && map[i-1][j] == 1)
            DFS(i-1, j);
    }
}
