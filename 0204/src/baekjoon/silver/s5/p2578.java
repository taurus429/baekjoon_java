package baekjoon.silver.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2578 {
	static int[][] bingo = new int[5][5];
	static boolean[][] check = new boolean[5][5];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int cnt;
	static void call(int num) {
		for(int i=0; i<5; i++){
			for (int j=0;j<5;j++) {
				if(num == bingo[i][j]) {
					check[i][j] = true;
					return;
				}
			}
		}
	}
	static int cntBingo() {
		int res =0;
		for(int i=0; i<5; i++) {
			if(check[i][0] && check[i][1] && check[i][2] && check[i][3] && check[i][4])
				res ++;
			if(check[0][i] && check[1][i] && check[2][i] && check[3][i] && check[4][i])
				res ++;
		}
		if(check[0][0]&&check[1][1]&&check[2][2]&&check[3][3]&&check[4][4])
			res++;
		if(check[0][4]&&check[1][3]&&check[2][2]&&check[3][1]&&check[4][0])
			res++;
		return res;
	}
	public static void main(String[] args) throws IOException {
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				cnt ++;
				call(Integer.parseInt(st.nextToken()));
				if(cntBingo()>=3) {
					System.out.println(cnt);
					return;
				}
			}
		}
	}
}
