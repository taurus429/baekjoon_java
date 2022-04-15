package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p15684사다리조작 {
	static boolean[][] ladder;
	static int width, height, min = Integer.MAX_VALUE;
	static ArrayList<int[]> candidate;
	static boolean check() {
		for(int i=0; i<width; i++) {
			int cur = i;
			for(int j=0; j<height; j++) {
				if(cur<width-1&&ladder[j][cur]) {
					cur += 1;
				} else if(cur-1>=0&&ladder[j][cur-1]) {
					cur -= 1;
				}
			}
			if(cur!=i) {
				return false;
			}
		}
		return true;
	}
	static void combi(int idx, int cnt) {
		if(cnt>3) return;
		if(check())
			min = Math.min(min, cnt);
		for(int i=idx; i<candidate.size(); i++) {
			int[] c = candidate.get(i);
			ladder[c[0]][c[1]] = true;
			combi(i+1, cnt+1);
			ladder[c[0]][c[1]] = false;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		width = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		ladder = new boolean[height][width-1];
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			int posI = Integer.parseInt(st.nextToken())-1;
			int posJ = Integer.parseInt(st.nextToken())-1;
			ladder[posI][posJ]=true;
		}
		candidate = new ArrayList<>();
		for(int i=0; i<height; i++) {
			for(int j=0; j<width-1; j++) {
				if(!ladder[i][j]) {
					candidate.add(new int[] {i, j});
				}
			}
		}
		combi(0, 0);
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
	}
}
