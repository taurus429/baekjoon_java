package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p16236 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] grid;// 전체 map
	static int eatCount;//먹이를 먹은 횟수
	static int sharkSize = 2;//상어의 초기 사이즈 2
	static int[] sharkPos;// 상어의 위치를 담기 위한 인티저 배열
	static int[] di = { 0, 0, 1, -1 };//4방탐색을 위한 배열
	static int[] dj = { 1, -1, 0, 0 };
	static boolean[][] visited;//방문 배열

	static int[] bfs(int[] sharkPos) { //상어가 갈 수 있는 후보지중 최적의 값을 반환
		visited = new boolean[N][N];
		Queue<int[]> queue = new LinkedList<int[]>(); // 방문지 큐 생성
		queue.add(new int[] { sharkPos[0], sharkPos[1], 0 }); // 행위치, 열위치, 이동거리 순으로 queue에 넣음
		visited[sharkPos[0]][sharkPos[1]] = true; // 초기 방문 처리
		int[] minMove = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}; // 후보지 최적값을 최악값으로 설정
		while (!queue.isEmpty()) {
			int[] next = queue.poll();
			for (int i = 0; i < 4; i++) { // 현재 위치에서 4방 탐색
				int ni = next[0] + di[i];
				int nj = next[1] + dj[i];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && !visited[ni][nj] && sharkSize >= grid[ni][nj]) {//i,j가 행,열 범위 내에 있고, 방문하지 않았고, 상어가 더 크거나 같을 경우
					if(sharkSize!=grid[ni][nj]&&grid[ni][nj]!=0) { // 먹을 수 있는 경우
						if(next[2]+1<minMove[2]) { // 최소값 보다 거리가 작다면
							minMove = new int[] {ni, nj, next[2] +1}; // 바로 갱신
						}else if(next[2]+1 == minMove[2]) { // 최소값과 거리가 같다면
							if(ni<minMove[0]) {// 행 좌표가 더 작을 때 갱신
								minMove = new int[] {ni, nj, next[2] +1};								
							}else if(ni==minMove[0]) {//행 좌표도 같다면 열 좌표가 더 작을 때 갱신
								if(nj<minMove[1]) {									
									minMove = new int[] {ni, nj, next[2] +1};								
								}
							}
						}
					}
					visited[ni][nj] = true; // 방문 처리
					queue.add(new int[] {ni, nj, next[2]+1}); // 큐 삽입
				}
			}
		}
		return minMove; // 최소 행렬 반환

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		grid = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if (grid[i][j] == 9) { // 상어 위치 일 경우
					sharkPos = new int[] { i, j }; // 전역 변수에 위치 할당
					grid[i][j] = 0; // 상어의 위치도 먹이가 없으므로 0으로 초기화
				}
			}
		}
		int time = 0;//초기 시간 0
		while(true) {
			int[] nextMove = bfs(sharkPos); // 최적 위치를 받아옴
			if(nextMove[0] == Integer.MAX_VALUE) // 먹을 수 있는 것이 없어서 최악값이 리턴 된 경우
				break;//루프 탈출
			time += nextMove[2]; // 시간 추가
			sharkPos[0] = nextMove[0];// 상어 좌표 갱신
			sharkPos[1] = nextMove[1];
			grid[nextMove[0]][nextMove[1]] = 0; // 먹이를 먹은 거 처리
			eatCount ++; // 먹은 횟수 증가
			if(eatCount==sharkSize) { // 먹은 횟수가 크기와 같으면
				eatCount=0; // 먹은 횟수 0으로 초기화
				sharkSize++; // 상어 크기 증가
			}
		}
		System.out.println(time); //마지막 시간 출력
	}
}