package doit.study4_sort;

import java.util.Arrays;
import java.util.Scanner;

public class B18310 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //집 개수
        int[] homes = new int[n]; //집 위치 배열

        for(int i=0;i<n;i++)
            homes[i]=sc.nextInt();

        //집 위치 오름차순 정렬
        Arrays.sort(homes);

        // 안테나로부터 모든 집까지의 거리의 총 합이 최소가 되려면
        // 안테나가 최대한 가운데 위치해야 함
        // 홀수 : 가운데
        // ex) n=5 (5-1)/2=2 답:2번째
        // 짝수 : 가운데로부터 왼쪽 위치(문제에서 여러 개 값이 도출될 경우 가장 작은 값을 출력하라고 요구)
        // ex) n=4 (4-1)/2=1 답:1번째

        System.out.println(homes[(n-1)/2]);
    }
}