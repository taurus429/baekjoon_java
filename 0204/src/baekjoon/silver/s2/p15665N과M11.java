package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class p15665N과M11 {
	static int N, M;
	static Integer[] num;
	static int[] com;
	static StringBuilder sb = new StringBuilder();

	static void combi(int cnt) {
		if (cnt == M) {
			for(int c: com) {
				sb.append(c).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			com[cnt] = num[i];
			combi(cnt+1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		num = set.toArray(new Integer[0]);
		com = new int[M];
		Arrays.sort(num);
		N = num.length;
		combi(0);
		System.out.println(sb);

	}
}
