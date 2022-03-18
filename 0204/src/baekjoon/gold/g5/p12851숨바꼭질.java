package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p12851숨바꼭질 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		if (N == K) {
			System.out.println(0);
			System.out.println(1);
			return;
		}
		boolean[] visited = new boolean[100001];
		Queue<int[]> queue = new LinkedList<int[]>();
		Queue<Integer> nextQueue = new LinkedList<Integer>();

		int[] cnt = new int[100001];
		queue.offer(new int[] { N, 1 });
		visited[N] = true;
		int count = 0;
		while (true) {
			count++;
			while (!queue.isEmpty()) {
				int[] next = queue.poll();
				int[] candidate = new int[] { next[0] - 1, next[0] + 1, next[0] * 2 };
				for (int c : candidate) {
					if (0 <= c && c <= 100000 && !visited[c]) {
						cnt[c] += next[1];
						nextQueue.offer(c);
					}
				}
			}
			if (cnt[K] != 0) {
				System.out.println(count);
				System.out.println(cnt[K]);
				break;
			} else {
				while (!nextQueue.isEmpty()) {
					int n = nextQueue.poll();
					if (!visited[n]) {
						visited[n] = true;
						queue.offer(new int[] { n, cnt[n] });
					}
				}

			}
		}

	}
}
