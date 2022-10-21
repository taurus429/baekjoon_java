package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class p14226이모티콘 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 1, -1, 0 });
		boolean visited[][] = new boolean[2002][2002];
		int max = 2000;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			if(visited[cur[0]][cur[1]+1])
				continue;
			visited[cur[0]][cur[1]+1] = true;
			if (cur[1] != -1 && cur[0] + cur[1] <= max) {
				queue.offer(new int[] { cur[0] + cur[1], cur[1], cur[2] + 1 });
			}
			if (cur[0] != cur[1]) {
				queue.offer(new int[] { cur[0], cur[0], cur[2] + 1 });
			}
			if (cur[0] >= 1) {
				queue.offer(new int[] { cur[0] - 1, cur[1], cur[2] + 1 });
			}
			if (cur[0] == N) {
				System.out.println(cur[2]);
				return;
			}
		}
	}
}