package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2491 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int len = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int answer = 2;
		int acc = 0;
		int desc = 0;
		for (int i = 1; i < len; i++) {
			int before = Integer.parseInt(input[i - 1]);
			int curr = Integer.parseInt(input[i]);
			if (curr > before) {
				acc++;
				if (desc > answer - 1) {
					answer = desc + 1;
				}
				desc = 0;
			} else if (curr < before) {
				desc++;
				if (acc > answer - 1) {
					answer = acc + 1;
				}
				acc = 0;
			} else {
				acc ++;
				desc ++;
			}
		}
		if (desc > answer - 1) {
			answer = desc + 1;
		}
		if (acc > answer - 1) {
			answer = acc + 1;
		}
		if(len==1) {
			System.out.println(1);
		}else {
		System.out.println(answer);
		}
	}
}
