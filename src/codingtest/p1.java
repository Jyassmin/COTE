package codingtest;

//3
//8
//L L H L L L L L
//L L H L L L L L
//L L Y L L L L L
//H H X L L L H H
//L L L L L L L L
//L L Y L L L L L
//L L Y L L L L L
//L L L L L L L L

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//// #1 2
public class p1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int try_num = Integer.parseInt(br.readLine());
        int try_now = 1;

        for (int t = 0; t<try_num; t++) {
            int n = Integer.parseInt(br.readLine());
            // 2차원배열생성
            int x = 0, y = 0;
            char[][] matrix = new char[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = st.nextToken().charAt(0);
                    if (matrix[i][j] == 'X') {  // X의 위치를 찾는다. X는 하나밖에 없겠지..?
                        y = i;
                        x = j;
                    }
                    //System.out.println(matrix[i]);
                }
            }

            int sum = 0;
            sum = recursive_search(matrix, y, x, n) - 1; // X 자기자신은 빼기
            System.out.printf("#%d %d\n", try_now++, sum);
        }
    }

    static int recursive_search(char[][] matrix, int y, int x, int n) {
        if (x<0 | x>=n | y<0 | y>=n) {
            return 0;
        }

        if (matrix[y][x] == 'H' | matrix[y][x] == 'X') {
            matrix[y][x] = 'L';
            return 1 + recursive_search(matrix, y-1, x, n) + recursive_search(matrix, y+1, x, n) + recursive_search(matrix, y, x+1, n) + recursive_search(matrix, y, x-1, n);

        } else {
            return 0;
        }
    }
}
