package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class p17413 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String input = br.readLine();
		Queue<Character> queue = new LinkedList<Character>();
		Stack<Character> stack = new Stack<>();
		boolean q = false;

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '<') {
				while(!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				q = true;
			} else if(input.charAt(i)=='>') {
				while(!queue.isEmpty()) {
					System.out.print(queue.poll());
				}
				System.out.print(">");
				q = false;
				continue;
			} else if(input.charAt(i)==' '&&!q) {
				while(!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				System.out.print(" ");
				continue;
			}
			if (!q) {
				stack.add(input.charAt(i));
				if(i==input.length()-1) {
					while(!stack.isEmpty()) {
						System.out.print(stack.pop());
					}
				}
			} else {
				queue.offer(input.charAt(i));
			}
		}
	}

}
