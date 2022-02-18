package baekjoon.bronze.b1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2851 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int before=0;
		int sum=0;
		for(int i=0; i<10; i++) {
			before = sum;
			sum += Integer.parseInt(br.readLine());
			if(before<=100&&sum > 100) {
				break;
			}
		}
		if(100-before< sum-100) {
			System.out.println(before);
		}else {
			System.out.println(sum);
		}
	}
}
