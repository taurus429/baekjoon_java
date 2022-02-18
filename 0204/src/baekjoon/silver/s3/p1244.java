package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1244 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static boolean[] swit;
	static int len;

	static void change(int gender, int index) {
		if (gender == 1) {
			int i = 1;
			do {
				swit[i * index-1] ^= true;
				i++;
			} while (i * index-1 < len);
		} else {
			swit[index-1]^=true;
			int i = 1;
			while(index-i-1>=0&&index+i-1<len&&(swit[index-i-1]==swit[index+i-1])) {
				swit[index-i-1]^=true;
				swit[index+i-1]^=true;
				i++;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		len = Integer.parseInt(br.readLine());
		swit = new boolean[len];
		String[] input = br.readLine().split(" ");
		for(int i=0; i<len; i++) {
			if(input[i].equals("0")) {
				swit[i] = false;
			}else {
				swit[i] = true;
			}
		}
		int student = Integer.parseInt(br.readLine());
		for(int i=0; i<student; i++) {
			input = br.readLine().split(" ");
			int gender = Integer.parseInt(input[0]);
			int index = Integer.parseInt(input[1]);
			change(gender, index);
		}
		for(int i=0; i<len; i++) {
			if(swit[i]) {
				sb.append("1 ");
			}else {
				sb.append("0 ");
			}
			if((i+1)%20==0&&i>0) {
				sb.delete(sb.length()-1, sb.length());
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
