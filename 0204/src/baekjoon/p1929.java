package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1929 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int m = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);
		boolean[] prime = new boolean[n+1];
		int end = (int)Math.ceil(Math.sqrt((double)n));
		int k = 2;
		for(int i=2; i<=end; i++) {
			while(i*k<=n) {
				prime[i*k] = true;
				k++;
			}
			k=2;
		}
		prime[1] = true;
		for(int i=m; i<=n; i++) {
			if(!prime[i]) {
				System.out.println(i);
			}
		}
	}
}
