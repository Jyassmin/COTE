package doit.study4_sort;

//6 10
//4 6 5 1 3 2
////1 3 2 4 5 6


// [알고리즘 수업 - 버블 정렬 2]
// 오름차순
// 버블 정렬을 수행하다 k번 교체했을 때의 배열을 출력. 교체횟수가 k번 이하이라면 -1 출력

import java.io.*;
import java.util.StringTokenizer;

public class B23969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 배열 생성
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // 버블정렬
        int counts = 0;
        int temp;
        boolean flag = true; // -1 출력여부

        out :
        for (int i = 0; i < n-1; i++) {     // 2중 for문으로 정렬. i가 반복할 때마다 오른쪽 끝에 제일 큰 수가 하나씩 배치된다.
            for (int j = 0; j <n-1-i; j++) {     // j와 j+1을 n-2-i까지 비교&교체하여, 0 ~ n-2-i중 가장 큰 수를 오른쪽 끝에 배치한다.
                // 오름차순 정렬
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    counts++; // 교체 시 카운트!
                }

                // 교체횟수가 k일 때의 배열 출력             * 이걸 위 정렬 if문이랑 순서를 바꾸면 틀린다. -> 맨 마지막 반복 때 swap하면 for문 탈출해서 counts==k 확인 못함.
                if (counts == k) {
                    for (int e : arr)
                        sb.append(e).append(" ");
                    System.out.println(sb.toString());
                    flag = false; // 교체횟수가 k가 되면 -1 출력 x
                    break out; // 더이상 교체할 필요 없으니 탈출!
                }
            }
        }

        if (flag) { // k번 교체했을 때 배열이 출력되지 않았다면 출력.
            System.out.println("-1");
        }
    }
}
