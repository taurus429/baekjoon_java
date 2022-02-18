package baekjoon.bronze.b1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2869 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int a= Integer.parseInt(input[0]);
		int b= Integer.parseInt(input[1]);
		int v= Integer.parseInt(input[2]);
		
		int height = a;
		int range = a-b;
		
		double res = Math.ceil((double)(v-height)/range+1);
		System.out.println((int)res);
		
	}
}
