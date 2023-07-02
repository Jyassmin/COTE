package doit.study1_array;

//AABCDD
//afzz
//09121
//a8EWg6
//P5h3kx
//(Aa0aPAf985Bz1EhCz2W3D1gkD6x)

// [세로 읽기]
// 5줄의 문자열을 받아 br로 배열에 넣어주고 세로로 차례대로 읽는다. 
// 이 때 null이면 출력하지 않는다. 

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B10798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] arr = {
				br.readLine().toCharArray(),
				br.readLine().toCharArray(),
				br.readLine().toCharArray(),
				br.readLine().toCharArray(),
				br.readLine().toCharArray()
		};

		char[] s1 = new char[arr[0].length + arr[1].length + arr[2].length + arr[3].length + arr[4].length];
		
		// 배열 생성 
		int x=0, y=0;
		for (int i=0; i<s1.length; i++) {
			if (x == 5) {
				y++; x=0;
			}
			
			if (y < arr[x].length) {
				s1[i] = arr[x][y];				
			} else { // 공백인 경우, 다음턴에 제자리에 넣기 위해서.
				i--;
			}
			x++;
		}
		
		// 출력 
		for (int i : s1)
			System.out.printf("%c", i);
	}

}
