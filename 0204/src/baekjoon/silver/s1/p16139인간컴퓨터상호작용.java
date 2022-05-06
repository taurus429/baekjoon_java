package baekjoon.silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p16139인간컴퓨터상호작용 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String input = br.readLine();
		int[][] sum = new int[26][input.length()+1];
		for(int i=0; i<26; i++) {
			for(int j=0; j<input.length(); j++) {
				if(input.charAt(j)-97==i) {
					sum[i][j+1] = sum[i][j] +1;
				} else {
					sum[i][j+1] = sum[i][j];
				}
			}
		}
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int alpabet = st.nextToken().charAt(0)-97;
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(sum[alpabet][end+1]-sum[alpabet][start]).append("\n");
		}
		System.out.println(sb);
	}
}
