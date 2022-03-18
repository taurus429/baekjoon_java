package baekjoon.silver.s1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class p128521로만들기2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] num = new int[n + 1][2];
		boolean[] visited = new boolean[n + 1];

		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { n, 0 });
		num[n] = new int[] { -1, 0 };
		visited[n] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curnum = cur[0];
			int curcnt = cur[1];
			if (curnum == 1) {
				break;
			}

			if (curnum % 3 == 0 && !visited[curnum / 3]) {
				visited[curnum / 3] = true;
				num[curnum / 3] = new int[] { curnum, curcnt + 1 };
				queue.offer(new int[] { curnum / 3, curcnt + 1 });
			}
			if (curnum % 2 == 0 && !visited[curnum / 2]) {
				visited[curnum / 2] = true;
				num[curnum / 2] = new int[] { curnum, curcnt + 1 };
				queue.offer(new int[] { curnum / 2, curcnt + 1 });
			}
			if (curnum > 1 && !visited[curnum - 1]) {
				visited[curnum - 1] = true;
				num[curnum - 1] = new int[] { curnum, curcnt + 1 };
				queue.offer(new int[] { curnum - 1, curcnt + 1 });
			}
		}
		Stack<Integer> ans = new Stack<>();
		int temp = 1;
		ans.push(temp);
		while(temp!=n) {
			temp = num[temp][0];
			ans.push(temp);
		}
		StringBuilder sb = new StringBuilder();
		while(!ans.isEmpty()) {
			sb.append(ans.pop()+" ");
		}
		System.out.println(num[1][1]);
		System.out.println(sb);
	}
}
