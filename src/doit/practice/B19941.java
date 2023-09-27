package doit.practice;

/*
20 1
HHPHPPHHPPHPPPHPHPHP
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B19941 {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Character[] hp_list = new Character[n];
        String hp = br.readLine();
        for (int i=0; i<n; i++)
                hp_list[i] = hp.charAt(i);

        // h_list, p_list 쪼개기
        int[] h_list = new int[n];
        int[] p_list = new int[n];
        for (int i=0; i<n; i++) {
            if (hp_list[i] == 'H') {
                h_list[i] = 1;
            } else {
                p_list[i] = 1;
            }
        }

        int idx;
        int cnt=0;
        for (int i=0; i<n; i++) {
            if (p_list[i] == 1) {
                idx = i;

                for (int j=(idx-k); j<=idx+k; j++) {
                    if ((j >=0 ) && (j < n) && (h_list[j] == 1)) {
                        h_list[j] = 0;
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
