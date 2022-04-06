package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class p17281야구 {
	static int[][] score;
	static int[] order;
	static int maxScore;
	static int N;

	static void calScore() {
		int res = 0;
		int inning = 0;
		int idx = 0;
		int out = 0;
		boolean[] base = new boolean[4];
		while (inning < N) {
			int hit = score[inning][order[(idx++) % 9]];
			switch (hit) {
			case 0:
				out++;
				break;
			case 1:
				if(base[3])
					res ++;
				base[3] = base[2];
				base[2] = base[1];
				base[1] = true;
				break;
			case 2:
				if(base[3])
					res ++;
				if(base[2])
					res ++;
				base[3] = base[1];
				base[2] = true;
				base[1] = false;
				break;
			case 3:
				if(base[3])
					res ++;
				if(base[2])
					res++;
				if(base[1])
					res++;
				base[3]=true;
				base[2]=false;
				base[1]=false;
				break;
			case 4:
				if(base[3])
					res ++;
				if(base[2])
					res++;
				if(base[1])
					res++;
				res++;
				base[3]=false;
				base[2]=false;
				base[1]=false;
				
				break;
			default:
				break;
			}
			if (out == 3) {
				inning++;
				out = 0;
				base[3]=false;
				base[2]=false;
				base[1]=false;
			}
		}
		maxScore = Math.max(maxScore, res);
	}

	static void permutate(int cnt, boolean[] visited) {
		if (cnt == 9) {
			calScore();
		}
		if (cnt == 3)
			cnt++;
		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				order[cnt] = i;
				permutate(cnt + 1, visited);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		score = new int[N][9];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[] visited = new boolean[9];
		order = new int[9];
		order[3] = 0;
		visited[0] = true;
		permutate(0, visited);
		System.out.println(maxScore);
	}
}
