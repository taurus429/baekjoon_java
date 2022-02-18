package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15649 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[n+1];
		int[] answer = new int[m];
		permutate(visited, 0, answer);
		
	}
	static void permutate(boolean[] visited, int index, int[] answer) {
		if(index == answer.length) {
			for(int i: answer) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1; i<visited.length; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				answer[index] = i;
				permutate(visited, index+1, answer);
				visited[i] = false;
			}
		}
	}
}
