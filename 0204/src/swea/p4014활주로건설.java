package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p4014활주로건설 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		for(int t=1; t<=testcase; t++) {
			st= new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int[][] grid= new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ans  =0;
			boolean[][] built = new boolean[N][N];
			for(int i=0; i<N; i++) {
				boolean possible = true;
				for(int j=1; j<N; j++) {
					if(grid[i][j]>grid[i][j-1]) {
						int dist = (grid[i][j] - grid[i][j-1])*X;
						if(!(j-dist>=0&&grid[i][j-dist]==grid[i][j-1])) {
							possible = false;
							break;
						} else {
							boolean flag = true;
							
							for(int k=j-dist; k<=j-1; k++) {
								flag &= !built[i][k];
							}
							if(!flag) {
								possible = false;
								break;
							}
							for(int k=j-dist; k<=j-1; k++) {
								built[i][k] = true;
							}
						}
					} if (grid[i][j]<grid[i][j-1]) {
						int dist = (grid[i][j-1] - grid[i][j])*X;
						if(!(j+dist-1<N&&grid[i][j+dist-1]==grid[i][j])) {
							possible = false;
							break;
						} else {
							boolean flag = true;
							for(int k=j; k<=j+dist-1; k++) {
								flag &= !built[i][k];
							}
							if(!flag) {
								possible = false;
								break;
							}
							for(int k=j; k<=j+dist-1; k++) {
								built[i][k] = true;
							}
						}
					}
				}
				if(possible)
					ans ++;
			}
			built = new boolean[N][N];
			for(int j=0; j<N; j++) {
				boolean possible = true;
				for(int i=1; i<N; i++) {
					if(grid[i][j]>grid[i-1][j]) {
						int dist = (grid[i][j] - grid[i-1][j])*X;
						if(!(i-dist>=0&&grid[i-dist][j]==grid[i-1][j])) {
							possible = false;
							break;
						} else {
							boolean flag = true;
							
							for(int k=i-dist; k<=i-1; k++) {
								flag &= !built[k][j];
							}
							if(!flag) {
								possible = false;
								break;
							}
							for(int k=i-dist; k<=i-1; k++) {
								built[k][j] = true;
							}
						}
					} if (grid[i][j]<grid[i-1][j]) {
						int dist = (grid[i-1][j] - grid[i][j])*X;
						if(!(i+dist-1<N&&grid[i+dist-1][j]==grid[i][j])) {
							possible = false;
							break;
						} else {
							boolean flag = true;
							for(int k=i; k<=i+dist-1; k++) {
								flag &= !built[k][j];
							}
							if(!flag) {
								possible = false;
								break;
							}
							for(int k=i; k<=i+dist-1; k++) {
								built[k][j] = true;
							}
						}
					}
				}
				if(possible)
					ans ++;
			}
			System.out.println("#"+t+" "+ans);
		}
	}
}
