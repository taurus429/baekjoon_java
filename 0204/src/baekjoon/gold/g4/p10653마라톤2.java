package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p10653마라톤2 {
	static int[] combiRes;
	static int K, N, min;
	static int[][] points;
	static void checkDist() {
		boolean[] pass = new boolean[N];
		for(int c: combiRes) {
			pass[c] = true;
		}
		ArrayList<Integer> route = new ArrayList<>();
		for(int i=1; i<N; i++) {
			if(!pass[i]) {
				route.add(i);
			}
		}
		int dist = 0;
		int before = 0;
		for(int r: route) {
			dist += Math.abs(points[before][0] - points[r][0]) + Math.abs(points[before][1] - points[r][1]);
			if(dist>min)
				return;
			before = r;
		}
		min = Math.min(min, dist);
	}
	static void combi(int index, int count) {
		if(count==K) {
			checkDist();
		} else {
			for(int i=index; i<N-1; i++) {
				combiRes[count] = i;
				combi(i+1, count+1);
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		points = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int posI = Integer.parseInt(st.nextToken());
			int posJ = Integer.parseInt(st.nextToken());
			points[i] = new int[] {posI, posJ};
		}
		combiRes = new int[K];
		min = Integer.MAX_VALUE;
		combi(1,0);
		System.out.println(min);
	}
}
