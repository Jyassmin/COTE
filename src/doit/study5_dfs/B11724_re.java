package doit.study5_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11724_re {
    // 인접리스트배열, 방문배열 : DFS 메소드와 메인메소드에서 같이 사용되기에 클래스 변수로 선언
    static ArrayList<Integer>[] A; // arraylist를 인자로가지는 배열
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        A = new ArrayList[n+1]; // ArrayList만들 때는 대괄호만 있으면 됌
        for (int i=1; i<n+1; i++) {
            A[i] = new ArrayList<Integer>(); // 소괄호 빼먹지 말기
        }

        int s, e;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        int result = 0;
        for (int i=1; i<n+1; i++) {
            if (!visited[i]) {
                result++;
                func_DFS(i);
            }
        }
        System.out.println(result);


    }

    private static void func_DFS(int i) {
        if (visited[i])
            return; // 방문했으면 해당 재귀는 종료

        visited[i] = true;
        for (int e : A[i]) {
            func_DFS(e);
        }
    }
}
