package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p8980택배 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int limit = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		int done = 0;

		int[][] delivery = new int[M][3];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			delivery[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()) };
		}

		Arrays.sort(delivery, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[1] == o2[1]) {
					return o2[0] - o1[0];
				} else {
					return o1[1] - o2[1];
				}
			}
		});
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		int[] pack = new int[N + 1];
		for (int[] d : delivery) {
			int maxload = Integer.MAX_VALUE;
			for (int i = d[0]; i < d[1]; i++) {
				maxload = Math.min(maxload, limit - pack[i]);
			}
			if (maxload != 0) {
				if (maxload > d[2]) {
					for (int i = d[0]; i < d[1]; i++) {
						pack[i] += d[2];
					}
					done += d[2];
				} else {
					for (int i = d[0]; i < d[1]; i++) {
						pack[i] += maxload;
					}
					done += maxload;
				}
			}
		}
		System.out.println(done);
	}
}
