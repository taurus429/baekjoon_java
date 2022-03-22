package baekjoon.silver.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p11656접미사배열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] list = new String[input.length()];
		for(int i=0; i<input.length(); i++) {
			list[i] = input.substring(i, input.length());
		}
		Arrays.sort(list);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<list.length; i++) {
			sb.append(list[i]).append("\n");
		}
		System.out.println(sb);
	}
}
