package baekjoon.gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class p19236청소년상어 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] di = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dj = new int[] { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int sharkeat;
	static int[][][] mapcopy(int [][][]map){
		int[][][] res = new int [4][4][2];
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				res[i][j] = map[i][j].clone();
			}
		}
		return res;
	}
	static void fish(int[][][] map, int index[]) {
		l: for (int i = 1; i <= 16; i++) {
			if (index[i] == -1)
				continue;
			int curI = index[i] / 4;
			int curJ = index[i] % 4;
			int moveIdx = (map[curI][curJ][1] + 7) % 8;
			int ni = di[moveIdx] + curI;
			int nj = dj[moveIdx] + curJ;
			int cnt =0;
			while (true) {
				cnt ++;
				if (ni >= 0 && ni < 4 && nj >= 0 && nj < 4 && map[ni][nj][0] != -1)
					break;
				map[curI][curJ][1] ++;
				moveIdx = (map[curI][curJ][1] + 7) % 8;
				ni = di[moveIdx] + curI;
				nj = dj[moveIdx] + curJ;
				if(cnt ==8) {
					break l;
				}
			}
			int[] temp = map[curI][curJ];
			map[curI][curJ] = map[ni][nj];
			map[ni][nj] = temp;
			index[map[curI][curJ][0]] = curI*4 + curJ;
			index[map[ni][nj][0]] = ni*4 + nj;
		}
	}
	static void shark(int posI, int posJ, int sum, int map[][][], int[] index) {
		sharkeat = Math.max(sum, sharkeat);
		int sharkI = posI;
		int sharkJ = posJ;
		int direction = map[sharkI][sharkJ][1] + 7;
		int ni = sharkI;
		int nj = sharkJ;
		for(int i=0; i<3; i++) {
			ni += di[direction%8];
			nj += dj[direction%8];
			if(0<=ni&&ni<4&&0<=nj&&nj<4&&map[ni][nj][0] != 0) {
				int[][][] copy = mapcopy(map);
				int[] copyIdx = index.clone();
				int eat = map[ni][nj][0];
				copyIdx[map[ni][nj][0]] = -1;
				copy[sharkI][sharkJ][0] = 0;
				copy[ni][nj][0] = -1;
				fish(copy, copyIdx);
				shark(ni, nj, sum+eat, copy, copyIdx);
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		int[][][] map = new int[4][4][2];
		int[] index = new int[17];
		int first = 0;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				map[i][j] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
				index[map[i][j][0]] = i * 4 + j;
				if (i == 0 && j == 0) {
					first = map[i][j][0];
					index[map[i][j][0]] = -1;
					map[i][j][0] = -1;
				}
			}
		}
		fish(map, index);
		shark(0, 0, first, map, index);
		System.out.println(sharkeat);
	}
}
