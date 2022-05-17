package baekjoon.silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1669멍멍이쓰다듬기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int diff = -(Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken()));
		if(diff==0) {
			System.out.println(0);
			return;
		}
		int sqr = (int)Math.ceil(Math.sqrt(diff));
		if(diff - (int)Math.pow(sqr-1, 2)>=sqr) {
			System.out.println((sqr-1)*2+1);
		} else {
			System.out.println((sqr-1)*2);
		}
	}
}
