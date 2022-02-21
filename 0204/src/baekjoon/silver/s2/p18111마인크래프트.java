package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p18111마인크래프트 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int initBlock = Integer.parseInt(st.nextToken());
		
		int[][]terrain = new int[height][width];
		int minHeight = 256;
		for(int i=0; i<height; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<width; j++) {
				terrain[i][j] = Integer.parseInt(st.nextToken());
				if(terrain[i][j] < minHeight) {
					minHeight = terrain[i][j];
				}
			}
		}
		int minTime = Integer.MAX_VALUE;
		int ansHeight =-1;
		for(int h = minHeight; h<=256; h++) {
			int time =0;
			int block = initBlock;
			for(int i=0; i<height; i++) {
				for(int j=0; j<width; j++) {
					int temp = Math.abs(terrain[i][j] - h);
					if(temp>0) {
						time += 2*temp;
						block += temp;
					}else {
						time -= temp;
						block -= Math.abs(temp);
					}
				}
			}
			if(block>=0) {
				if(minTime>time) {
					minTime = time;
					ansHeight = h;
				}
			}
		}
		System.out.print(minTime+" ");
		System.out.println(ansHeight);
	}
}
