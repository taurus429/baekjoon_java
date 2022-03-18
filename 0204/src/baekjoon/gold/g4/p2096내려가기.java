package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2096내려가기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int maxIdx(int[] line) {
		int max = Integer.MIN_VALUE;
		int res = -1;
		for (int i = 0; i < 3; i++) {
			if (line[i] > max) {
				max = line[i];
				res = i;
			}
		}
		return res;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[3];
		int[] mindp = new int[3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int[] array = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()) };
			int[] temp = new int[3];
			int[] mintemp = new int[3];
			if (i == 0) {
				dp[0] = array[0];
				dp[1] = array[1];
				dp[2] = array[2];
				mindp[0] = array[0];
				mindp[1] = array[1];
				mindp[2] = array[2];
			} else {
				temp[0] = array[0] + Math.max(dp[0], dp[1]);
				temp[1] = array[1] + Math.max(dp[0], Math.max(dp[1], dp[2]));
				temp[2] = array[2] + Math.max(dp[1], dp[2]);
				dp[0] = temp[0];
				dp[1] = temp[1];
				dp[2] = temp[2];
				
				mintemp[0] = array[0] + Math.min(mindp[0], mindp[1]);
				mintemp[1] = array[1] + Math.min(mindp[0], Math.min(mindp[1], mindp[2]));
				mintemp[2] = array[2] + Math.min(mindp[1], mindp[2]);
				mindp[0] = mintemp[0];
				mindp[1] = mintemp[1];
				mindp[2] = mintemp[2];
				
				
			}
		}
		System.out.print(Math.max(dp[0], Math.max(dp[1], dp[2]))+" ");
		System.out.println(Math.min(mindp[0], Math.min(mindp[1], mindp[2])));
	}
}
