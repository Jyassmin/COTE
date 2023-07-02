package doit.study1_array;

// 구간 합 구하기4
//5 3
//5 4 3 2 1
//1 3
//2 4
//5 5
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11659_bufferreader {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 첫 줄 
        
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int num[] = new int[n]; 
        int sum[] = new int[n + 1];

        st = new StringTokenizer(br.readLine()); // 두번째 
        for (int i = 0; i < n; i++) {
            num[i] = Integer.valueOf(st.nextToken());
        }

        sum[1] = num[0];        // 첫번째 합은 num[0]로 설정
        for (int i = 2; i < n + 1; i++) {
            sum[i] = sum[i - 1] + num[i - 1];
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.valueOf(st.nextToken());
            int e = Integer.valueOf(st.nextToken());
            System.out.println(sum[e] - sum[s - 1]);
        }

    }

}