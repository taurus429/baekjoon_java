package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p14891톱니바퀴 {
	static boolean[][] wheel;
	static boolean[] visited;
	static void turn(int idx, boolean right) {
		if(idx-1>=0&&wheel[idx][6]^wheel[idx-1][2]&&!visited[idx-1]) {//왼쪽 붙었을때
			visited[idx-1] = true;
			turn(idx-1, !right);
		}
		if(idx+1<4&&wheel[idx][2]^wheel[idx+1][6]&&!visited[idx+1]) {//오른쪽 붙었을 때
			visited[idx+1] = true;
			turn(idx+1, !right);
		}
		if(right) {//우회전
			boolean temp = wheel[idx][7];
			for(int i=6; i>=0; i--) {
				wheel[idx][i+1] = wheel[idx][i];
			}
			wheel[idx][0] = temp;
		} else {//좌회전
			boolean temp = wheel[idx][0];
			for(int i=0; i<7; i++) {
				wheel[idx][i] = wheel[idx][i+1];
			}
			wheel[idx][7] = temp;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
			wheel = new boolean[4][8];
			for(int i=0; i<4; i++) {
				String line = br.readLine();
				for(int j=0; j<8; j++) {
					if(line.charAt(j)=='1') {
						wheel[i][j] = true;
					}
				}
			}
			int K = Integer.parseInt(br.readLine());
			for(int i=0; i<K; i++) {
				st= new StringTokenizer(br.readLine());
				visited = new boolean[4];
				int idx = Integer.parseInt(st.nextToken())-1;
				boolean right;
				if(Integer.parseInt(st.nextToken())==1) {
					right = true;
				} else {
					right =false;
				}
				visited[idx] = true;
				turn(idx, right);
			}
			int ans = 0;
			for(int j=0; j<4; j++) {
				if(wheel[j][0]) {
					ans += (int) Math.pow(2, j);
				}
			}
			System.out.println(+ans);
	}
}
