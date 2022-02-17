package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1247 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean[] visited;
	static int N;
	static int[][] adj;
	static int sum;
	static int minAns;

	static int getdist(int[] p1, int[] p2) {
		return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
	}

	static void backtrack(int cnt, int before) {
		if (cnt == N) {
			sum += adj[before][N + 1];
			if (minAns > sum) {
				minAns = sum;
			}
			sum -= adj[before][N + 1];
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (!visited[i]&&before!=i) {
				visited[i] = true;
				sum += adj[before][i];
				if (sum < minAns) {
					backtrack(cnt + 1, i);
				}
				visited[i] = false;
				sum -= adj[before][i];
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			int[] company = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			int[] home = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			int[][] client = new int[N][2];
			for (int i = 0; i < N; i++) {
				client[i][0] = Integer.parseInt(st.nextToken());
				client[i][1] = Integer.parseInt(st.nextToken());
			}
			adj = new int[N + 2][N + 2];
			for (int i = 0; i < N; i++) {
				adj[0][i + 1] = getdist(company, client[i]);
				adj[i + 1][0] = getdist(company, client[i]);
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					adj[i + 1][j + 1] = getdist(client[i], client[j]);
					adj[j + 1][i + 1] = getdist(client[i], client[j]);
				}
			}
			for (int i = 0; i < N; i++) {
				adj[N + 1][i + 1] = getdist(home, client[i]);
				adj[i + 1][N + 1] = getdist(home, client[i]);
			}
			minAns = Integer.MAX_VALUE;
			visited = new boolean[N + 1];
			backtrack(0, 0);
			System.out.println("#"+t+" "+minAns);
		}
	}
}
