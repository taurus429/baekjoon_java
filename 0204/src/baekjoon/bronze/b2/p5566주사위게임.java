package baekjoon.bronze.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p5566주사위게임 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] pos = new int[N];
		for(int i=0; i<N; i++) {
			pos[i] = Integer.parseInt(br.readLine());
		}
		int cur = 0;
		int cnt =0;
		while(cur<N-1) {
			int dice = Integer.parseInt(br.readLine());
			cur += dice;
			if(cur<N-1)
			cur += pos[cur];
			cnt ++;
		}
		System.out.println(cnt);
	}
}
