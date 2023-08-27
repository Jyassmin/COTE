package doit.study7_binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N, M을 2중 for문으로 해서 풀어도 풀리지만 Binary Search를 사용하면 더욱 빠르다!

// Binary Search를 수행하며 mid보다 target이 더 클 때 오른쪽 배열을 탐색(start = mid + 1)하게된다.
// 그렇다면 여기서 mid를 포함한 왼쪽 배열은 확정적으로 모두 target보다 작은 애들이다! (작은 애들의 수 = mid +1개. 인덱스+1을 해야 갯수가 된다.)
// 그래서 mid < target일 때 "mid+1"(cnt_index)를 업데이트 하다가, 마지막 mid+1이 최종적으로 target보다 작은 수들의 갯수가 된다.
// 따라서 각 target마다의 cnt_index를 누적시켜 답을 구한다.

public class B7759 {
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int T, N, M;
    private static int[] A, B;

    public static void main(String[] args) throws NumberFormatException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        // 입력케이스 T번 만큼 반복
        for (int t = 1; t <= T; t++) {
            // 배열 A,B 입력 및 초기화
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new int[N];
            B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(A);

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) B[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(B);

            // target의 수 N번만큼 for문을 돌면서 B배열 중 target보다 작은 애들 중 가장 큰 인덱스를 찾는다.(그 인덱스 + 1이 작은애들 수임)
            int result = 0;
            for (int i = 0; i < N; i++) {
                int cnt_index = 0;
                int start = 0;
                int end = M - 1;

                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (B[mid] < A[i]) {
                        start = mid + 1; // 오른쪽 배열 탐샥
                        cnt_index = mid + 1; // A깂이 B보다 클 때!   현재 비교 인덱스(mid) + 1(index 0)이 target보다 작은 B의 개수이므로 이 값을 저장.
                    } else {
                        end = mid - 1; // 왼쪽 배열 탐색
                    }
                }
                result += cnt_index; // target의 수만큼 for문을 돌면서 cnt값을 누적시켜 target들 보다 작은 애들의 수를 구한다.
            }
            System.out.println(result);
        }
    }

}