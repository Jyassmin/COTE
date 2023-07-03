package doit.study3_queue;

//6 3
//1 1 0 0 0 1
// (3)

// [Condition of deep sleep]
// 1인것을 0으로 바꾸고, 0인것은 그냥 pass하면서 전체가 0이 되면 끝!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11577 {
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 입력받기
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int index = 0;
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        while ((sum != 0) && (index <= n-k)) {
            if (arr[index] == 1) {
                result++;
                for (int i=0; i<k; i++) // 만약 k가 n이라면 시간복잡도는 o^2가 되어 fail!
                    switch_01(arr, index+i);
            }
            index++;
        }

        // 출력
        if (sum == 0)
            System.out.println(result);
        else
            System.out.println("Insomnia");
    }

    static void switch_01(int[] arr, int index) {
        if (arr[index] == 0) {
            arr[index] = 1;
            sum++;
        } else {
            arr[index] = 0;
            sum--;
        }
    }

}
