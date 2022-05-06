package baekjoon.gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p2696중앙값구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < tc; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append((N + 1) / 2).append("\n");
			int[] num = new int[N];
			for (int i = 0; i < N; i++) {
				if (i % 10 == 0)
					st = new StringTokenizer(br.readLine());
				num[i] = Integer.parseInt(st.nextToken());
			}
			PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> high = new PriorityQueue<>();
			low.offer(Integer.MIN_VALUE);
			high.offer(Integer.MAX_VALUE);
			int line = 0;
			for (int i = 0; i < N; i++) {
				if (low.peek() <= num[i] && num[i] <= high.peek()) {
					if (low.size() == high.size()) {
						high.offer(num[i]);
					} else {
						low.offer(num[i]);
					}
				} else if (low.peek() > num[i]) {
					if (low.size() == high.size()) {
						high.offer(low.poll());
						low.offer(num[i]);
					} else {
						low.offer(num[i]);
					}
				} else {
					if (low.size() == high.size()) {
						high.offer(num[i]);
					} else {
						low.offer(high.poll());
						high.offer(num[i]);
					}
				}
				if (i % 2 == 0) {
					sb.append(high.peek() + " ");
					line += 1;
					if (line % 10 == 0) {
						sb.append("\n");
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}
}
