package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1991 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static void preOrder(int[][] tree, int root) {
		System.out.print((char) (root+65));
		if(tree[root][0]!=-19) {
			preOrder(tree, tree[root][0]);
		}
		if(tree[root][1]!=-19) {
			preOrder(tree, tree[root][1]);
		}
	}
	static void inOrder(int[][] tree, int root) {
		if(tree[root][0]!=-19) {
			inOrder(tree, tree[root][0]);
		}
		System.out.print((char) (root+65));
		if(tree[root][1]!=-19) {
			inOrder(tree, tree[root][1]);
		}
	}
	static void postOrder(int[][] tree, int root) {
		if(tree[root][0]!=-19) {
			postOrder(tree, tree[root][0]);
		}
		if(tree[root][1]!=-19) {
			postOrder(tree, tree[root][1]);
		}
		System.out.print((char) (root+65));
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] tree = new int[26][];
		for(int i=0 ; i<N; i++) {
			String[] input = br.readLine().split(" ");
			tree[(int)input[0].charAt(0)-65] = new int[] {(int)input[1].charAt(0)-65, (int)input[2].charAt(0)-65};
		}
		preOrder(tree, 0);
		System.out.println();
		inOrder(tree, 0);
		System.out.println();
		postOrder(tree, 0);
	}
}
