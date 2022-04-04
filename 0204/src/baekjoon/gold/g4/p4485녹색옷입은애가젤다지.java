package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p4485녹색옷입은애가젤다지 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = 0;
		int[][] tot;
		int[][] d = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		while (true) {
			int N = Integer.parseInt(br.readLine());
				break;
				if (N == 0)
			T++;
			sb.append("Problem ").append(T).append(": ");
			int[][] map = new int[N][N];
			tot = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					tot[i][j] = Integer.MAX_VALUE;
				}
			}
			tot[0][0] = map[0][0];
			pq.offer(new int[] { 0, 0, map[0][0] });
			label: while (!pq.isEmpty()) {
				int[] x = pq.poll();
				for (int i = 0; i < 4; i++) {
					int nx = x[0] + d[i][0];
					int ny = x[1] + d[i][1];
					if (0 <= nx && nx < N && 0 <= ny && ny < N && tot[nx][ny] > tot[x[0]][x[1]] + map[nx][ny]) {
						tot[nx][ny] = tot[x[0]][x[1]] + map[nx][ny];
						pq.offer(new int[] { nx, ny, map[nx][ny] });
						if(nx==N-1&&ny==N-1)
							break label;
					}
				}
			}
			sb.append(tot[N - 1][N - 1]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}