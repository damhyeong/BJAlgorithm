
import java.util.*;
import java.io.*;

/**

예제 입력 1 
1 2 3
예제 출력 1 
5
예제 입력 2 
2 2 2
예제 출력 2 
6
예제 입력 3 
1 100 1
예제 출력 3 
3
예제 입력 4 
41 64 16
예제 출력 4 
113

문제
영선이는 길이가 a, b, c인 세 막대를 가지고 있고, 각 막대의 길이를 마음대로 줄일 수 있다.

영선이는 세 막대를 이용해서 아래 조건을 만족하는 삼각형을 만들려고 한다.

각 막대의 길이는 양의 정수이다
세 막대를 이용해서 넓이가 양수인 삼각형을 만들 수 있어야 한다.
삼각형의 둘레를 최대로 해야 한다.
a, b, c가 주어졌을 때, 만들 수 있는 가장 큰 둘레를 구하는 프로그램을 작성하시오. 

입력
첫째 줄에 a, b, c (1 ≤ a, b, c ≤ 100)가 주어진다.

출력
첫째 줄에 만들 수 있는 가장 큰 삼각형의 둘레를 출력한다.
 */

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		LinkedList<Integer> sticks = new LinkedList<Integer>();
		
		int max = -1;
		int sum = 0;
		
		while(st.hasMoreTokens()) {
			sticks.add(Integer.parseInt(st.nextToken()));
			int newNum = sticks.getLast();
			if(max <= newNum)
				max = newNum;
			sum += newNum;
		}
		
		StringBuilder sb = new StringBuilder();
		if(max >= sum - max) {
			int newMax = sum - max - 1;
			
			sb.append((newMax + (sum - max)));
		} else {
			sb.append(sum);
		}
		System.out.println(sb);
	}

}
