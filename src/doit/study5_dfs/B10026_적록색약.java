package doit.study5_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10026_적록색약 {
    static String[][] map;
    static String[][] map2;
    static int count = 0;
    static int n;
    static String temp;
    static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new String[n][n];
        map2 = new String[n][n];
        String[] temp_string;
        for (int i=0; i<n; i++) {
            temp_string = br.readLine().split("");
            map[i] = temp_string;
            map2[i] = temp_string.clone();
        }

        // 색약 아닐 때
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!map[i][j].equals("V")) {
                    count++;
                    temp = map[i][j];
                    DFS(i,j, map);
                }
            }
        }
        System.out.print(count);
        System.out.print(" ");

        // 색약일 때
        for (int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                if (map2[i][j].equals("R"))
                    map2[i][j] = "G";
            }
        }

        count=0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!map2[i][j].equals("V")) {
                    count++;
                    temp = map2[i][j];
                    DFS(i,j, map2);
                }
            }
        }
        System.out.print(count);
    }

    static void DFS(int i, int j, String[][] map) {
        map[i][j] = "V";

        for (int idx = 0; idx < 4; ++idx) {
            int nr = i + delta[idx][0];
            int nc = j + delta[idx][1];
            if (nr < 0 || nr > n - 1 || nc < 0 || nc > n - 1 || map[nr][nc].equals("V") || !map[nr][nc].equals(temp)) {
                continue;
            }
            DFS(nr, nc, map);
        }
    }
}

