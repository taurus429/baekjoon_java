package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p16967 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int moveI = Integer.parseInt(st.nextToken());
		int moveJ = Integer.parseInt(st.nextToken());
		int[][] array= new int[height+moveI][width+moveJ];
		for(int i=0; i<height+moveI; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<width+moveJ; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				if(i-moveI>=0&&j-moveJ>=0) {
					array[i][j] = array[i][j] - array[i-moveI][j-moveJ];
				}
			}
		}
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
}
