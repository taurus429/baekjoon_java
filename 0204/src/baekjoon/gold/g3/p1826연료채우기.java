package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1826연료채우기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] gas = new int[N][];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			gas[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		}
		Arrays.sort(gas, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		st = new StringTokenizer(br.readLine());
		int dist = Integer.parseInt(st.nextToken());
		int oil = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> oilQ = new PriorityQueue<>(Collections.reverseOrder());
		int idx = 0;
		int cnt = 0;
		boolean impossible = false;
		while (oil < dist) {
			while (idx < N && gas[idx][0] <= oil) {
				oilQ.offer(gas[idx][1]);
				idx++;
			}
			if (oilQ.isEmpty()) {
				System.out.println(-1);
				impossible = true;
				break;
			}
			oil += oilQ.poll();
			cnt++;
		}
		if (!impossible)
			System.out.println(cnt);
	}
}
