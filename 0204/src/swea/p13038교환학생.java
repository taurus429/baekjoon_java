package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p13038교환학생 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int tesecase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tesecase; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] day = new int[7];
			st = new StringTokenizer(br.readLine());
			int cnt = 0;
			for (int i = 0; i < 7; i++) {
				day[i] = Integer.parseInt(st.nextToken());
				if (day[i] == 1)
					cnt++;
			}
			int start = -1;
			for (int i = 0; i < 7; i++) {
				if (day[i] == 1) {
					start = i;
					break;
				}
			}
			System.out.println(N/cnt*7);
			System.out.println(N%cnt);
			if (N <= cnt) {
				int dayCnt = 0;
				int end = -1;
				for (int i = 0; i < 7; i++) {
					if (day[i] == 1) {
						dayCnt++;
						if (dayCnt == N) {
							end = i;
							break;
						}
					}
				}
				System.out.println("ANS: " + (end - start+1));
			}

		}
	}
}
