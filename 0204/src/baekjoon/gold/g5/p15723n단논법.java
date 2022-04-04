package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15723n단논법 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		boolean[][] truth = new boolean [26][26];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = st.nextToken().charAt(0)-97;
			st.nextToken();
			int end = st.nextToken().charAt(0)-97;
			truth[start][end] = true;
		}
		for(int k=0; k<26; k++) {
			for(int i=0; i<26; i++) {
				for(int j=0; j<26; j++) {
					if(truth[i][k]&&truth[k][j]) {
						truth[i][j] = true;
					}
				}
			}
		}
		int m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = st.nextToken().charAt(0)-97;
			st.nextToken();
			int end = st.nextToken().charAt(0)-97;
			if (truth[start][end]){
				System.out.println("T");
			} else {
				System.out.println("F");
			}
		}
	}
}
