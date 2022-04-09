package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2602돌다리건너기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		String bridge1 = br.readLine();
		String bridge2 = br.readLine();

		int[][][] dp = new int[word.length()][2][bridge1.length() + 1];

		int idx = 0;
		for (int i = 0; i < bridge1.length(); i++) {
			if (bridge1.charAt(i) == word.charAt(0)) {
				idx++;
			}
			dp[0][0][i + 1] = idx;
		}
		idx = 0;
		for (int i = 0; i < bridge2.length(); i++) {
			if (bridge2.charAt(i) == word.charAt(0)) {
				idx++;
			}
			dp[0][1][i + 1] = idx;
		}
		for (int i = 1; i < word.length(); i++) {
			for (int j = 0; j < bridge1.length(); j++) {
				dp[i][0][j + 1] = dp[i][0][j];
				if(bridge1.charAt(j)==word.charAt(i)) {
					dp[i][0][j+1] += dp[i-1][1][j];
				}
			}
			for (int j = 0; j < bridge1.length(); j++) {
				dp[i][1][j + 1] = dp[i][1][j];
				if(bridge2.charAt(j)==word.charAt(i)) {
					dp[i][1][j+1] += dp[i-1][0][j];
				}
			}
		}
		System.out.println(dp[word.length()-1][0][bridge1.length()]+dp[word.length()-1][1][bridge2.length()]);
	}
}
