package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		for(int t=1; t<=testcase; t++) {
		st = new StringTokenizer(br.readLine(), " ");
		double x = Double.parseDouble(st.nextToken());
		double y = Double.parseDouble(st.nextToken());
		double min = Math.min(x, y);
		double h =0;
		double before = -1;
		while(true) {
			double res = h*(x-2*h)*(y-2*h);
			if(before>res) {
				break;
			}
			before = res;
			h += 0.000001;
		}
		System.out.println(String.format("#%d %.6f",t, before));
		}
	}
}
