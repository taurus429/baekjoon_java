package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p10026적록색약 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] grid;
	static int N;
	static boolean[][] visited;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static void bfs(int y, int x, int color, boolean blind) { // 시작 지점의 포인트와 색깔과 색맹 여부를 받음
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { y, x });// 방문 큐에 시작 지점 추가
		visited[y][x] = true;// 방문 처리
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			for (int i = 0; i < 4; i++) {
				int ny = current[0] + dy[i];
				int nx = current[1] + dx[i];
				if (0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx]) { //방문 가능한 지역이고, 아직 방문 안했다면
					if (blind&&(color==0||color==1)) {//색맹이고, 시작 색깔이 적색이나 녹색일 때
						if (grid[ny][nx] == 0||grid[ny][nx] == 1) {//후보 지점 색이 적색이나 녹색이면
							queue.offer(new int[] { ny, nx });//큐에 추가
							visited[ny][nx] = true;// 방문처리
						}
					} else {
						if (grid[ny][nx] == color) {//색맹이 아닐 때 는 시작지점과 색이 같을 때
							queue.offer(new int[] { ny, nx });
							visited[ny][nx] = true;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		N = Integer.parseInt(br.readLine());
		grid = new int[N][N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				char temp = input.charAt(j);
				switch (temp) {//RGB를 각각 0 1 2 로 저장
				case 'R':
					grid[i][j] = 0;
					break;
				case 'G':
					grid[i][j] = 1;
					break;
				case 'B':
					grid[i][j] = 2;
					break;
				default:
					break;
				}
			}
		}
		int cnt = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) { //grid의 모든 점에 대해서
				if (!visited[i][j]) { // 방문하지 않았을 경우만
					bfs(i, j, grid[i][j], false);//bfs수행(색명 X)
					cnt++;//수행할 경우 영역 카운트 증가
				}
			}
		}
		System.out.print(cnt+" ");
		cnt = 0;
		visited = new boolean[N][N];// 방문 배열, 카운트 다시 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j, grid[i][j], true);// 색맹일 경우
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
