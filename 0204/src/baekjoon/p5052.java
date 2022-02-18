package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p5052 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testcase; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] phone = new String[N];
			for (int i = 0; i < N; i++) {
				phone[i] = br.readLine();
			}
			boolean consistancey = true;
			Arrays.sort(phone);
			for (int i = 0; i < N - 1; i++) {
				if (phone[i + 1].startsWith(phone[i])) {
					consistancey = false;
					break;
				}
			}
			if (consistancey) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
