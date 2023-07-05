package codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2 {
    static int count_x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int try_num = Integer.parseInt(br.readLine());
        int try_now = 1;

        for (int t = 0; t<try_num; t++) {
            int n = Integer.parseInt(br.readLine());
            // 2차원배열생성
            char[][] matrix = new char[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = st.nextToken().charAt(0);
                    //System.out.println(matrix[i]);
                }
            }

            // 서치
            int sum = 0;
            count_x = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 'H') {
                        sum++;
                        recursive_search(matrix, i, j, n); // 전염
                    }
                }
            }

            System.out.printf("#%d %d\n", try_now++, sum-count_x);
        }
    }

    static void recursive_search(char[][] matrix, int y, int x, int n) {
        int nothing = 0;
        if (x<0 | x>=n | y<0 | y>=n) {
            nothing++;

        } else if (matrix[y][x] == 'H' | matrix[y][x] == 'X') {
            if (matrix[y][x] == 'X')
                count_x++;
            matrix[y][x] = 'L';
            recursive_search(matrix, y-1, x, n);
            recursive_search(matrix, y+1, x, n);
            recursive_search(matrix, y, x+1, n);
            recursive_search(matrix, y, x-1, n);
        }
    }

}
