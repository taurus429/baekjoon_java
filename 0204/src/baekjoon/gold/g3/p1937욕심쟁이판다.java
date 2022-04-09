package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1937욕심쟁이판다 {
	static int[][] move, grid;
	static int[] dx = new int[] {0, 0, 1, -1};
	static int[] dy = new int[] {1, -1, 0, 0};
	static int N, ans =1;
	static void find(int posI, int posJ) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i<4; i++) {
			int nextI = posI + dy[i];
			int nextJ = posJ + dx[i];
			if(0<=nextI&&nextI<N&&0<=nextJ&&nextJ<N&&grid[nextI][nextJ]<grid[posI][posJ]) {
				if(move[nextI][nextJ]==-1)
					find(nextI, nextJ);
				max = Math.max(max, move[nextI][nextJ]);
			}
		}
		if(max == Integer.MIN_VALUE) {
			move[posI][posJ] = 1;
		} else {
			move[posI][posJ] = max + 1;
			ans = Math.max(ans, move[posI][posJ]);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		grid= new int[N][N];
		move = new int[N][N];
		for(int i=0; i<N; i++) {
			Arrays.fill(move[i], -1);
		}
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(move[i][j]==-1)
					find(i,j);
			}
		}
		System.out.println(ans);
	}
}
