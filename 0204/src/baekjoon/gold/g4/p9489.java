package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p9489 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		int[] node;
		int n;
		int k;
		input = br.readLine().split(" ");
		while (!input[0].equals("0") && !input[1].equals("0")) {
			n = Integer.parseInt(input[0]);
			k = Integer.parseInt(input[1]);
			input = br.readLine().split(" ");
			node = new int[n+1];
			int[] parent = new int[n+1];
			parent[0] = -1;
			parent[1] = 0;
			int target=-1;
			for(int i=1; i<=n; i++) {
				node[i] = Integer.parseInt(input[i-1]);
				if (node[i] == k) {
					target = i;
				}
			}
			int index =1;
			for(int i=2; i<=n; i++) {
				parent[i] = index;
				if(i!=n&&node[i+1]-node[i]!=1) {
					index++;
				}
			}
			int cnt = 0;
			for(int i=1; i<=n; i++) {
				if(parent[parent[i]]==parent[parent[target]]&&parent[i]!=parent[target]) {
					cnt ++;
				}
			}
			System.out.println(cnt);
			input = br.readLine().split(" ");
		}
	}
}
