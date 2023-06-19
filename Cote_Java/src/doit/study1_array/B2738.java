package doit.study1_array;

//3 3

//1 1 1
//2 2 2
//0 1 0

//3 3 3
//4 4 4
//5 5 100

// 행렬덧셈
// 3행, 3열 행렬을 2개 받아 더하여 출력하라. 

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2738 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		
		// 행렬 생성 
		int[][] arr = new int[n][m];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				arr[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		
		// 합한 것을 바로 출력 
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				System.out.printf("%d ", arr[i][j] + Integer.valueOf(st.nextToken()));
			}
			System.out.println("");
		}
		

	}

}
