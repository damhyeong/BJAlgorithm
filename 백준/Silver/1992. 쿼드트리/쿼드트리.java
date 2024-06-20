import java.util.*;
import java.io.*;

/**
쿼드트리

시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	51874	32284	24630	62.252%

문제
---
흑백 영상을 압축하여 표현하는 데이터 구조로 쿼드 트리(Quad Tree)라는 방법이 있다. 

흰 점을 나타내는 0과 검은 점을 나타내는 1로만 이루어진 영상(2차원 배열)에서 같은 숫자의 점들이 한 곳에 많이 몰려있으면, 

쿼드 트리에서는 이를 압축하여 간단히 표현할 수 있다.

주어진 영상이 모두 0으로만 되어 있으면 압축 결과는 "0"이 되고, 모두 1로만 되어 있으면 압축 결과는 "1"이 된다. 

만약 0과 1이 섞여 있으면 전체를 한 번에 나타내지를 못하고, 

왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래, 이렇게 4개의 영상으로 나누어 압축하게 되며, 

이 4개의 영역을 압축한 결과를 차례대로 괄호 안에 묶어서 표현한다

0 = white, 1 = black

0	0	0	0	0	0	0	0
0	0	0	0	0	0	0	0
0	0	0	0	1	1	1	1
0	0	0	0	1	1	1	1
0	0	0	1	1	1	1	1
0	0	1	1	1	1	1	1
0	0	1	1	1	1	1	1
0	0	1	1	1	1	1	1

result : (0(0011)(0(0111)01)1)


위 그림에서 왼쪽의 영상은 오른쪽의 배열과 같이 숫자로 주어지며, 

이 영상을 쿼드 트리 구조를 이용하여 압축하면 "(0(0011)(0(0111)01)1)"로 표현된다. 

N × N 크기의 영상이 주어질 때, 

이 영상을 압축한 결과를 출력하는 프로그램을 작성하시오.


입력
---
첫째 줄에는 영상의 크기를 나타내는 숫자 N 이 주어진다. 

N 은 언제나 2의 제곱수로 주어지며, 1 ≤ N ≤ 64의 범위를 가진다. 

두 번째 줄부터는 길이 N의 문자열이 N개 들어온다. 

각 문자열은 0 또는 1의 숫자로 이루어져 있으며, 영상의 각 점들을 나타낸다.


출력
---
영상을 압축한 결과를 출력한다.

예제 입력 1 
8
11110000
11110000
00011100
00011100
11110000
11110000
11110011
11110011
예제 출력 1 
((110(0101))(0010)1(0001))
 */

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		boolean[][] WB = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			char[] chs = br.readLine().trim().toCharArray();
			for(int j = 0; j < N; j++)
				WB[i][j] = chs[j] == '1' ? true : false;
		}
		
		String result = makeQuadraStructure(WB, 0, 0, N);
		
		System.out.println(result);
	}

	public static String makeQuadraStructure(boolean[][] WB, int sY, int sX, int size) {
		int mY = sY + (size / 2);
		int mX = sX + (size / 2);
		
		if(isOneColor(WB, sY, sX, size)) {
//			return new String(getColor(WB, sY, sX));
			return getColor(WB, sY, sX);
		} else if(size == 1) {
			return getColor(WB, sY, sX);
		}
		
		String result = "(";
		
		// Top Left
		if(isOneColor(WB, sY, sX, size / 2)) {
			result += getColor(WB, sY, sX);
		} else {
			result += makeQuadraStructure(WB, sY, sX, size / 2);
		}
		
		// Top Right
		if(isOneColor(WB, sY, mX, size / 2)) {
			result += getColor(WB, sY, mX);
		} else {
			result += makeQuadraStructure(WB, sY, mX, size / 2);
		}
		
		// Bottom Left
		if(isOneColor(WB, mY, sX, size / 2)) {
			result += getColor(WB, mY, sX);
		} else {
			result += makeQuadraStructure(WB, mY, sX, size / 2);
		}
		
		// Bottom Right
		if(isOneColor(WB, mY, mX, size / 2)) {
			result += getColor(WB, mY, mX);
		} else {
			result += makeQuadraStructure(WB, mY, mX, size / 2);
		}
		
		return result + ')';
	}
	
	public static boolean isOneColor(boolean[][] WB, int sY, int sX, int size) {
		boolean color = WB[sY][sX];
		boolean isOneColor = true;
		
		for(int i = sY; i < sY + size; i++) {
			for(int j = sX; j < sX + size; j++) {
				if(WB[i][j] != color) {
					isOneColor = false;
					break;
				}
			}
		}
		return isOneColor;
	}
	
	public static String getColor(boolean[][] WB, int i, int j) {
		return WB[i][j] ? "1" : "0";
	}
}
