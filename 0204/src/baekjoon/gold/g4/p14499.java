package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p14499 {
	static int height;
	static int width;
	static int posI;
	static int posJ;
	static int[] dice;
	static int[][] map;
	static int[] di = new int[] { 0, 0, -1, 1 };
	static int[] dj = new int[] { 1, -1, 0, 0 };

	static void turnDice(int order) {
		int temp;
		switch (order) {
		case 0:
			temp = dice[0];
			dice[0] = dice[2];
			dice[2] = dice[5];
			dice[5] = dice[4];
			dice[4] = temp;
			break;
		case 1:
			temp = dice[0];
			dice[0] = dice[4];
			dice[4] = dice[5];
			dice[5] = dice[2];
			dice[2] = temp;
			break;
		case 2:
			temp = dice[0];
			dice[0] = dice[3];
			dice[3] = dice[5];
			dice[5] = dice[1];
			dice[1] = temp;
			break;
		case 3:
			temp = dice[0];
			dice[0] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[3];
			dice[3] = temp;
			break;
		default:
			break;
		}
	}

	static int move(int order) {
		int ni = posI + di[order];
		int nj = posJ + dj[order];
		if (ni < 0 || ni >= height || nj < 0 || nj >= width) {
			return -1;
		} else {
			turnDice(order);
			if (map[ni][nj] == 0) {
				map[ni][nj] = dice[5];
			} else {
				dice[5] = map[ni][nj];
				map[ni][nj] = 0;
			}
			posI = ni;
			posJ = nj;
			return dice[0];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		height = Integer.parseInt(input[0]);
		width = Integer.parseInt(input[1]);
		posI = Integer.parseInt(input[2]);
		posJ = Integer.parseInt(input[3]);
		int command = Integer.parseInt(input[4]);
		map = new int[height][width];
		for (int i = 0; i < height; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < width; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		dice = new int[6];
		input = br.readLine().split(" ");
		for (int i = 0; i < command; i++) {
			int res = move(Integer.parseInt(input[i]) - 1);
			if (res != -1)
				System.out.println(res);

		}
	}
}
