package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1301비즈공예 {
	static int[] biz, ans;
	static int N, sum, count;

	static void make(int cnt, int before1, int before2) {
		int left = sum - cnt;
		int max = 0;
		for(int b: biz) {
			max = Math.max(max, b);
		}
		if(left<=(max-1)*3)
			return;
		if(cnt==sum) {
			count++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (i != before1 && i != before2) {
				if (biz[i] != 0) {
					biz[i] --;
					ans[cnt] = i;
					make(cnt +1, i, before1);
					biz[i] ++;
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		biz = new int[N];
		sum = 0;
		for (int i = 0; i < N; i++) {
			biz[i] = Integer.parseInt(br.readLine());
			sum += biz[i];
		}
		ans = new int[sum];
		make(0, -1, -1);
		System.out.println(count);
	}
}
