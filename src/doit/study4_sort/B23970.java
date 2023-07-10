package doit.study4_sort;

//6
//4 6 5 1 3 2
//4 1 3 2 5 6
////1


// [알고리즘 수업 - 버블 정렬 3]
// 배열 A를 오름차순 정렬하다가 배열 B와 같으면 1, 아니면 0

// 접근1 : sum을 이용해서 원소교체시 A[j],B[j]가 같으면 +1, 다르면 -1을 한 뒤, sum == n이면 정렬을 중단하고 print(1);
    // 그러나 이 방법에는 문제가 존재. A[j],B[j]가 원래 다른데, 교체 시 또 다르다고 -1을 해버리면 sum이 -값이 되어버릴 수 있음.
    // 그렇기에 A[j],B[j]가 같다가 달라질 경우만 -1을 해줘야함.

// 접근2 : C배열을 사용해 A[j],B[j]가 같다가 달라질 경우을 check하자.
    // C[j]에는 A[j],B[j]가 같으면 1, 다르면 0을 넣어준다.
    // 원소 교체 시, 0 -> 1이면 sum++
    // 1 -> 0 이면 sum--
    // 0 -> 0 이면 sum 그대로!

// 접근3 : 접근2처럼 arr과 sum을 같이 사용해줘야한다.
    // sum은 A가 B와 같을 때(sum==n) 탈출하게 해주는 역할을 한다.
    // (A와 B가 정렬 중간에 같더라도, 탈출 조건이 없다면 정렬이 계속되기 때문에 A의 최종 정렬배열과 B랑 비교하는 것은 의미없다.)

// 주의점 : 초기 세팅이 필요하다.
    // A의 초기배열이 B와 같은지 당연히 확인해야하며
    // 다를 때에만 버블정렬을 실행하도록 한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B23970 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            A[i] = Integer.parseInt(st.nextToken());

        int[] B = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            B[i] = Integer.parseInt(st.nextToken());

        int[] C = new int[n]; // A, B의 같은 위치 원소가 같을 때 1을 담아주는 배열
        int sum = 0; // 같을 때 1, 다를 때 0

        // 배열C 초기세팅
        for (int i = 0; i < n; i++) {
            if (A[i] == B[i]) {
                C[i] = 1;
                sum++;
            }
        }

        // sorting
        int temp;
        if (sum != n) {
            exit:
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - 1 - i; j++) {

                    if (A[j] > A[j + 1]) {  // 오름차순 정렬
                        temp = A[j];
                        A[j] = A[j + 1];
                        A[j + 1] = temp;

                        if (A[j] == B[j]) {
                            C[j] = 1;
                            sum++;
                        } else if (C[j] == 1) {
                            C[j] = 0;
                            sum--;
                        } else {
                            C[j] = 0;
                        }

                        if (A[j + 1] == B[j + 1]) {
                            C[j + 1] = 1;
                            sum++;
                        } else if (C[j + 1] == 1) {
                            C[j + 1] = 0;
                            sum--;
                        } else {
                            C[j + 1] = 0;
                        }
                    }

                    if (sum == n)  // 배열이 같을 때(sum==n)일 때 탈출해야함. 여기서 더 swap 해버리면 C가 달라저버럼. 이 떄문에 탈출을 위해 C배열 뿐만 아니라 sum이 필요함!
                        break exit;
                }
            }
        }
        // A와 B가 같았던 때가 있는지 확인
        boolean flag = true;
        for (int e : C) {
            if (e == 0)
                flag = false;
        }

        if (flag)
            System.out.println(1);
        else
            System.out.println(0);
    }
}
