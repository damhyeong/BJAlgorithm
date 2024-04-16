import java.util.*;
import java.io.*;

/**
진법 변환 2

시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
0.5 초 (추가 시간 없음)	256 MB	49087	22861	19721	46.585%

문제
10진법 수 N이 주어진다. 
이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오.

10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 
이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.

A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35

입력
첫째 줄에 N과 B가 주어진다. 
(2 ≤ B ≤ 36) N은 10억보다 작거나 같은 자연수이다.

출력
첫째 줄에 10진법 수 N을 B진법으로 출력한다.

예제 입력 1 
60466175 36
예제 출력 1 
ZZZZZ
 */

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int decimalNum = Integer.parseInt(st.nextToken());
		int notation = Integer.parseInt(st.nextToken());
		
		int mulNotation = 1; // initialize divide Number.
		String transformNum = ""; // contain result.
		while(decimalNum != 0) {
			int tempNum = decimalNum % notation;
			transformNum = returnIntToChar(tempNum) + transformNum;
			decimalNum /= notation;
		}
		
		System.out.println(transformNum);
	}
	
	public static char returnIntToChar(int num) {
		return (num < 10) ? (char)('0' + num) : (char)(num - 10 + 'A');
	}
}
