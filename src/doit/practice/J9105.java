package doit.practice;

// n을 입력받고 아래와 같이 출력

//1 1 1
//1 1 2
//1 1 3
//1 1 4
//1 1 5
//1 1 6
//1 2 1
//...
//6 6 6

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J9105 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i=0; i<n; i++)
            arr[i] = 1;

        int end = (int) Math.pow(6, n);
        for (int i=0; i<end; i++) {
            for (int j=n-1; j>=0; j--) {
                if (arr[j] == 7) {
                    arr[j-1] = arr[j-1]+1;
                    arr[j] = 1;
                }
            }
            for (int k=0; k<n; k++)
                System.out.printf("%d ", arr[k]);
            System.out.println();
            arr[n-1] = arr[n-1]+1;

        }
    }


}
