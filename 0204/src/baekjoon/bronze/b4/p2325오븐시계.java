package baekjoon.bronze.b4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2325오븐시계 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(br.readLine());
		
		int res = time + minute;
		hour += res / 60;
		minute = res % 60;
		System.out.println(hour + " " + minute);
	}
}
