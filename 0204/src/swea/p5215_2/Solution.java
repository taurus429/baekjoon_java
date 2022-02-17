package swea.p5215_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int max = -1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[] taste = new int[N];
			int[] cal = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				taste[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i <= N; i++) {
				System.out.println(i);
				int[] c = new int[i];
				combi(0, 1, N, c, taste, cal, L);
			}
			System.out.println(max);

		}

	}

	static void combi(int cnt, int start, int end, int[] c, int[] taste, int[] cal, int L) {
		if(cnt == c.length) {
			int calSum=0;
			int tasteSum=0;
			for(int i: c) {
				calSum += cal[i-1];
				tasteSum += taste[i-1];
			}
			if(calSum<=L && tasteSum > max) {
				max = tasteSum;
			}
			return;
		}
		for(int i= start; i<= end; i++) {
			c[cnt] = i;
			combi(cnt+1, i+1, end, c, taste, cal, L);
		}
	}
}
