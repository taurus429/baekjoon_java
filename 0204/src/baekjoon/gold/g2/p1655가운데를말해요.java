package baekjoon.gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class p1655가운데를말해요 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> bigger = new PriorityQueue<>();
		PriorityQueue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(br.readLine());
			if(i==0) {
				smaller.offer(input);
			}else {
				if(smaller.size()==bigger.size()) {
					if(bigger.peek()>=input) {
						smaller.offer(input);
					} else {
						smaller.offer(bigger.poll());
						bigger.offer(input);
					}
				} else {
					if(smaller.peek()<=input) {
						bigger.offer(input);
					} else {
						bigger.offer(smaller.poll());
						smaller.offer(input);
					}
				}
			}
			sb.append(smaller.peek()).append("\n");
		}
		System.out.println(sb);
	}
}
