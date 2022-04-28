package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p12931두배더하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		while (true) {
			for (int i = 0; i < N; i++) {
				if (array[i] % 2 == 1) {
					array[i] -= 1;
					cnt++;
				}
			}
			boolean zero = true;
			for (int i = 0; i < N; i++) {
				if (array[i] != 0) {
					zero = false;
				}
				array[i] /= 2;
			}
			if (!zero)
				cnt++;
			else
				break;
		}
		System.out.println(cnt);
	}
}
