package doit.practice;

/*4
120 110 140 150
485*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B2512 {
    public static void main(String[] args) throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[n];
        int temp;
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
            sum += temp;
        }

        int m = Integer.parseInt(br.readLine());

        // 역순정렬
        Arrays.sort(arr, Collections.reverseOrder());

        // 각 예산별 차이(gap)
        int[] gap = new int[n-1];
        for (int i=0; i<n-1; i++) {
            gap[i] = arr[i] - arr[i+1];
        }

        // 총 예산과 총 예산요청액의 차이(이만큼 줄여야 한다)
        int reduce = sum - m;

        // 예산이 충분히 많으면 출력
        if (m > sum) {
            System.out.println(arr[0]);
        } else {
            // 예산이 적은 경우
            // i번째 예산과 i+1번째 예산의 차이보다 reduce가 더 크면 -> 최소 i+2번째까지 상한선으로 제한받아야한다.
            // 그래서 제한을 받지 않는 i+2를 찾는다.(idx)
            // 그 방법으로 i+2이전의 숫자를 모두 i+1로 줄이면서, 다 줄이고도 reduce가 더 있으면 i+2까지 영향을 받는거고, reduce가 없으면 i+1까지만 줄이면 되는거다.
            int idx = 0;
            while ((idx < n-1) && (reduce / (idx+1) > gap[idx])) {
                reduce -= (idx+1) * gap[idx];
                idx++;
            }

            // reduce가 gap[i]보다 작을 때 -> i+2번째 원소까지는 제한받을 필요가 없다.
            int result = (int) (arr[idx] - Math.ceil((double) reduce / (idx + 1))); // i+1까지의 원소들에게 줄여야하는 값인 reduce를 공통적으로 빼준다.
            System.out.println(result);
        }
    }
}
