package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2669 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] paper = new int[100][100];
	
	static void color(int posI, int posJ, int height, int width) {
		for(int i=posI; i<posI+height; i++) {
			for(int j=posJ; j<posJ+width; j++) {
				paper[i][j] = 1;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		for(int t=0; t<4; t++) {
			String[] input = br.readLine().split(" ");
			int posI = Integer.parseInt(input[0]);
			int posJ = Integer.parseInt(input[1]);
			int height = Integer.parseInt(input[2]) - Integer.parseInt(input[0]);
			int width = Integer.parseInt(input[3]) - Integer.parseInt(input[1]);
			color(posI, posJ, height, width);
		}
		int sum = 0;
		for(int i=0; i<100; i++) {
			for(int j=0 ;j<100; j++) {
				sum += paper[i][j];
			}
		}
		System.out.println(sum);
	}
}
