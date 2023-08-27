package doit.practice;

// 4 4

//1 2 3 4
//1 2 4 3
//1 3 2 4
//1 3 4 2
//1 4 2 3
//1 4 3 2
//2 1 3 4
//2 1 4 3
//2 3 1 4
//2 3 4 1
//2 4 1 3
//2 4 3 1
//3 1 2 4
//3 1 4 2
//3 2 1 4
//3 2 4 1
//3 4 1 2
//3 4 2 1
//4 1 2 3
//4 1 3 2
//4 2 1 3
//4 2 3 1
//4 3 1 2
//4 3 2 1


// 반복으로 모든 경우의 수를 만드려는 방법은 시간초과나 메모리 초과로 끝난다.(잘못된 방법)
// 다중 포인터 문제!!!
// 1..n까지의 원소를 가지는 arr배열을 만들고


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class J15649_test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //조합 nCm 구하기
        int temp=n;
        int end=1;
        for (int i=0; i<n-m; i++) {
            end *= temp;
            temp--;
        }

        // 1..n 배열 생성
        temp=1;
        int[] arr_n = new int[n];
        for (int i=0; i<n; i++) {
            arr_n[i] = temp;
            temp++;
        }

        // 0..m-1 인덱스 배열 생성
        int[] index = new int[m];
        for (int i=0; i<m; i++)
            index[i]=i;

        int cnt = 0;
        while(cnt != end) { // end(조합수) 만큼 출력
            for (int i=m-1; i>=0; i--) { // 포인터 안겹치게 옮기기
                while (index[i] >= n || (i != m-1 && index[i] == index[i+1])) {
                    if (i != 0 && index[i-1] >= n )
                        break;
                    // 포인터 재배치
                    index[i-1] = index[i-1] + 1;
                    for (int h = i; h<m; h++)
                        index[h] = index[h-1]+1;
                }
            }
            //출력
            for (int e : index)
                System.out.printf("%d ", arr_n[e]);
            System.out.println();

            index[m-1]++;
            cnt++;
        }


    }

    private static boolean func_overlap(int[] arr, int m) {
        // 중복값이 있는지 확인하는 메소드
        Set<Integer> hs = new HashSet<Integer>();
        for (int e : arr)
            hs.add(e);

        return hs.size() != m;
    }


}

