package baekjoon.silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p16948데스나이트 {
	static int[] dy = new int[] {-2, -2, 0, 0, 2, 2};
	static int[] dx = new int[] {-1, 1, -2, 2, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int startI = Integer.parseInt(st.nextToken());
		int startJ = Integer.parseInt(st.nextToken());
		int endI = Integer.parseInt(st.nextToken());
		int endJ = Integer.parseInt(st.nextToken());
		boolean[][] visited= new boolean[N][N];
		visited[startI][startJ] = true;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {startI, startJ, 0});
		int ans = -1;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			if(cur[0]==endI&&cur[1]==endJ) {
				ans = cur[2];
				break;
			}
			for(int i=0; i<6; i++) {
				int ni= cur[0]+dy[i];
				int nj =cur[1]+dx[i];
				if(0<=ni&&ni<N&&0<=nj&&nj<N&&!visited[ni][nj]) {
					visited[ni][nj] = true;
					queue.offer(new int[] {ni, nj, cur[2]+1});
				}
			}
		}
		System.out.println(ans);
	}
}
