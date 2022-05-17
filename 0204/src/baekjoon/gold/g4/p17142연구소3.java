package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p17142연구소3 {
	static boolean[][] empty, activate;
	static boolean[][] visited;
	static int[] dy = new int[] { 0, 0, 1, -1 };
	static int[] dx = new int[] { 1, -1, 0, 0 };
	static int emptyCount, N, M;
	static ArrayList<int[]> virus;
	static int[] res;
	static int ans = Integer.MAX_VALUE;

	static void bfs() {
		visited = new boolean[N][N];
		Queue<int[]> queue = new LinkedList<int[]>();
		for (int r : res) {
			queue.offer(new int[] { virus.get(r)[0], virus.get(r)[1], 0 });
			visited[virus.get(r)[0]][virus.get(r)[1]] = true;
		}
		int spread = 0;
		int time = 0;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			time = Math.max(time, cur[2]);
			for (int i = 0; i < 4; i++) {
				int ni = cur[0] + dy[i];
				int nj = cur[1] + dx[i];
				if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj]) {
					if (empty[ni][nj]) {
						visited[ni][nj] = true;
						queue.offer(new int[] { ni, nj, cur[2] + 1 });
						spread++;
						if (spread == emptyCount) {
							ans = Math.min(ans, time);
							return;
						}
					} else if (activate[ni][nj]) {
						visited[ni][nj] = true;
						queue.offer(new int[] { ni, nj, cur[2] + 1 });
					}
				}
			}
		}
	}

	static void combi(int cnt, int idx) {
		if (cnt == M) {
			bfs();
			return;
		}
		for (int i = idx; i < virus.size(); i++) {
			res[cnt] = i;
			combi(cnt + 1, i + 1);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		empty = new boolean[N][N];
		activate = new boolean[N][N];
		virus = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 0) {
					empty[i][j] = true;
					emptyCount++;
				} else if (input == 2) {
					activate[i][j] = true;
					virus.add(new int[] { i, j });
				}
			}
		}
		if(emptyCount==0) {
			System.out.println(0);
			return;
		}
		res = new int[M];
		combi(0, 0);
		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans+1);
		}
	}
}
