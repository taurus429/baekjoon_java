package baekjoon.silver.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p15828Router {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue queue = new LinkedList<Integer>();
		int input = Integer.parseInt(br.readLine());
		while(input!=-1) {
			if(input == 0) {
				queue.poll();
			} else {
				if(queue.size()<N) {
					queue.offer(input);
				}
			}
			input = Integer.parseInt(br.readLine());
		}
		if(queue.isEmpty()) {
			System.out.println("empty");
		}
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
}
