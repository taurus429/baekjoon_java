package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class p19238 {

	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int N;

	static int[] bfsGuest(int x, int y, int[][] map) {
		queue.clear();
		boolean[][] visited = new boolean[N][N];
		queue.add(new int[] { x, y, 0 });
		visited[y][x] = true;
		int minMove = Integer.MAX_VALUE;
		int[] minCurrent=null;

		while (queue.size() != 0) {
			int[] current = queue.poll();
			if (map[current[1]][current[0]] == 2) {
				if (current[2] <= minMove) {
					minMove = current[2];
					if(minCurrent==null) {
						minCurrent = current;
					}else {
						if(current[2]<minCurrent[2]) {
							minCurrent = current;
						}else if(current[2] == minCurrent[2]) {
							if(current[1]<minCurrent[1]) {
								minCurrent = current;
							}
						}
					}
				} else {
					break;
				}
			}
			for (int i = 0; i < 4; i++) {
				int nx = current[0] + dx[i];
				int ny = current[1] + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[ny][nx] == 1 || visited[ny][nx]) {
					continue;
				} else {
					queue.add(new int[] { nx, ny, current[2] + 1 });
					visited[ny][nx] = true;
				}
			}
		}
		if (minCurrent == null) {
			return new int[] { -1, -1, Integer.MAX_VALUE };
		} else {
			map[minCurrent[1]][minCurrent[0]] = 0;
			return minCurrent;
		}
	}

	static int route(int srcX, int srcY, int destX, int destY, int[][] map) {
		queue.clear();
		boolean[][] visited = new boolean[N][N];
		queue.add(new int[] { srcX, srcY, 0 });
		visited[srcY][srcX] = true;
		while (queue.size() != 0) {
			int[] current = queue.poll();
			if (current[0] == destX && current[1] == destY) {
				return current[2];
			}
			for (int i = 0; i < 4; i++) {
				int nx = current[0] + dx[i];
				int ny = current[1] + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[ny][nx] == 1 || visited[ny][nx]) {
					continue;
				} else {
					queue.add(new int[] { nx, ny, current[2] + 1 });
					visited[ny][nx] = true;
				}
			}
		}
		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		int customerCnt = Integer.parseInt(input[1]);
		int fuel = Integer.parseInt(input[2]);

		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				if (line[j].equals("1")) {
					map[i][j] = 1;
				}
			}
		}

		input = br.readLine().split(" ");
		int startY = Integer.parseInt(input[0]) - 1;
		int startX = Integer.parseInt(input[1]) - 1;

		ArrayList<int[]> customer = new ArrayList<int[]>();
		for (int i = 0; i < customerCnt; i++) {
			input = br.readLine().split(" ");
			int srcY = Integer.parseInt(input[0]) - 1;
			int srcX = Integer.parseInt(input[1]) - 1;
			int destY = Integer.parseInt(input[2]) - 1;
			int destX = Integer.parseInt(input[3]) - 1;
			customer.add(new int[] { srcX, srcY, destX, destY });
			map[srcY][srcX] = 2;
		}
		int[] custDirect = null;
		int[] custPos;
		boolean failed = false;
		while (customer.size() != 0) {
			custPos = bfsGuest(startX, startY, map);//승객 위치 리턴
			System.out.println(Arrays.toString(custPos));
			if (custPos[2] > fuel) {//승객한테 갈 수 없을 떄
				failed = true;
				break;
			} else {
				fuel -= custPos[2];//연료소모
			}
			for (int[] c : customer) {//승객 목적지 찾기
				if (c[0] == custPos[0] && c[1] == custPos[1]) {
					custDirect = c;
					break;
				}
			}
			//승객 도착지까지 거리
			int len = route(custDirect[0], custDirect[1], custDirect[2], custDirect[3], map);
			if (len > fuel) { // 무한 or 연료 모자랄 때
				failed = true;
				break;
			} else { // 아니면 연료 충전
				fuel += len;
			}
			startX = custDirect[2];// 택시 위치 이동
			startY = custDirect[3];
			// 손님삭제
			customer.remove(custDirect);
		}
		if (!failed) {
			System.out.println(fuel);
		} else {
			System.out.println(-1);
		}

	}
}
