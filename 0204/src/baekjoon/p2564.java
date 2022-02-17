package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class p2564 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		int width = Integer.parseInt(input[0]);
		int height = Integer.parseInt(input[1]);
		int store = Integer.parseInt(br.readLine());
		ArrayList<int[]> storeList = new ArrayList<>();
		for (int i = 0; i < store; i++) {
			input = br.readLine().split(" ");
			storeList.add(new int[] { Integer.parseInt(input[0]), Integer.parseInt(input[1]) });
		}
		input = br.readLine().split(" ");
		int direction = Integer.parseInt(input[0]);
		int pos = Integer.parseInt(input[1]);

		int distance = 0;
		for (int[] s : storeList) {// 북남서북
			if (direction == 1) {
				if (s[0] == 1) {
					distance += (int)Math.abs(pos- s[1]);
				} else if (s[0] == 2) {
					distance += Math.min(height+s[1]+pos, height+(width-s[1])+(width-pos));
				} else if (s[0] == 3) {
					distance += pos + s[1];
				} else if (s[0] == 4) {
					distance += width -pos + s[1];
				}
			} else if (direction == 2) {
				if (s[0] == 1) {
					distance += Math.min(height+s[1]+pos, height+(width-s[1])+(width-pos));
				} else if (s[0] == 2) {
					distance += (int)Math.abs(pos- s[1]);
				} else if (s[0] == 3) {
					distance += height -s[1] + pos;
				} else if (s[0] == 4) {
					distance += height - s[1] + width -pos;
				}
			} else if (direction == 3) {
				if (s[0] == 1) {
					distance += pos + s[1];
				} else if (s[0] == 2) {
					distance += height - pos + s[1];
				} else if (s[0] == 3) {
					distance += (int)Math.abs(pos- s[1]);
				} else if (s[0] == 4) {
					distance += Math.min(width+s[1]+pos, width+(height-s[1])+(height-pos));
				}
			} else if (direction == 4) {
				if (s[0] == 1) {
					distance += width - s[1] + pos;
				} else if (s[0] == 2) {
					distance += width - s[1] + height - pos;
				} else if (s[0] == 3) {
					distance += Math.min(width+s[1]+pos, width+(height-s[1])+(height-pos));
				} else if (s[0] == 4) {
					distance += (int)Math.abs(pos- s[1]);
				}
			}
		}
		System.out.println(distance);
	}
}
