package baekjoon.bronze.b3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1085직사각형에서탈출 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		int x = Integer.parseInt(input[0]);
		int y = Integer.parseInt(input[1]);
		int w = Integer.parseInt(input[2]);
		int h = Integer.parseInt(input[3]);
		int min = Integer.MAX_VALUE;
		min = Math.min(min, x);
		min = Math.min(min, w-x);
		min = Math.min(min, y);
		min = Math.min(min, h-y);
		System.out.println(min);
	}
	
}
