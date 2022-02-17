package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1074 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int zSearch(int n, int r, int c) {
		if(n==1) {
			if(r==0&&c==0) {
				return 0;
			}else if(r==0&&c==1) {
				return 1;
			}else if(r==1&&c==0) {
				return 2;
			}else {
				return 3;
			}
		}else {
			int limit = (int)Math.pow(2, n-1);
			int block = (int)Math.pow(limit, 2);
			if(r<limit&&c<limit) {
				return zSearch(n-1, r, c);
			}else if(r<limit&&c>=limit) {
				return block*1 + zSearch(n-1, r, c - limit);
			}else if(r>=limit&&c<limit) {
				return block*2 + zSearch(n-1, r - limit, c);
			}else if(r>=limit&&c>=limit) {
				return block*3 + zSearch(n-1, r - limit, c - limit);
			}else {
				return -1;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		int n= Integer.parseInt(input[0]);
		int r= Integer.parseInt(input[1]);
		int c= Integer.parseInt(input[2]);
		System.out.println(zSearch(n, r, c));
	}
}
