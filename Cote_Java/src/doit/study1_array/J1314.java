package doit.study1_array;
import java.util.Scanner;

public class J1314 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        func_char(n);

    }

    public static void func_char(int n) {
        char[][] arr = new char[n][n];
        char ch = 'A';
        int x=0, y=0; // arr(행,열)

        // 배열생성
        for (int i = 0; i<n*n; i++) {
            //A부터 증가하다가 Z가 나오면 A로 변경
            if (ch == 'Z') {
                ch = 'A';
            } else {
                ch++;
            }

            // x가 0 또는 n-1(끝)에 있을 때는 오른쪽으로! y증가
            if (((y%2==1)&(x==0)) | ((y%2==0)&(x==n-1)) ) {
                y++;
                continue;
            }
            
            // y가 짝수이면 x가 1씩 증가(아래로)
            if (y%2 == 0) {
                x++;
            } else { // y가 홀수이면 x가 1씩 감소(위로)
                x--;
            }
        }

        // 배열 출력
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.printf("%c ", arr[i][j]);
            }
            System.out.printf("\n");
        }
    }
}
