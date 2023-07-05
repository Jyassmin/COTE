package doit.study4_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        // 배열생성
        int[] arr = new int[num.length()];
        for (int i = 0; i<num.length(); i++) {
            arr[i] = Integer.parseInt(num.substring(i,i+1)); // substring!! 문자열을 잘라 가져오기. i,i+1을 적으면 i원소만 가져온다.
        }

        // 버블정렬
        int n = arr.length;
        int temp;
        for (int i = 0; i<n-1; i++) {
            for (int j=0; j<n-1-i; j++) {
                if (arr[j] < arr[j+1]) { // 내림차순
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for (int e : arr)
            System.out.print(e);

    }
}
