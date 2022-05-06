package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p1141접두사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		for(int i=0; i<N; i++) {
			words[i] = br.readLine();
		}
		if(N==1) {
			System.out.println(1);
			return;
		}
		Arrays.sort(words);
		int before = 0;
		int after = 1;
		int res = N;
		while(after<N) {
			if(words[after].startsWith(words[before])) {
				res --;
				before ++;
				after ++;
			} else {
				before = after;
				after+=1;
			}
		}
		System.out.println(res);
	}
}
