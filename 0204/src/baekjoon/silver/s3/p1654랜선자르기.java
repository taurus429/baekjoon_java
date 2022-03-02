package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1654랜선자르기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] lines;

	static long getnum(long len) {
		long res = 0;
		for (int l : lines) {
			res += (long)l / len;
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		lines = new int[N];
		long end = 0;
		for (int i = 0; i < N; i++) {
			lines[i] = Integer.parseInt(br.readLine());
			if(lines[i]>end)
				end = lines[i];
		}
		end++;
		long start = 1;
		while (end > start) {
			long mid = (start + end) / 2;
			if (getnum(mid) < K) {
				end = mid;
			} else  {
				start = mid+1;
			}
		}
		System.out.println(start-1);
	}
}
