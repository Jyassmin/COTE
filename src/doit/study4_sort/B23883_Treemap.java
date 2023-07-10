package doit.study4_sort;

// 백준 #23883 알고리즘 수업 - 선택 정렬3

import java.io.*;
import java.util.*;

public class B23883_Treemap {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열의 크기 입력 받기
        int n = Integer.parseInt(st.nextToken());
        // 교환 횟수 입력 받기
        int k = Integer.parseInt(st.nextToken());

        // 입력 받은 원소 배열과 treemap에 저장
        st = new StringTokenizer(br.readLine());
        int arr [] = new int [n];

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>(); // 이진트리 기반, TreeSet은 그냥 값만 저장한다면 TreeMap은 키와 값이 저장된 Map, Etnry를 저장
        // 키는 저장과 동시에 자동 오름차순으로 정렬

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i],i);
        }
        /*
         * 1) 배열의 마지막 요소부터 시작하여 역순으로 반복문을 실행
         * 2) treemap에서 가장 큰 키 값을 가져오고 해당 값의 인덱스를 m에 저장
         * 3) 현재 인덱스(i)가 가져온 인덱스(m)와 다르면 -> cnt를 1증가 , 배열 해당 인덱스의 값 swap, treemap의 value 변경
         * 4) cnt == k 일때 바뀐 값 출력
         * 2) cnt < K 일떄 -1 출력
         */

        int cnt = 0;

        for(int i=n-1; i>=0; i--) {
            int m = map.pollLastEntry().getValue(); //pollLastEntry() 메서드는 TreeMap에서 가장 큰 키를 가진 항목을 반환하고 동시에 제거

            if(i != m) {
                cnt++;
                int temp = arr[i];
                arr[i] = arr[m];
                arr[m] = temp;
                map.replace(arr[m], m);

                if(cnt == k) {
                    System.out.print(arr[m]+" "+arr[i]);
                    return;
                }
            }
        }

        System.out.print("-1");
    }
}

