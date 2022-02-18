package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p15683 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] di = new int[] { -1, 0, 1, 0 };// 북동남서 순
	static int[] dj = new int[] { 0, 1, 0, -1 };
	static int height;
	static int width;
	static int min = Integer.MAX_VALUE;
	static int[][] grid;

	static void cctv1(int posI, int posJ, int direction) {
		int ni = posI + di[direction];
		int nj = posJ + dj[direction];
		while (ni >= 0 && ni < height && nj >= 0 && nj < width && grid[ni][nj] != -1) {
			grid[ni][nj] += 1;
			ni += di[direction];
			nj += dj[direction];
		}
	}

	static void reset1(int posI, int posJ, int direction) {
		int ni = posI + di[direction];
		int nj = posJ + dj[direction];
		while (ni >= 0 && ni < height && nj >= 0 && nj < width && grid[ni][nj] != -1) {
			grid[ni][nj] -= 1;
			ni += di[direction];
			nj += dj[direction];
		}
	}

	static void cctv2(int posI, int posJ, int direction) {
		if (direction == 0) {
			cctv1(posI, posJ, 0);
			cctv1(posI, posJ, 2);
		} else {
			cctv1(posI, posJ, 1);
			cctv1(posI, posJ, 3);
		}
	}
	static void reset2(int posI, int posJ, int direction) {
		if (direction == 0) {
			reset1(posI, posJ, 0);
			reset1(posI, posJ, 2);
		} else {
			reset1(posI, posJ, 1);
			reset1(posI, posJ, 3);
		}
	}
	static void cctv3(int posI, int posJ, int direction) {
		cctv1(posI, posJ, direction);
		cctv1(posI, posJ, (direction + 1) % 4);
	}
	static void reset3(int posI, int posJ, int direction) {
		reset1(posI, posJ, direction);
		reset1(posI, posJ, (direction + 1) % 4);
	}

	static void cctv4(int posI, int posJ, int direction) {
		cctv1(posI, posJ, direction);
		cctv1(posI, posJ, (direction + 1) % 4);
		cctv1(posI, posJ, (direction + 2) % 4);
	}
	static void reset4(int posI, int posJ, int direction) {
		reset1(posI, posJ, direction);
		reset1(posI, posJ, (direction + 1) % 4);
		reset1(posI, posJ, (direction + 2) % 4);
	}

	static void cctv5(int posI, int posJ) {
		for (int i = 0; i < 4; i++) {
			cctv1(posI, posJ, i);
		}
	}
	static void reset5(int posI, int posJ) {
		for (int i = 0; i < 4; i++) {
			reset1(posI, posJ, i);
		}
	}

	static void set(ArrayList<int[]> cctv, int idx) {
		if(idx == cctv.size()) {
			int cnt =0;
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
//					System.out.printf("%3d", grid[i][j]);
					if(grid[i][j] == 0) {
						cnt ++;
					}
				}
//				System.out.println();
			}
//			System.out.println(); 
			if (cnt < min) {
				min = cnt;
			}
			return;
		}else {
			int[] curr = cctv.get(idx);
			switch (curr[0]) {
			case 1:
				for(int i=0; i<4; i++) {
					cctv1(curr[1], curr[2], i);
					set(cctv, idx+1);
					reset1(curr[1], curr[2], i);
				}
				break;
			case 2:
				for(int i=0; i<2; i++) {
					cctv2(curr[1], curr[2], i);
					set(cctv, idx+1);
					reset2(curr[1], curr[2], i);
				}
				break;
			case 3:
				for(int i=0; i<4; i++) {
					cctv3(curr[1], curr[2], i);
					set(cctv, idx+1);
					reset3(curr[1], curr[2], i);
				}
				break;
				
			case 4:
				for(int i=0; i<4; i++) {
					cctv4(curr[1], curr[2], i);
					set(cctv, idx+1);
					reset4(curr[1], curr[2], i);
				}
				break;
				
			case 5:
				cctv5(curr[1], curr[2]);
				set(cctv, idx+1);
				reset5(curr[1], curr[2]);
				break;
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		height = Integer.parseInt(input[0]);
		width = Integer.parseInt(input[1]);
		grid = new int[height][width];
		ArrayList<int[]> cctv = new ArrayList<>();
		for (int i = 0; i < height; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < width; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 6) {
					grid[i][j] = -1;
				} else {
					grid[i][j] = temp;
				}
				if (temp >= 1 && temp < 6) {
					cctv.add(new int[] { temp, i, j });
				}
			}
		}
		set(cctv, 0);
		System.out.println(min);
	}
}
