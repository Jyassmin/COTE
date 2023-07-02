package doit.study1_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//3
//3 7
//15 7
//5 2
//(260)

// 색종이
// 색종이의 종이가 주어지며, 이어서 가로세로가 10cm인 색종이의 왼쪽아래 모서리위치가 주어진다.
// 도화지 위의 색종이가 차지하는 면적은?

// 도화지는 (100,100)의 매트릭스이고 
// (3,7)의 색종이가 주어지면 가 x 3~12까지의  y7~16이 1로 채워진다.
// 이후 1을 전부 합산하면 끝.


public class B2563 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		int x, y, sum=0;
		
		int[][] mt = new int[100][100];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.valueOf(st.nextToken());
			y = Integer.valueOf(st.nextToken());
			for (int j=x; j<x+10; j++) {
				for (int k=y; k<y+10; k++) {
					if (mt[j][k]==0) {
						sum = sum+1;
						mt[j][k] = 1;
					}
				}
			}
		}
		
		System.out.print(sum);
		
		
	}
}
