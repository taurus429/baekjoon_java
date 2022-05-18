package baekjoon.bronze.b3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p3034앵그리창영 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		double max = Math.sqrt(Math.pow(H, 2)+Math.pow(W, 2));
		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i<N; i++) {
			if(Integer.parseInt(br.readLine())<=max) {
				sb.append("DA").append("\n");
			}else {
				sb.append("NE").append("\n");
			}
		}
		System.out.println(sb);
	}
}
