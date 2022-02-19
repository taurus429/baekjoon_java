package baekjoon.bronze.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10803 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		String s = br.readLine();
		int[] alphabet = new int[26];
		for(int i=0; i<26; i++) {
			alphabet[i] = -1;
		}
		for(int i=0; i<s.length(); i++) {
			if(alphabet[s.charAt(i)-97]==-1) {
				alphabet[s.charAt(i)-97]= i;
			}
		}
		for(int i=0; i<26; i++) {
			System.out.print(alphabet[i]+" ");
		}
	}
}
