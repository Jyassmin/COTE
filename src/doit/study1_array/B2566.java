package doit.study1_array;

//3 23 85 34 17 74 25 52 65
//10 7 39 42 88 52 14 72 63
//87 42 18 78 53 45 18 84 53
//34 28 64 85 12 16 75 36 55
//21 77 45 35 28 75 90 76 1
//25 87 65 15 28 11 37 28 74
//65 27 75 41 7 89 78 64 39
//47 47 70 45 23 65 3 41 44
//87 13 82 38 31 12 29 29 80

// 9x9행렬의 입력을 받아 최대값과 위치 x,y를 출력하라.
// 출력되는 위치는 번째단위이기에 인덱스+1

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2566 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 최대값 & 위치 찾기(행렬 생성x)
		int temp;
		int max_num=0, max_x=0, max_y=0;
		
		for (int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<9; j++) {
				temp = Integer.valueOf(st.nextToken());
				if (max_num < temp) {
					max_num = temp;
					max_x = i;
					max_y = j;
				}
			}
		}
		
		// 결과 출력 
		System.out.printf("%d\n%d %d", max_num, max_x+1, max_y+1);
		
		

	}
}
