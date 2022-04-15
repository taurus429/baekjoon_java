package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p20055컨베이어벨트위의로봇 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] robot = new boolean[2 * N];
		int[] belt = new int[2 * N];
		st = new StringTokenizer(br.readLine());
		int zeroCount = 0;
		for (int i = 0; i < 2 * N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
			if(belt[i]==0) {
				zeroCount++;
			}
		}
		int start = 0;
		int end = N - 1;
		Queue<Integer> queue = new LinkedList<Integer>();
		int cnt = 0;
		while (true) {
			cnt ++;
			start = (start - 1 + 2 * N) % (2 * N);
			end = (end - 1 + 2 * N) % (2 * N);
			if (robot[end]) {
				robot[end] = false;
				queue.poll();
			}
			Queue<Integer> temp = new LinkedList<>();
			while (!queue.isEmpty()) {
				int cur = queue.poll();
				int next = (cur + 1) % (2 * N);
				if (belt[next] != 0 && !robot[next]) {
					belt[next]--;
					if(belt[next]==0) {
						zeroCount++;
					}
					robot[cur] = false;
					if (next != end) {
						robot[next] = true;
						temp.offer(next);
					}
				} else {
					temp.offer(cur);
				}
			}
			queue = temp;
			if(belt[start]!=0) {
				belt[start] --;
				if(belt[start]==0) {
					zeroCount++;
				}
				queue.offer(start);
				robot[start]=true;
			}
			if(zeroCount>=K)
				break;
		}
		System.out.println(cnt);
	}
}
