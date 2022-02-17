package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2804 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		String[] words = br.readLine().split(" ");
		int width = words[0].length();
		int height = words[1].length();
		char[][] grid = new char[height][width];
		int posX = 0;
		int posY = 0;
		label: for(int i=0; i<width; i++) {
			for(int j=0; j<height; j++) {
				if(words[0].charAt(i)==words[1].charAt(j)) {
					posX = j;
					posY = i;
					break label;
				}
			}
		}
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				grid[i][j] = '.';
			}
		}
		for(int i=0; i<width; i++) {
			grid[posX][i] = words[0].charAt(i);
		}
		for(int i=0; i<height; i++) {
			grid[i][posY] = words[1].charAt(i);			
		}
		for(char[] g: grid) {
			for(char c: g) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
}
