package doit.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int turn = (int) Math.floor(n/3); // 턴 돌아가는 횟수 - 3으로 나눈 몫
        n = n%3 + turn; // 턴 돌다가 남은 마지막 돌 갯수(0 or 1 or 2) - 3으로 나눈 나머지


        if (n%2 == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
