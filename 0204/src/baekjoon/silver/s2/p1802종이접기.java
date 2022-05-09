package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1802종이접기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String paper = br.readLine();
			int M = (int)(Math.log(paper.length()+1)/Math.log(2));
			boolean answer = true;
			l: for(int j=0; j<M; j++) {
				int interval = (int)Math.pow(2, j);
				for(int k=3*interval-1; k<paper.length(); k+=2*interval) {
					if(paper.charAt(k)==paper.charAt(k-2*interval)) {
						answer = false;
						break l;
					}
				}
			}
			if(answer) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}
		}
		System.out.println(sb);
	}
}
