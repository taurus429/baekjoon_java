package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2805 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int M;

	static int treeLength(int[] tree, int height) {
		int res = 0;
		for (int i = 0; i < tree.length; i++) {
			if (tree[i] - height > 0) {
				res += (tree[i] - height);
			}
		}
		return res;
	}

	static int binary(int start, int end, int[] tree) {
		while (start<= end) {
			int mid = (start + end)/2;
			if(treeLength(tree, mid)>=M) {
				start = mid+1;
			}
			else {
				end = mid-1;
			}
		}
		return end;

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] tree = new int[N];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if(tree[i]>max) {
				max= tree[i];
			}
		}
		
		System.out.println(binary(0, max, tree));

	}
}
