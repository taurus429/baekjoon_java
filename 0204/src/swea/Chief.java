package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chief {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean[] isSelected;
	static int N;
	static int[][] S;
	static int min = Integer.MAX_VALUE;
	static void sub(int cnt, int index) {
		if (cnt == N / 2) {
			int sumA =0;
			int sumB =0;
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					if(isSelected[i]&&isSelected[j]) {
						sumA += (S[i][j]+ S[j][i]);
					}else if(!isSelected[i]&&!isSelected[j]) {
						sumB += (S[i][j]+ S[j][i]);
					}
				}
			}
			int res = Math.abs(sumA-sumB);
			if(min>res) {
				min = res;
			}
		} else {
			if (index < N) {
				isSelected[index] = true;
				sub(cnt + 1, index + 1);
				isSelected[index] = false;
				sub(cnt, index + 1);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			N = Integer.parseInt(br.readLine());
			S = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			isSelected = new boolean[N];
			sub(0, 0);
			System.out.println("#"+t+" "+min);
		}
	}
}
