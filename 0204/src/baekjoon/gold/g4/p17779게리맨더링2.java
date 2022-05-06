package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p17779게리맨더링2 {
	static int[][] grid;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		grid = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int d1 = 1; d1<N; d1++) {
					for(int d2 = 1; d2<N; d2++) {
						if(j+d1+d2>=N) continue;
						if(i-d1<0||i+d2>=N)continue;
						int[] sum = new int[5];
						int[][] grid2 = new int[N][N];
						for(int y=0; y<N; y++) {
							for(int x=0; x<N; x++) {
								if(i+j<=x+y&&x+y<=i+j+2*d2&&i-j-2*d1<=y-x&&y-x<=i-j) {
									sum[4] += grid[y][x];
									grid2[y][x] = 5;
								} else if(x<=j+d1&&y<i) {
									sum[0] += grid[y][x];
									grid2[y][x] = 1;
								} else if(y<=i-d1+d2&&x>i-d1) {
									sum[1] += grid[y][x];
									grid2[y][x] = 2;
								} else if(y>i-d1+d2&&x>=j+d2) {
									sum[2] += grid[y][x];
									grid2[y][x] = 4;
								} else {
									sum[3] += grid[y][x];
									grid2[y][x] = 3;
								}
							}
						}
						Arrays.sort(sum);
						ans = Math.min(ans, sum[4] - sum[0]);
					}
				}
			}
		}
		System.out.println(ans);
	}
}