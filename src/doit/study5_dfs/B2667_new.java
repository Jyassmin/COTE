package doit.study5_dfs;

import com.sun.tools.javac.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class B2667_new {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    static int n;
    static int[][] board;
    static ArrayList<Integer> list = new ArrayList<>();
    static int cnt;

    public void DFS(int x, int y) {
        cnt++;

        board[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (0 <= xx && xx < n && 0 <= yy && yy < n && board[xx][yy] == 1) {
                DFS(xx, yy);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        B2667_new T = new B2667_new();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    cnt = 0;
                    res++;
                    T.DFS(i, j);
                    list.add(cnt);
                }
            }
        }

        Collections.sort(list);
        bw.write(res + "\n");
        for (int x : list) {
            bw.write(x + "\n");
        }

        bw.flush();
        bw.close();
    }
}