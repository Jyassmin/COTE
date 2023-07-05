package doit.study4_sort;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 배열생성
        int[] arr = new int[n];
        for (int i=0; i<n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        // 버블정렬 - 2중 포문 사용해서 j가 n-1-i까지 커지고 j, j+1을 비교하며 인접 원소를 swap
        int temp;
        for (int i = 0; i<n-1; i++) {
            for (int j=0; j<n-1-i; j++) { // j와 j+1를 비교
                if (arr[j] > arr[j+1]) { // 오름차순
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int e : arr)
            System.out.println(e);

    }
}
