package baekjoon.bronze.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p3052 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] res = new int[42];
		for(int i=0; i<10; i++) {
			int num = Integer.parseInt(br.readLine());
			if(res[num%42]==0) {
				res[num%42]=1;
			}
		}
		int sum=0;
		for(int i=0; i<42; i++) {
			sum += res[i];
		}
		System.out.println(sum);
	}
}
