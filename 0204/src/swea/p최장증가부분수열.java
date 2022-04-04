package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p최장증가부분수열 {
	static int find(ArrayList<Integer> dp, int num) {
		int start = 0;
		int end = dp.size();
		while (start + 1 < end) {
			int mid = (start + end) / 2;
			if (dp.get(mid) > num) {
				end = mid;
			} else if (dp.get(mid) < num) {
				start = mid;
			} else {
				return mid;
			}
		}
		return start + 1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] num = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			ArrayList<Integer> dp = new ArrayList<>();
			dp.add(Integer.MIN_VALUE);
			for (int i = 0; i < N; i++) {
				if (i == 0) {
					dp.add(num[i]);
				} else {
					if (dp.get(dp.size() - 1) < num[i]) {
						dp.add(num[i]);
					} else {
						int idx = find(dp, num[i]);
						if (dp.get(idx) != num[i])
							dp.set(idx, num[i]);
					}
				}
			}
			System.out.println("#"+t+ " "+ (dp.size() - 1));
		}
	}
}