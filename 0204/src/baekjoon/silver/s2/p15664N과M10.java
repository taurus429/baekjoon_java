package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class p15664N과M10 {
	static int N, M;
	static int[][] num;
	static int[] com;
	static StringBuilder sb = new StringBuilder();

	static void combi(int cnt, int idx) {
		if (cnt == M) {
			for(int c: com) {
				sb.append(c).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = idx; i < N; i++) {
			num[i][1]--;
			com[cnt] = num[i][0];
			if (num[i][1] == 0) {
				combi(cnt + 1, i + 1);
				
			} else {
				combi(cnt + 1, i);
			}
			num[i][1]++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		HashMap<Integer, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			if (map.containsKey(input)) {
				map.replace(input, map.get(input) + 1);
			} else {
				map.put(input, 1);
			}
		}
		ArrayList<int[]> temp = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			temp.add(new int[] { entry.getKey(), entry.getValue() });
		}
		Collections.sort(temp, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});
		N = temp.size();
		num = new int[temp.size()][2];
		for (int i = 0; i < temp.size(); i++) {
			num[i] = new int[] { temp.get(i)[0], temp.get(i)[1] };
		}
		com = new int[M];
		combi(0, 0);
		System.out.println(sb);

	}
}
