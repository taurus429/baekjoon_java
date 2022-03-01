package baekjoon.gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class p19236청소년상어 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][][] map;
	static int[] index;
	static int[] di = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dj = new int[] { 0, -1, -1, -1, 0, 1, 1, 1 };
	static void fish() {
		for (int i = 1; i <= 16; i++) {
			if (index[i] == -1)
				continue;
			System.out.println(i + ": " + index[i] / 4 + " " + index[i] % 4);
			int curI = index[i] / 4;
			int curJ = index[i] % 4;
			int moveIdx = (map[curI][curJ][1] + 7) % 8;
			System.out.println((map[index[i] / 4][index[i] % 4][1] + 7) % 8);
			int ni = di[moveIdx] + curI;
			int nj = dj[moveIdx] + curJ;
			while (true) {
				if (ni >= 0 && ni < 4 && nj >= 0 && nj < 4 && map[ni][nj][0] != 0)
					break;
				map[curI][curJ][1] ++;
				moveIdx = (map[curI][curJ][1] + 7) % 8;
				ni = di[moveIdx] + curI;
				nj = dj[moveIdx] + curJ;
			}
			System.out.println(ni + " " + nj);
			int[] temp = map[curI][curJ];
			map[curI][curJ] = map[ni][nj];
			map[ni][nj] = temp;
			index[map[curI][curJ][0]] = curI*4 + curJ;
			index[map[ni][nj][0]] = ni*4 + nj;
		}
	}
	public static void main(String[] args) throws IOException {
		map = new int[4][4][2];
		index = new int[17];

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				map[i][j] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
				index[map[i][j][0]] = i * 4 + j;
				if (i == 0 && j == 0) {
					index[map[i][j][0]] = -1;
					map[i][j][0] = 0;

				}
			}
		}
		System.out.println(Arrays.toString(index));
		fish();
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				System.out.println(Arrays.toString(map[i][j]));
			}
		}
	}
}
