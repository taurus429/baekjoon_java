package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p2529부등호 {
	static boolean[] bigger, visited;
	static int K;
	static ArrayList<String> ans = new ArrayList<>();

	static void make(int idx, String input) {
		if (idx == K + 1) {
			ans.add(input);
			return;
		}
		if (idx == 0) {
			for (int i = 0; i < 10; i++) {
				visited[i] = true;
				make(idx + 1, input + i);
				visited[i] = false;
			}
		} else {
			int lastnum = input.charAt(input.length() - 1) - 48;
			if (bigger[idx - 1]) {
				for (int i = 0; i < 10; i++) {
					if (!visited[i] && lastnum < i) {
						visited[i] = true;
						make(idx + 1, input + i);
						visited[i] = false;
					}
				}
			} else {
				for (int i = 0; i < 10; i++) {
					if (!visited[i] && lastnum > i) {
						visited[i] = true;
						make(idx + 1, input + i);
						visited[i] = false;
					}
				}
			}
		}
	}

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
		bigger = new boolean[K];
		visited = new boolean[10];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			if (st.nextToken().equals("<")) {
				bigger[i] = true;
			} else {
				bigger[i] = false;
			}
		}
		make(0, "");
		System.out.println(ans.get(ans.size()-1));
		System.out.println(ans.get(0));
	}
}
