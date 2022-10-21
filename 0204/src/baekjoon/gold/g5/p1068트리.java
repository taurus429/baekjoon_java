package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p1068트리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] tree = new int[N];
		for(int i=0; i<N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		int removeNode = Integer.parseInt(br.readLine());
		boolean[] isParent = new boolean[N];
		for(int i=0; i<N; i++) {
			if(tree[i]>=0) {
				isParent[tree[i]] = true;
			}
		}
		int count =0;
		for(int i=0; i<N; i++) {
			if(!isParent[i])
				count++;
		}
		for(int i=0; i<N; i++) {
			int idx = i;
			if(!isParent[i]) {
				while(idx!=-1) {
					if(idx == removeNode) {
						count --;
						break;
					}
					idx = tree[idx];
				}
			}
		}
		System.out.println(count);
	}
}
