package doit.study1_array;

// 포기!!

//4 7
//ABCDEFG
//HIJKLMN
//OPQRSTU
//VWXYZ**
//CONTEST
//(30)

//2 19
//ABCDEFGHIJKLMNOPQZY
//X*****************Y
//AZAZ
//(19)

// [가상 키보드 입력]
// 가상 키보드의 행열이 주어지고, 가상키보드의 문자가 주어진다.
// 마지막 입력으로는 우리가 만들 단어가 있는데, 이 문자를 만들기 위
// 각 키를 옮겨다니고 select하는 최소 움직임을 count는 얼마일까?
// 마지막 문자와 *사이의 최소거리를 구하는게 핵심!

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10789_hard {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		int result=0;
		
		// 행렬생성 
		String temp;
		char[][] matrix = new char[n][m];
		
		for (int i=0; i<n; i++) {
			// st로 한 줄 받아서 string으로 저장 후 char로 쪼개기 
			st = new StringTokenizer(br.readLine());
			temp = String.valueOf(st.nextToken());
			for (int j=0; j<m; j++) {
				matrix[i][j] = temp.charAt(j);
			}
		}
		
		// 완성할 단어 입력받기
		st = new StringTokenizer(br.readLine());
		temp = String.valueOf(st.nextToken());
		char[] word = new char[temp.length()];
		for (int i=0; i<temp.length(); i++)
			word[i] = temp.charAt(i);
		
		
		// 거리 구하기(처음 문자까지의 거리 + 문자끼리의 거리 + 마지막 enter까지의 거리)
		result += func_location(matrix, matrix[0][0], word[0]);
		
		for (int i=0; i<word.length-1; i++)
			result += func_location(matrix, word[i], word[i+1]);
		
		result += func_location_last(matrix, word[word.length-1]);
		
		// 출력
		System.out.println(result);

	}
	
	// 두 문자의 사이의 거리를 구하는 함수
	// (0,0)에서 시작해서 첫번째 문자(0,2)로 이동할 때 count는 3이다.(select까지)
	public static int func_location(char[][] matrix, char c1, char c2) {
			int c1_x=0, c1_y=0, c2_x=0, c2_y=0;
			
			// 위치 찾기 
			for (int i=0; i < matrix.length; i++) {
				for (int j=0; j < matrix[0].length; j++) {
					if (matrix[i][j] == c1) {
						c1_x = i;
						c1_y = j;
					} else if (matrix[i][j] == c2) {
						c2_x = i;
						c2_y = j;
					}
				}
			}
			
			// 이동 거리 구하기
			c1_x = c1_x - c2_x;
			c1_y = c1_y - c2_y;
			if (c1_x < 0)
				c1_x = -1 * c1_x;
			if (c1_y < 0)
				c1_y = -1 * c1_y;
			if (c1_y == matrix[0].length-1)
				c1_y -= 1;
			
			return (c1_x + c1_y + 1); // +1은 select!
		
	}
	
	
	// 마지막 문자와 *사이의 최소거리를 구하는 함수 
	public static int func_location_last(char[][] matrix, char c1) {
		int min_distance=100, temp_x, temp_y;
		int c1_x=0, c1_y=0;
		
		// 마지막 문자 위치 찾기 
		for (int i=0; i < matrix.length; i++) {
			for (int j=0; j < matrix[0].length; j++) {
				if (matrix[i][j] == c1) {
					c1_x = i;
					c1_y = j;
					break;
				}
			}
		}
		
		// 제일 가까운 *과의 거리 구하기 
		for (int i=0; i < matrix.length; i++) {
			for (int j=0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '*') {
					temp_x = c1_x - i;
					temp_y = c1_y - j;
					
					if (temp_x < 0)
						temp_x = -1 * temp_x;
					if (temp_y < 0)
						temp_y = -1 * temp_y;
					
					if (min_distance > (temp_x+temp_y))
						min_distance = temp_x+temp_y;
				}
			}
		}
		
		return min_distance+1;
	}

}
