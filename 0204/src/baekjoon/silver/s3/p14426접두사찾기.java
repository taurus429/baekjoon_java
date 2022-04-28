package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p14426접두사찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] S = new String[N];
		String[] prefix = new String[M];
		for (int i = 0; i < N; i++) {
			S[i] = br.readLine();
		}
		for (int i = 0; i < M; i++) {
			prefix[i] = br.readLine();
		}
		Arrays.sort(S);
		Arrays.sort(prefix);
		int SIdx = 0;
		int preIdx = 0;
		int cnt = 0;
		while (SIdx < N && preIdx < M) {
			if (prefix[preIdx].compareTo(S[SIdx]) <= 0) {
				if (S[SIdx].startsWith(prefix[preIdx])) {
					cnt++;
				}
				preIdx++;
			} else {
				SIdx++;
			}
		}
		System.out.println(cnt);
	}
}
