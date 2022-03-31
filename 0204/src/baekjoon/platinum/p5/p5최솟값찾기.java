package baekjoon.platinum.p5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class p5최솟값찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		ArrayDeque<int[]> deque = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(st.nextToken());
			while(!deque.isEmpty()&&deque.getLast()[1]>input) {
				deque.pollLast();
			}
			deque.addLast(new int[] {i+L-1, input});
			if(deque.getFirst()[0]<i) {
				deque.pollFirst();
			}
			bw.write(deque.getFirst()[1]+" ");
		}
		bw.flush();
		bw.close();
	}
}
