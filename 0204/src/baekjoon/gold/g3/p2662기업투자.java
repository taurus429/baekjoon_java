package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2662기업투자 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()) + 1;
		int company = Integer.parseInt(st.nextToken());
		int[][] money = new int[N][company];
		int[] dp = new int[N];
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			for (int j = 0; j < company; j++) {
				money[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			dp[i] = money[i][0];
		}
		ArrayList<Integer>[] ans = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			ans[i] = new ArrayList<Integer>();
			ans[i].add(i);
		}
		for (int k = 1; k < company; k++) {
			int[] newdp = new int[N];
			ArrayList<Integer>[] temp = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				int max = Integer.MIN_VALUE;
				int left = -1;
				int right = -1;
				for (int j = 0; j <= i; j++) {
					if (max < dp[j] + money[i - j][k]) {
						max = dp[j] + money[i - j][k];
						left = j;
						right = i - j;
					}
				}
				if (max > dp[i]) {
					newdp[i] = max;
					temp[i] = (ArrayList<Integer>) ans[left].clone();
					temp[i].add(right);
				} else {
					newdp[i] = dp[i];
					temp[i] = (ArrayList<Integer>) ans[i].clone();
					temp[i].add(0);
				}
			}
			dp = newdp.clone();
			for (int i = 0; i < N; i++) {
				ans[i] = (ArrayList<Integer>) temp[i].clone();
			}
		}
		int max = Integer.MIN_VALUE;
		int idx = 0;
		for(int i=0; i<N; i++) {
			if(max<dp[i]) {
				max = dp[i];
				idx = i;
			}
		}
		System.out.println(max);
		for(int a: ans[idx]) {
			System.out.print(a+" ");
		}
	}
}
