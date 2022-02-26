package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7576토마토 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] grid;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int height, width, zeroCount;
	
	static int bfs(List<int[]> tomato) {// 익은 토마토의 위치를 매개변수로 받음
		Queue<int[]> queue = new LinkedList<int[]>();
		for(int[] t: tomato) {			
			queue.offer(new int[] {t[0], t[1], 0});// 토마토의 좌표와 시간을 큐에 넣음
			visited[t[0]][t[1]]= true;
		}
		int day = 0;
		while(!queue.isEmpty()) {//큐가 빌때까지 반복
			int[] next = queue.poll();
			day = next[2]; //시간 값 계속 갱신
			for(int i=0; i<4; i++) {
				int nx = next[1] + dx[i];
				int ny = next[0] + dy[i];
				if(nx>=0&&nx<width&&ny>=0&&ny<height&&!visited[ny][nx]&&grid[ny][nx]==0) { //안익은 토마토일 경우
					visited[ny][nx] = true; //방문표시
					grid[ny][nx] = 1; //익음 표시
					queue.offer(new int[] {ny, nx, next[2]+1}); //시간 증가
					zeroCount --;
				}
			}
		}
		return day; //마지막으로 갱신된 시간 반환
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		grid = new int[height][width];
		List<int[]> tomato = new ArrayList<int[]>();
		for(int i=0; i<height; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<width; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if(grid[i][j] == 0) {
					zeroCount ++;// 안익은 초기 토마토 계수
				} else if(grid[i][j] == 1) {
					tomato.add(new int[] {i, j}); //익은 토마토 위치 할당
				}
			}
		}
		visited = new boolean[height][width];
		int res = bfs(tomato);
		if(zeroCount == 0) {//다 익었을 시
			System.out.println(res);
		} else { //안 익었을 시
			System.out.println(-1);
		}
	}
}
