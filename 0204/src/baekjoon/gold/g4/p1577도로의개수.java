package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1577도로의개수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] dx = new int[] {0, -1};
	static int[] dy = new int[] {-1, 0};
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int width = Integer.parseInt(st.nextToken())+1;
		int height = Integer.parseInt(st.nextToken())+1;
		int len = Integer.parseInt(br.readLine());
		int[][] block = new int[len][4];
		for(int i=0; i<len; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if(a<c) {
				int temp = a;
				a = c;
				c = temp;
			} else if(b<d){
				int temp = b;
				b = d;
				d = temp;
			}
			block[i] = new int[] {b, a, d, c};
		}
		long[][] path = new long[height][width];
		path[0][0] = 1;
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				for(int k=0 ; k<2; k++) {
					int ni = i + dx[k];
					int nj = j + dy[k];
					if(0<=ni&&0<=nj) {
						boolean flag = true;
						for(int[] b: block) {
							if(b[0]==i&&b[1]==j&&b[2]==ni&&b[3]==nj) {
								flag = false;
								break;
							}
						}
						if(flag)
						path[i][j] += path[ni][nj];
					}
				}
			}
		}
		
		System.out.println(path[height-1][width-1]);
		
	}
}
