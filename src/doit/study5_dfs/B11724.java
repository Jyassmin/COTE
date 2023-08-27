package doit.study5_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//     [MAIN Methods]
//(n, m)
//방문배열 생성 - 클래스변수
//인접배열 생성 - 클래스변수
//인접배열 초기화
//인접배열 입력받기
//for (n)
//    방문안했으면
//        count++
//        DFS

//     [DFS]
//방문 안했으면 return;
//방문체크
//인접 노드 방문 안했으면
//     DFS()


public class B11724 {
    // 클래스 변수(방문배열, 인접배열) - DFS메소드에서도 이를 조작하기 때문에
    static boolean[] visited;
    static ArrayList<Integer>[] A; // 제너레이터 빼먹지말기

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //방문배열
        visited = new boolean[n+1]; // 0번을 무시하고, 1~n인덱스 사용 for 편리
        //인접배열
        A = new ArrayList[n+1];
        //인접배열 리스트 초기화(1~n)
        for (int i=1; i<n+1; i++) { // 인덱스 조심
            A[i] = new ArrayList<Integer>();  // ArrayList의 원소로 ArrayList를 초기화
        }
        // 인접배열 리스트에 데이터 저장(m번)
        int s, e;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            A[s].add(e);  // 양뱡향 엣지이기 때문에 서로 이어져있음을 업데이트
            A[e].add(s);
        }

        // DFS 시작
        int count = 0;
        for (int i=1; i<n+1; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    // DFS 정의
    static void DFS(int v) {
        // 방문 했다면
        if (visited[v]) { // 리턴값이 void이기 때문에 종료조건으로는 return;
            return;
        }
        // 방문 안했다면
        visited[v] = true; // 방문 체크하고
        for (int i : A[v]) { // 인접 리스트 방문
            if (!visited[i])
                DFS(i); // 방문 안했다면 인접 리스트 우선적으로 방문! -> FIFO!
        }
    }
}
