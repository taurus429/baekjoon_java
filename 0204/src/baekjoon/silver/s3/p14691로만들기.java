package baekjoon.silver.s3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class p14691로만들기 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int X = scan.nextInt();
		int[] dp = new int[X+1];
		boolean[] visited = new boolean[X+1];
		dp[X] = 0;
		visited[X] = true;
		int idx = 1;
		while(true) {
			ArrayList<Integer> temp = new ArrayList<>();
			for(int i=0; i<X+1; i++) {
				if(dp[i]==idx-1&&visited[i]) {
					if(i%3==0) {
						temp.add(i/3);
					}
					if(i%2==0) {
						temp.add(i/2);
					}
					temp.add(i-1);
				}
			}
			for(int t: temp) {
				visited[t] = true;
				dp[t] = idx;
			}
			if(visited[1])
				break;
			idx ++;
		}
		System.out.println(dp[1]);
	}
}
