package doit.study7_binarysearch;

import java.util.*;

//[서론]
// 서로 다른 A,B,C가 있을 때 A = B+C를 만족하는 수의 갯수를 구해야한다.
// B,C 고르는 조합 N^2이고, 이분탐색은 log2(n)이니  N^2 * log2(n)으로 실행시간(2초) 미만이다.
// 그러나 이분탐색의 경우 음수와 0에 대한 예외처리가 너무 복잡하다.
// 이분탐색 풀이 참고: https://dlwnsdud205.tistory.com/158
// 그래서 이분탐색으로 풀어도 되지만, 투포인터가 굉장히 직관적으로 쉽게 풀 수 있기에 투포인터로 풀어보자.

// [이건 투포인터 풀이하고 읽자.]
// 투포인터의 경우 시작점과 끝점을 B,C로 정하고 시작점과, 끝점을 +1, -1하면서 A를 찾는 방법이며. 시작점과 끝점을 옮길 때 B,C인지를 확인하며 A와의 중복을 피할 수 있다.(B,C가 A인지 확인하는 방법)
// 하지만 이분탐색으로 풀게되면 서로 다른 B,C를 정하고, A를 찾을 때 배열 전체에서 탐색을 해야하는데, 이때 B,C와의 중복을 피하는 예외처리가 어렵다.(A가 B,C인지 확인하는 방법)
// 만약 한다고 하면, 2중 for문으로 B,C를 정하고(B<C조건 필수). A를 이분탐색하며 mid가 B or C의 인덱스이면 start=mid+1을 해줘야한다.
// 그러나 만약 배열이 000이면 좋은수는 3개여야하는데 이 방식대로 하면 2개가 된다.(A가 첫번째 0일경우)
// 그래서 다른 방식으로 0을 처리해줘야하는데 이게 복잡.


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

            while (start != end) { // 종료 조건 : B와 C가 같을 시.(A는 서로 다른 B,C의 합이므로 최소 숫자가 2개 이상이어야한다. / 사실 A도 다른수라 최소 3개이긴함. 근데 어차피 건너뛰기 되어서 종료조건은 이렇게!)
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