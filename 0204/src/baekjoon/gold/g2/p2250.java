package baekjoon.gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2250 {
	static int[] leftEnd = new int[10000];
	static int[] rightEnd = new int[10000];
	static Node[] nodes;
	static int root;

	static class Node {
		Node rightChild;
		Node leftChild;
		Node parent;
		int left;
		int right;
		int index;

		public Node(int index) {
			this.index = index;
		}

		@Override
		public String toString() {
			return index + " " + left + " " + right;
		}

	}

	static void leftDfs(int depth, int index) {
		if (nodes[index].leftChild == null && nodes[index].rightChild == null)
			return;
		if (nodes[index].leftChild != null) {
			if (leftEnd[depth] == 0) {
				leftEnd[depth] = nodes[index].leftChild.index;
			}
			leftDfs(depth + 1, nodes[index].leftChild.index);
		}
		if (nodes[index].rightChild != null) {
			if (leftEnd[depth] == 0) {
				leftEnd[depth] = nodes[index].rightChild.index;
			}
			leftDfs(depth + 1, nodes[index].rightChild.index);
		}
	}

	static int leftCal(int index) {
		if (index == root)
			return 0;
		Node parent = nodes[index].parent;
		if (parent.leftChild != null && index == parent.leftChild.index) {
			return (1 + nodes[index].right + leftCal(parent.index));
		} else {
			return (-1 - nodes[index].left + leftCal(parent.index));
		}
	}

	static void rightDfs(int depth, int index) {
		if (nodes[index].leftChild == null && nodes[index].rightChild == null)
			return;
		if (nodes[index].rightChild != null) {
			if (rightEnd[depth] == 0) {
				rightEnd[depth] = nodes[index].rightChild.index;
			}
			rightDfs(depth + 1, nodes[index].rightChild.index);
		}
		if (nodes[index].leftChild != null) {
			if (rightEnd[depth] == 0) {
				rightEnd[depth] = nodes[index].leftChild.index;
			}
			rightDfs(depth + 1, nodes[index].leftChild.index);
		}
	}

	static int rightCal(int index) {
		if (index == root)
			return 0;
		Node parent = nodes[index].parent;
		if (parent.rightChild != null && index == parent.rightChild.index) {
			return (1 + nodes[index].left + rightCal(parent.index));
		} else {
			return (-1 - nodes[index].right + rightCal(parent.index));
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		nodes = new Node[N + 1];
		for (int i = 1; i <= N; i++) {
			nodes[i] = new Node(i);
		}
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			int p = Integer.parseInt(input[0]);
			int l = Integer.parseInt(input[1]);
			int r = Integer.parseInt(input[2]);
			if (l != -1) {
				nodes[p].leftChild = nodes[l];
				nodes[l].parent = nodes[p];
			}
			if (r != -1) {
				nodes[p].rightChild = nodes[r];
				nodes[r].parent = nodes[p];
			}
		}
		for (int t = 0; t < N; t++) {
			for (int i = N; i > 0; i--) {
				if (nodes[i].leftChild == null) {
					nodes[i].left = 0;
				} else {
					nodes[i].left = nodes[i].leftChild.left + nodes[i].leftChild.right + 1;
				}
				if (nodes[i].rightChild == null) {
					nodes[i].right = 0;
				} else {
					nodes[i].right = nodes[i].rightChild.left + nodes[i].rightChild.right + 1;
				}
			}
		}
		Node rootNode = nodes[1];
		root = rootNode.index;
		while (true) {
			if (rootNode.parent != null) {
				rootNode = rootNode.parent;
			} else {
				break;
			}
		}
		root = rootNode.index;
		leftDfs(0, root);
		rightDfs(0, root);
		int k = 0;
		int max = 1;
		int width = 0;
		int level = 1;
		while (leftEnd[k] != 0 && rightEnd[k] != 0) {
			width = leftCal(leftEnd[k]) + rightCal(rightEnd[k]) + 1;
			if (max < width) {
				max = width;
				width = max;
				level = k + 2;
			}
			k++;
		}
		System.out.println(level + " " + max);

	}
}
