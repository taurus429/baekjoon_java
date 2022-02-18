package baekjoon.bronze.b1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2999 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String message = br.readLine();
		int len = message.length();
		int r =1;
		int c = len;
		for(int i=1; i<=(int)Math.sqrt(len); i++) {
			if(len%i==0) {
				r=i;
				c=len/i;
			}
		}
		char[][] password = new char[r][c];
		int idx =0;
		for(int i=0; i<c; i++) {
			for(int j=0; j<r; j++) {
				password[j][i] = message.charAt(idx++);
			}
		}
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				System.out.print(password[i][j]);
			}
		}
		
	}
}
