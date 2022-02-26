package baekjoon.gold.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class p3015오아시스재결합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[] people = new int[N];
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(br.readLine());
		}
		Stack<Long[]> stack = new Stack<>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (!stack.isEmpty()) {
				if (stack.peek()[0] > people[i]) {
					stack.push(new Long[] { (long)people[i], (long)1 });
					cnt++;
				} else if (stack.peek()[0] <= people[i]) {
					while (!stack.isEmpty() && stack.peek()[0] < people[i]) {
						cnt += stack.peek()[1];
						stack.pop();
					}
					if (!stack.isEmpty()) {
						if (stack.peek()[0] == people[i]) {
							cnt += stack.peek()[1];
							stack.peek()[1]++;
							if(stack.size()>1) {
								cnt ++;
							}
						} else {
							cnt ++;
							stack.push(new Long[] { (long)people[i], (long)1 });
						}
					} else {
						stack.push(new Long[] { (long)people[i], (long)1 });					
					}
				} else {
					stack.peek()[1]++;
				}

			} else { //초기만
				stack.push(new Long[] { (long)people[i], (long)1 });
			}
		}

		System.out.println(cnt);
	}
}
