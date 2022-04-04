package baekjoon.gold.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1194달이차오른다가자 {
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		char[][] grid = new char[height][width];
		int posI = -1;
		int posJ = -1;
		for (int i = 0; i < height; i++) {
			String input = br.readLine();
			for (int j = 0; j < width; j++) {
				if (input.charAt(j) == '0') {
					posI = i;
					posJ = j;
					grid[i][j] = '.';
				} else {
					grid[i][j] = input.charAt(j);
				}
			}
		}
		boolean[][][] visited = new boolean[64][height][width];
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { 0, posI, posJ, 0 }); // 열쇠상태, 높이, 너비, 이동횟수
		visited[0][posI][posJ] = true;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int ni = cur[1] + dy[i];
				int nj = cur[2] + dx[i];
				if (0 <= ni && ni < height && 0 <= nj && nj < width && !visited[cur[0]][ni][nj]) {
					if (grid[ni][nj] == '.') {
						visited[cur[0]][ni][nj] = true;
						queue.offer(new int[] { cur[0], ni, nj, cur[3] + 1 });
					} else if (97 <= grid[ni][nj] && grid[ni][nj] <= 102) {// 키획득
						visited[cur[0]][ni][nj] = true;
						if (((int) Math.pow(2, grid[ni][nj] - 97) & cur[0]) == (int) Math.pow(2, grid[ni][nj] - 97)) {//중복 갱신 방지
							queue.offer(new int[] { cur[0], ni, nj, cur[3] + 1 });
						}else { // 키획득 갱신
							queue.offer(new int[] { cur[0] + (int) Math.pow(2, grid[ni][nj] - 97), ni, nj, cur[3] + 1 });
						}
					} else if (65 <= grid[ni][nj] && grid[ni][nj] <= 70) {// 문
						if (((int) Math.pow(2, grid[ni][nj] - 65) & cur[0]) == (int) Math.pow(2, grid[ni][nj] - 65)) {
							visited[cur[0]][ni][nj] = true;
							queue.offer(new int[] { cur[0], ni, nj, cur[3] + 1 });
						}
					} else if (grid[ni][nj] == '1') {
						System.out.println(cur[3] + 1);
						return;
					}
				}
			}
		}
		System.out.println(-1);
	}
}
