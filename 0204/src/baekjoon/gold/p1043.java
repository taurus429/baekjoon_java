package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1043 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int party = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int[] truth = new int [Integer.parseInt(st.nextToken())];
		int[] tree= new int[N+party];
		for(int i=0; i<N+party; i++) {
			tree[i] = -1;
		}
		for(int i=0; i<truth.length; i++) {
			truth[i] = Integer.parseInt(st.nextToken())-1;
		}
		for(int i=0; i<party; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int people = Integer.parseInt(st.nextToken());
			for(int j=0; j<people; j++) {
				int man = Integer.parseInt(st.nextToken())-1;
				if(tree[man]==-1) {
					tree[man] = i + N;
				}else {
					tree[tree[man]] = i + N;
				}
			}
		}
		boolean[] dontLie = new boolean[party];
		for(int i=0; i<truth.length; i++) {
			int idx = tree[truth[i]];
			System.out.println(idx);
			dontLie[idx-N] = true;
			while(tree[idx]!=-1) {
				idx = tree[idx];
				dontLie[idx-N] = true;
			}
		}
		System.out.println(Arrays.toString(tree));
		System.out.println(Arrays.toString(dontLie));
	}
}
