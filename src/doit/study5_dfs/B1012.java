package doit.study5_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// !주의 : 벌레는 초기위치의 상하좌우만 갈 수 있는 것이 아니라, 연속적으로 이동 가능(이어져있는 배추 전체)

//     [Main Method]
//(t) & 아래 코드 전체를 t만큼 반복
//(m, n ,k)
//map 생성 및 초기화 - class 변수
//for (m) : 배추밭 전체 탐색
//        for (n)
//            map[i][j]=1이면
//                count++
//                DFS(i,j)

//     [DFS Method]
//i,j가 0보다 작고 m,n보다 크거나 같으면 return;
//방문체크
//상 : 안가봤으면 방문체크 & DFS(i, j+1)
//하 ;;
//좌 ;;
//우 ;;


public class B1012 {
    static int[][] map; // class 변수 / main메소드와 DFS메소드에서 같이 사용되기 때문에.
    static int m, n;

    public static void main(String[] args) throws IOException {
        // test case 만큼 반복
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // m,n,k 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // 배추밭(map) 초기화
            map = new int[m][n];
            int x, y;
            for (int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            // 0,0부터 m-1, n-1까지 탐색하며 map[i][j]=1을 대상으로 DFS(count++)
            int count = 0;
            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    if (map[i][j] == 1) { // 배추가 있으면(=방문 안했음)
                        count++;
                        DFS(i,j);
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void DFS(int i, int j) {
        if (i<0 || i>m-1 || j<0 || j>n-1)  // i,j 범위 초과하면 return;
            return;

        map[i][j] = 0;

        // 상하좌우
        if (j+1!=n && map[i][j+1] == 1) //상 (i, j+1) 안가봤으면 방문체크 & DFS(i, j+1)
            DFS(i, j + 1);

        if (j!=0 && map[i][j-1] == 1) // 하
            DFS(i, j-1);

        if (i!=0 && map[i-1][j] == 1) // 좌
            DFS(i-1, j);

        if (i+1!=m && map[i+1][j] == 1) // 우
            DFS(i+1, j);
    }
}
