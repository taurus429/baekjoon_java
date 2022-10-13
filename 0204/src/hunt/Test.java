package hunt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test {
	static int[] dx = new int[] { 0, 1, -1, 0, 0 };
	static int[] dy = new int[] { 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		boolean[] right = new boolean[N];
		for (int i = 0; i < N; i++) {
			if (Integer.parseInt(st.nextToken()) == 1) {
				right[i] = true;
			}
		}
		char[][][] grid = new char[N][N][N];
		int startI = -1;
		int startJ = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				grid[0][i][j] = st.nextToken().charAt(0);
				if (grid[0][i][j] == '*') {
					grid[0][i][j] = '1';
					startI = i;
					startJ = j;
				}
			}
		}
		for (int k = 1; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if (right[i]) {
					char temp  = grid[k-1][i][N-1];
					for (int j = N-1; j >0; j--) {
						grid[k][i][j] = grid[k-1][i][j-1];
					}
					grid[k][i][0] = temp;
				} else {
					char temp  = grid[k-1][i][0];
					for (int j = 0; j <N-1; j++) {
						grid[k][i][j] = grid[k-1][i][j+1];
					}
					grid[k][i][N-1] = temp;
				}
			}
		}

		boolean[][][] visited = new boolean[N][N][N];

		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {startI, startJ, 0});
		visited[startI][startJ][0] = true;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			if(grid[cur[2]%N][cur[0]][cur[1]]!='0'&&grid[cur[2]%N][cur[0]][cur[1]]!='1') {
				System.out.println(grid[cur[2]%N][cur[0]][cur[1]]);
				System.out.println(cur[2]);
				return;
			}
			for(int i=0; i<5; i++) {
				int ni = cur[0] + dy[i];
				int nj = cur[1] + dx[i];
				nj = (nj + N) % N;
				int move = 0;
				if(ni<N&&right[ni]) {
					move = 1;
				} else {
					move = -1;
				}
				if(0<=ni&&ni<N&&0<=nj&&nj<N&&grid[cur[2]%N][ni][nj]!='0'&&!visited[(cur[2]+1)%N][ni][(nj+move+N)%N]) {
					visited[(cur[2]+1)%N][ni][(nj+move+N)%N] = true;
					queue.offer(new int[] {ni, (nj+move+N)%N, cur[2]+1});
				}
			}
		}
		System.out.println(-1);
	}
}