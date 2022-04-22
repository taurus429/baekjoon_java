package baekjoon.gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class p5213과외맨 {
	static int[] dx = new int[] {-1, 0, 0, 1};
	static int[] dy = new int[] {0, 1, -1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int grid[][][] = new int[N][2*N][2];
		int from[] = new int[N*N-N/2];
		for(int i=0; i<N*N-N/2; i++) {
			st = new StringTokenizer(br.readLine());
			if(i%(2*N-1)<N) {
				grid[i/(2*N-1)*2][i%(2*N-1)*2][0] = Integer.parseInt(st.nextToken());
				grid[i/(2*N-1)*2][i%(2*N-1)*2+1][0] = Integer.parseInt(st.nextToken());
				grid[i/(2*N-1)*2][i%(2*N-1)*2][1] = i;
				grid[i/(2*N-1)*2][i%(2*N-1)*2+1][1] = i;
			} else {
				grid[i/(2*N-1)*2+1][(i%(2*N-1)-N)*2+1][0] = Integer.parseInt(st.nextToken());
				grid[i/(2*N-1)*2+1][(i%(2*N-1)-N)*2+2][0] = Integer.parseInt(st.nextToken());
				grid[i/(2*N-1)*2+1][(i%(2*N-1)-N)*2+1][1] = i;
				grid[i/(2*N-1)*2+1][(i%(2*N-1)-N)*2+2][1] = i;
			}
		}
		boolean[] visited = new boolean[N*N-N/2];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(0);
		visited[0] = true;
		int last = 0;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			int posI = 0;
			int posJ = 0;
			if(cur%(2*N-1)<N) {
				posI = cur/(2*N-1)*2;
				posJ = cur%(2*N-1)*2;
			} else {
				posI = cur/(2*N-1)*2+1;
				posJ = (cur%(2*N-1)-N)*2+1;
			}
			for(int i=0; i<3; i++) {
				int ni = posI + dy[i];
				int nj = posJ + dx[i];
				if(0<=ni&&ni<N&&0<=nj&&nj<2*N&&grid[ni][nj][0]==grid[posI][posJ][0]&&!visited[grid[ni][nj][1]]) {
					visited[grid[ni][nj][1]]=true;
					queue.offer(grid[ni][nj][1]);
					from[grid[ni][nj][1]] = cur;
					last = Math.max(last, grid[ni][nj][1]);
				}
			}
			for(int i=1; i<4; i++) {
				int ni = posI + dy[i];
				int nj = posJ+1 + dx[i];
				if(0<=ni&&ni<N&&0<=nj&&nj<2*N&&grid[ni][nj][0]==grid[posI][posJ+1][0]&&!visited[grid[ni][nj][1]]) {
					visited[grid[ni][nj][1]]=true;
					queue.offer(grid[ni][nj][1]);
					from[grid[ni][nj][1]] = cur;
					last = Math.max(last, grid[ni][nj][1]);
				}
			}
		}
		Stack<Integer> stack = new Stack<>();
		while(last!=0) {
			stack.push(last);
			last = from[last];
		}
		stack.push(0);
		System.out.println(stack.size());
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop()+1).append(" ");
		}
		System.out.println(sb);
	}
}
