package baekjoon;

import java.util.Scanner;

public class p9663 {
	static boolean[] visited;
	static int n;
	static int[] pos;
	static int ans;
	
	static void queen(int line) {
		if (line == n) {
			ans ++;
			return;
		}
		for (int i = 0; i < n; i++) {
			boolean flag = false;
			if (!visited[i]) {
				for (int j = 0; j < line; j++) {
					if (Math.abs(pos[j] - i) == Math.abs(j - line)) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					pos[line] = i;
					visited[i] = true;
					queen(line + 1);
					visited[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		visited = new boolean[n];
		pos = new int[n];
		queen(0);
		System.out.println(ans);
	}
}
