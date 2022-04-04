package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class p사람네트워크 {
	static int N, ans;
	static int INF = Integer.MAX_VALUE;
	static int[][] dist;

	static int getSum(int startnode) {
		int[] mindist = new int[N];
		Arrays.fill(mindist, INF);

		
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		q.offer(new int[] { startnode, 0 });
		mindist[startnode] = 0;
		boolean[] visited = new boolean[N];
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (visited[cur[0]])
				continue;
			visited[cur[0]] = true;

			for (int i = 0; i < N; i++) {
				if (mindist[cur[0]]!= INF && dist[cur[0]][i]!=INF && mindist[i] > mindist[cur[0]] + dist[cur[0]][i]) {
					mindist[i] = mindist[cur[0]] + dist[cur[0]][i];
					q.offer(new int[] { i, mindist[i] });
				}
			}
		}
		int sum = 0;
		for(int i=0; i<N; i++) {
			sum += mindist[i];
			if(sum>ans) {
				return INF;
			}
		}
		return sum;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			dist = new int[N][N];
			INF = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (Integer.parseInt(st.nextToken()) == 1) {
						dist[i][j] = 1;
					} else {
						dist[i][j] = INF;
					}
					if (i == j)
						dist[i][j] = 0;
				}
			}
			ans  =INF;
			for(int i=0; i<N; i++) {
				ans = Math.min(getSum(i), ans);
			}
			System.out.println("#" + t + " "+ans);
		}
	}
}
