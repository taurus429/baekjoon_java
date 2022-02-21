package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class p1927최소힙 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				if (heap.size() == 0) {
					System.out.println(0);
				} else {
					System.out.println(heap.poll());
				}
			} else {
				heap.offer(input);
			}
		}
	}
}
