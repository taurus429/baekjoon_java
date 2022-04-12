package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p원점으로집합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] dist = new int[N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				dist[i] = Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
			}
			for (int i = 0; i < N; i++) {
				if (i >= 1 && dist[i] % 2 != dist[i - 1] % 2) {
					max = -1;
					break;
				} else {
					max = Math.max(dist[i], max);
				}
			}
			int idx = 0;

			if (max != -1) {
				long sum = 0;
				while (true) {
					sum += idx;
					if (sum >= max && (sum - max) % 2 == 0) {
						break;
					}
					idx++;
				}
			} else {
				idx = -1;
			}
			System.out.println("#" + t + " " + idx);
		}
	}
}
