package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2961 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N= Integer.parseInt(br.readLine());
		int[][] ing = new int [N][2];
		for(int i=0; i<N; i++) {
			String[] input = br.readLine().split(" ");
			ing[i][0] = Integer.parseInt(input[0]);
			ing[i][1] = Integer.parseInt(input[1]);
		}
		int bit = (int)Math.pow(2, N);
		int bitter;
		int sour;
		int ans = Integer.MAX_VALUE;
		for(int i=1; i<bit; i++) {
			bitter = 0;
			sour = 1;
			for(int j=0; j<N; j++) {
				if((i&1<<j)!=0) {
					sour*=ing[j][0];
					bitter += ing[j][1];
				}
			}
			if(ans>Math.abs(sour-bitter)) {
				ans = Math.abs(sour - bitter);
			}
		}
		System.out.println(ans);
	}
}
