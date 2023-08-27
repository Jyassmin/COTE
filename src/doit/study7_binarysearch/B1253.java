package doit.study7_binarysearch;

import java.util.*;

//[서론]
// 서로 다른 A,B,C가 있을 때 A = B+C를 만족하는 수의 갯수를 구해야한다.
// B,C 고르는 조합 N^2이고, 이분탐색은 log2(n)이니  N^2 * log2(n)으로 실행시간(2초) 미만이다.
// 그러나 이분탐색의 경우 음수와 0에 대한 예외처리가 너무 복잡하다.
// 이분탐색 풀이 참고: https://dlwnsdud205.tistory.com/158
// 그래서 이분탐색으로 풀어도 되지만, 투포인터가 굉장히 직관적으로 쉽게 풀 수 있기에 투포인터로 풀어보자.

//[풀이]
// 우리가 찾고자하는 target은 A이고, B와 C의 합이 A와 같은 경우를 찾으면 된다.
// 시작점을 B, 끝점을 C로하고
// B+C가 target보다 크면 B+C값을 줄이기 위해 끝점을 -1해주고
// B+C가 target보다 크면 B+C값을 키우기 위해 시작점을 +1해준다.
// 주의점(건너뛰기) : A,B,C는 서로 다른 수이기 때문에 B,C는 A가 되면 안된다.(마찬가지로 B랑 C가 같으면 종료)

// 의문점? A를 고르는 게 O(N)이고 B,C는 서로 겹치지 않고 같은 배열 하나를 탐색하니 이것도 O(N)이면 최종 시간 복잡도가 O(N^2)인가???

public class B1253 {
    static int[] arr;
    static int N, cnt = 0;

    public static void main(String[] args) {
        // N, arr 입력받기
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // 정렬 필수
        Arrays.sort(arr);

        // Search
        for (int i = 0; i < N; i++) { // i는 target(A)이다.
            int start = 0; // 시작점(B)
            int end = N - 1; // 끝점(C)

            while (start != end) { // 종료 조건 : B와 C가 같을 시.(A는 서로 다른 B,C의 합이므로 최소 숫자가 2개 이상이어야한다.)
                if (start == i) { // 건너뛰기: B는 A가 되면 안된다.
                    start++;
                }
                else if (end == i) { // 건너뛰기: C는 A가 되면 안된다.
                    end--;
                }
                else {
                    int temp = arr[start] + arr[end]; // temp = B+C
                    if (temp == arr[i]) { // A를 찾았으면 Count & stop
                        cnt++;
                        break;
                    }
                    else if (temp > arr[i]) {  // target이 temp보다 작으니, temp를 감소시켜야하기에 end = end-1
                        end--;
                    }
                    else { // target이 temp보다 크니, temp를 증가시켜야하기에 start = start+1
                        start++;
                    }
                }
            }

        }
        System.out.println(cnt);
    }
}