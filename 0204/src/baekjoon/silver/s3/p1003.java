package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1003 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[][] answer = new int[2][41];
		answer[0][0] = 1;
		answer[1][0] = 0;
		answer[0][1] = 0;
		answer[1][1] = 1;
		for(int i=2; i<=40; i++) {
			answer[0][i] = answer[0][i-1] + answer[0][i-2];
			answer[1][i] = answer[1][i-1] + answer[1][i-2];
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		int input;
		for(int i=0; i<testcase; i++) {
			input = Integer.parseInt(br.readLine());
			System.out.println(answer[0][input] +" "+answer[1][input]);
		}
	}
}
