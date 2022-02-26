package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1681해밀턴순환회로 {
	static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] grid;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	static int N;
	static void permutate(int cnt, int from, int sum) {
		if(cnt == N-1) {
			sum += grid[from][0];
			if(grid[from][0]!= 0 && sum<min)
				min = sum;
			return;
		}
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				if(grid[from][i]==0||sum+grid[from][i] > min)
					continue;
				visited[i] = true;
				permutate(cnt+1, i, sum+grid[from][i]);
				visited[i] = false;
			}
		}
	};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		grid = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N];
		visited[0] = true;
		permutate(0, 0, 0);
		System.out.println(min);
	}
}
