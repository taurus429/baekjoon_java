package baekjoon.silver.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2947나무조각 {
	static boolean check(int[] num) {
		return num[0]==1&&num[1]==2&&num[2]==3&&num[3]==4&&num[4]==5;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int[] num = new int[5];
		for(int i=0; i<5; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int idx =0;
		while(!check(num)) {
			if(num[idx]>num[idx+1]) {
				int temp = num[idx];
				num[idx] = num[idx+1];
				num[idx+1] = temp;
				for(int i=0; i<5; i++) {
					System.out.print(num[i]+" ");
				}
				System.out.println();
			}
			idx ++;
			idx %= 4;
		}
	}
}
