package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10974 {
	static boolean[] visited;
	static int[] answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		visited = new boolean[len+1];
		answer = new int[len];
		permutation(0, len);
		
	}
	public static void permutation(int curr, int len) {
		if (curr==len) {
			for(int a: answer) {
				System.out.print(a+ " ");
			}
			System.out.println();
		}
		for(int i=1; i<=len; i++) {
			if(!visited[i]) {
				visited[i] = true;
				answer[curr] = i;
				permutation(curr+1, len);
				visited[i] = false;
			}
		}
	}
}
