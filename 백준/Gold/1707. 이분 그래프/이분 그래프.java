import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());
			int[] visited = new int[node];
			Arrays.fill(visited, -1);
			ArrayList<Integer>[] adj = new ArrayList[node];
			for (int i = 0; i < node; i++) {
				adj[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < edge; i++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken()) - 1;
				int n2 = Integer.parseInt(st.nextToken()) - 1;
				adj[n1].add(n2);
				adj[n2].add(n1);
			}
			Queue<int[]> queue = new LinkedList<int[]>();
			boolean flag = true;
			for (int i = 0; i < node; i++) {
				if (visited[i] == -1) {
					queue.add(new int[] { i, 0 });
					visited[i] = 1;
					while (!queue.isEmpty()) {
						int[] cur = queue.poll();
						for (int n : adj[cur[0]]) {
							if (visited[n] == -1) {
								visited[n] = cur[1] % 2;
								queue.offer(new int[] { n, cur[1] + 1 });
							} else {
								if (visited[n] != cur[1] % 2) {
									flag = false;
								}
							}
						}
					}
				}
			}
			if (flag) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}