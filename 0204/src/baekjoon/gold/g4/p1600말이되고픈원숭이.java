package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1600말이되고픈원숭이 {
	static int[] walkX = new int[] { 0, 0, 1, -1 };
	static int[] walkY = new int[] { 1, -1, 0, 0 };
	static int[] horseX = new int[] { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] horseY = new int[] { 2, 1, -1, -2, -2, -1, 1, 2 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		boolean[][][] visited = new boolean[height][width][K+1];

		for (int i = 0; i < height; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < width; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					for(int k=0; k<K+1; k++)
						visited[i][j][k] = true;
				}
			}
		}

		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { 0, 0, K, 0 });// 높이위치 너비위치 점프횟수 이동횟수
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			if(cur[0]==height-1&&cur[1]==width-1) {
				System.out.println(cur[3]);
				return;
			}
			if (cur[2] > 0) {
				for (int i = 0; i < 8; i++) {
					int ni = cur[0] + horseY[i];
					int nj = cur[1] + horseX[i];
					if(0<=ni&&ni<height&&0<=nj&&nj<width&&!visited[ni][nj][cur[2]-1]) {
						visited[ni][nj][cur[2]-1]= true;
						
						queue.offer(new int[] {ni, nj, cur[2]-1, cur[3]+1});
					}
				}
			}
			for (int i = 0; i < 4; i++) {
				int ni = cur[0] + walkY[i];
				int nj = cur[1] + walkX[i];
				if(0<=ni&&ni<height&&0<=nj&&nj<width&&!visited[ni][nj][cur[2]]) {
					visited[ni][nj][cur[2]]= true;
					queue.offer(new int[] {ni, nj, cur[2], cur[3]+1});
				}
			}
		}
		System.out.println(-1);
	}
}
