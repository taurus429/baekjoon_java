package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2166다각형의면적 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[][] point;
	static long getArea(long[] p1, long[] p2, long[] p3) {
		return p1[0]*p2[1]+p2[0]*p3[1]+p3[0]*p1[1]-p2[0]*p1[1]-p3[0]*p2[1]-p1[0]*p3[1];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		point = new long[n][2];
		long ans = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			point[i] = new long[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		for(int i=1; i<n-1; i++) {
			ans += getArea(point[0], point[i], point[i+1]);
		}
		ans = Math.abs(ans);
		System.out.print(ans/2);
		if(ans%2==1) {
			System.out.println(".5");
		}else {
			System.out.println(".0");			
		}
//		System.out.printf("%.1f", ans);
	}
}
