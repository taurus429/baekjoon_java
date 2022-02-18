package baekjoon.silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p2477 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int fruit = Integer.parseInt(br.readLine());
		boolean[] doublelen = new boolean[6];
		int[] check = new int[4];
		int[] len = new int[6];
		int[] direct = new int[6];
		for (int i=0; i<6; i++) {
			String[] input = br.readLine().split(" ");
			int d = Integer.parseInt(input[0])-1;
			int l = Integer.parseInt(input[1]);
			check[d]++;
			len[i] = l;
			direct[i] = d;
		}
		for(int i=0; i<4; i++) {
			if(check[i] == 1) {
				for(int j=0; j<6; j++) {
					if(direct[j] == i) {
						doublelen[j] = true;
					}
				}
			}
		}
		int startIndex = 0;
		for(int i=1; i<6; i++) {
			if(!doublelen[i]&&doublelen[i-1]) {
				startIndex = i;
				break;
			}
		}
		int bigH = (startIndex+4)%6;
		int bigW = (startIndex+5)%6;
		int smallH = (startIndex+1)%6;
		int smallW = (startIndex+2)%6;
		System.out.println((len[bigH]*len[bigW]-len[smallH]*len[smallW])*fruit);
	}
}
