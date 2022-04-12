package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17386선분교차1 {
	static int ccw(long[] p1, long[] p2, long[] p3) {
		return p1[0]*p2[1] + p2[0]*p3[1] + p3[0]*p1[1] -p1[1]*p2[0] - p2[1]*p3[0] - p3[1]*p1[0] < 0 ? 1: -1;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[][] point = new long[4][2];
		point[0][0] = Integer.parseInt(st.nextToken());
		point[0][1] = Integer.parseInt(st.nextToken());
		point[1][0] = Integer.parseInt(st.nextToken());
		point[1][1] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		point[2][0] = Integer.parseInt(st.nextToken());
		point[2][1] = Integer.parseInt(st.nextToken());
		point[3][0] = Integer.parseInt(st.nextToken());
		point[3][1] = Integer.parseInt(st.nextToken());
		if(ccw(point[0], point[1], point[2])*ccw(point[0], point[1], point[3])< 0&&
				ccw(point[2], point[3], point[0])*ccw(point[2], point[3], point[1])< 0) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
