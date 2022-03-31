package baekjoon.platinum.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p17411가장긴증가하는부분수열6 {
	static long bignum = 100000007;
	static int find(ArrayList<Long> dp, long num) {
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
		int N = Integer.parseInt(br.readLine());
		long[] num = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Long.parseLong(st.nextToken());
		}
		ArrayList<Long> dp = new ArrayList<>();
		ArrayList<Long[]> count = new ArrayList<>();
		ArrayList<PriorityQueue<Integer>> pq = new ArrayList<>();
		count.add(new Long[] { (long) 1, (long) 1 });
		
		dp.add(Long.MIN_VALUE);
		int max = 1;
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				dp.add(num[i]);
				count.add(new Long[] { (count.get(dp.size()-2)[0]*count.get(dp.size()-2)[1])%bignum, (long) 1 });
			} else {
				if (dp.get(dp.size() - 1) < num[i]) {
					dp.add(num[i]);
					count.add(new Long[] { (count.get(dp.size()-2)[0]*count.get(dp.size()-2)[1])%bignum, (long) 1 });
				} else {
					int idx = find(dp, num[i]);
					if (dp.get(idx) != num[i]) {
						dp.set(idx, num[i]);
					} 
					
				}
			}
			System.out.println(dp);
		}
		System.out.println(dp.size() - 1);
		System.out.println(cnt);

	}
}
