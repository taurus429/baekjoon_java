package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p2513통학버스 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int bus = Integer.parseInt(st.nextToken());
		int school = Integer.parseInt(st.nextToken());
		PriorityQueue<int[]> leftPq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
		PriorityQueue<int[]> rightPq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int position = Integer.parseInt(st.nextToken());
			int student = Integer.parseInt(st.nextToken());
			if (school > position)
				leftPq.offer(new int[] { school - position, student });
			else
				rightPq.offer(new int[] { position - school, student });
		}
		int dist = 0;
		int passenger = 0;
		while (!leftPq.isEmpty()) {
			if (passenger == 0) {
				if (leftPq.peek()[1] >= bus) {
					int[] temp = leftPq.poll();
					dist += temp[0]*2*(temp[1]/bus);
					temp[1] %= bus;
					if(temp[1]!=0) {
						leftPq.offer(temp);
					}
					continue;
				} else {
					dist += leftPq.peek()[0] * 2;
				}
			}
			if (passenger + leftPq.peek()[1] < bus) {
				passenger += leftPq.poll()[1];
			} else if (passenger + leftPq.peek()[1] == bus) {
				passenger = 0;
				leftPq.poll();
			} else {
				int[] temp = leftPq.poll();
				temp[1] -= (bus - passenger);
				leftPq.offer(temp);
				passenger = 0;
			}
		}
		passenger = 0;
		while (!rightPq.isEmpty()) {
			if (passenger == 0) {
				if (rightPq.peek()[1] >= bus) {
					int[] temp = rightPq.poll();
					dist += temp[0]*2*(temp[1]/bus);
					temp[1] %= bus;
					if(temp[1]!=0) {
						rightPq.offer(temp);
					}
					continue;
				} else {
					dist += rightPq.peek()[0] * 2;
				}
			}
			if (passenger + rightPq.peek()[1] < bus) {
				passenger += rightPq.poll()[1];
			} else if (passenger + rightPq.peek()[1] == bus) {
				passenger = 0;
				rightPq.poll();
			} else {
				int[] temp = rightPq.poll();
				temp[1] -= (bus - passenger);
				rightPq.offer(temp);
				passenger = 0;
			}
		}
		System.out.println(dist);
	}
}