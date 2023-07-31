package doit.study5_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B2606 {
    static ArrayList<Integer>[] map; // <Integer>를 빼면, 아래 DFS에서 for(int e:map[i])의 int e가 안먹힘
    static boolean[] visited;
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());

        map = new ArrayList[n+1];
        visited = new boolean[n+1];
        for (int i=1; i<n+1; i++)
            map[i] = new ArrayList<Integer>();

        int s, e;
        while(edge-- > 0) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            map[s].add(e);
            map[e].add(s);
        }

        DFS(1);
        System.out.println(count);
    }

    static void DFS(int i) {
        if (visited[i])
            return;

        visited[i] = true;
        if (i != 1)
            count++;

        for (int e : map[i]) {
            if (!visited[e])
                DFS(e);
        }
    }
}
