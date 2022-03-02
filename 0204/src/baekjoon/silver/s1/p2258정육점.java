package baekjoon.silver.s1;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class p2258정육점 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] meat = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			meat[i][0] = weight;
			meat[i][1] = price;
		}
		Comparator<int[]> comparator = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[1] != o2[1])
					return o1[1] - o2[1];
				else
					return o2[0] - o1[0];
			}
		};

		Arrays.sort(meat, comparator);
		for (int i = 1; i < meat.length; i++) {
			meat[i][0] += meat[i - 1][0];
		}
		boolean find = false;
		int totalprice = 0;
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < meat.length; i++) {
			if(i!=0&&meat[i][1]==meat[i-1][1]) {
				totalprice += meat[i][1];
			}else {
				totalprice = meat[i][1];
			}
			if (meat[i][0] >= M) {
				find = true;
				if (ans > totalprice) {
					ans = totalprice;
				}
			}
		}
		if (!find)
			System.out.println(-1);
		else
			System.out.println(ans);
	}
}
