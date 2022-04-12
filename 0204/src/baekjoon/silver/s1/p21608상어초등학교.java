package baekjoon.silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p21608상어초등학교 {
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] order = new int[N * N + 1];
		HashMap<Integer, Integer>[] map = new HashMap[N * N + 1];
		for(int i=0; i<N*N+1; i++) {
			map[i] = new HashMap<>();
		}
		for (int i = 1; i < N * N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			order[i] = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 4; j++)
				map[order[i]].put(Integer.parseInt(st.nextToken()), 1);
		}
		int[][] grid = new int[N][N];
		int[][] empty = new int[N][N];
		ArrayList<Integer>[][] adj = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				adj[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
					if ((i == 0 || i == N - 1) && (j == 0 || j == N - 1)) {
						empty[i][j] = 2;
					} else {
						empty[i][j] = 3;
					}
				} else {
					empty[i][j] = 4;
				}
			}
		}
		boolean[][] visited = new boolean[N][N];
		for (int n = 1; n <= N * N; n++) {
			int cur = order[n];
			int maxadj = -1;
			int maxempty = -1;
			int posI = 20;
			int posJ = 20;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int curadj = 0;
					for (int a : adj[i][j]) {
						if (map[cur].containsKey(a))
							curadj++;
					}
					if (maxadj < curadj&&!visited[i][j]) {
						posI = i;
						posJ = j;
						maxempty = empty[i][j];
						maxadj = curadj;
					} else if (maxadj == curadj&&!visited[i][j]) {
						if (maxempty < empty[i][j]) {
							posI = i;
							posJ = j;
							maxempty = empty[i][j];
						} else if (maxempty == empty[i][j]) {
							if (i < posI) {
								posI = i;
								posJ = j;
							} else if (i == posI) {
								if (j < posJ) {
									posI = i;
									posJ = j;
								}
							}
						}
					}
				}
			}
			grid[posI][posJ] = cur;
			visited[posI][posJ] = true;
			for (int i = 0; i < 4; i++) {
				int ni = posI + dx[i];
				int nj = posJ + dy[i];
				if(0<=ni&&ni<N&&0<=nj&&nj<N) {
					empty[ni][nj] --;
					adj[ni][nj].add(cur);
				}
			}
		}
		int score = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int cnt = 0;
				for(int a: adj[i][j]) {
					if(map[grid[i][j]].containsKey(a))
						cnt++;
				}
				switch (cnt) {
				case 1:
					score += 1;
					break;
				case 2:
					score += 10;
					break;
				case 3:
					score += 100;
					break;
				case 4:
					score += 1000;
					break;
				default:
					break;
				}
			}
		}
		System.out.println(score);
	}
}
