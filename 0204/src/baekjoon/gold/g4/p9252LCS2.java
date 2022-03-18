package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p9252LCS2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		String str1 = br.readLine();
		String str2 = br.readLine();
		int[][] grid = new int[str1.length()+1][str2.length()+1];
		for(int i=0; i<str1.length(); i++) {
			for(int j=0; j<str2.length(); j++) {
				if(str1.charAt(i)==str2.charAt(j)) {
					grid[i+1][j+1] = grid[i][j] +1;
				}else {
					grid[i+1][j+1] = Math.max(grid[i][j+1], grid[i+1][j]);
				}
			}
		}
		int len = grid[str1.length()][str2.length()];
		System.out.println(len);
		char[] ans = new char[len];
		int posI= str1.length();
		int posJ = str2.length();
		while(len!=0) {
			if(grid[posI][posJ]==grid[posI-1][posJ]) {
				posI --;
			} else if(grid[posI][posJ]==grid[posI][posJ-1]) {
				posJ --;
			} else {
				ans[--len] = str1.charAt(posI-1);
				posI--;
				posJ--;
			}
		}
		for(char a: ans) {
			System.out.print(a);
		}
	}
}
