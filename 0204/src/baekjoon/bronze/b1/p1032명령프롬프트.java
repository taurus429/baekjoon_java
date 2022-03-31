package baekjoon.bronze.b1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1032명령프롬프트 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		char[] inputarray = input.toCharArray();
		int len = input.length();
		for(int i=0; i<N-1; i++) {
			String temp = br.readLine();
			for(int j=0; j<len; j++) {
				if(inputarray[j] != temp.charAt(j)) {
					inputarray[j] = '?';
				}
			}
		}
		for(int i=0; i<len; i++) {
			System.out.print(inputarray[i]);
		}
	}
}
