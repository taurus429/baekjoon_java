package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p3040 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] height;
	static boolean[] visited = new boolean[9];
	static int[] p = new int[7];

	static int getSum(int[] p, int[] height) {
		int sum =0;
		for(int i: p) {
			sum += height[i];
		}
		return sum;
	}
	static void combi(int cnt, int index) {
		if(cnt == 7) {
			if(getSum(p, height)==100) {				
				for(int i=0; i<7; i++) {
					System.out.println(height[p[i]]);
				}
			}
			return;
		}
		for(int i=index; i<9; i++) {
			p[cnt] = i;
			combi(cnt+1, i+1);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		height = new int[9];
		for (int i = 0; i < 9; i++) {
			height[i] = Integer.parseInt(br.readLine());
		}
		combi(0, 0);
	}
}
