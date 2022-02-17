package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p18228 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		String [] input = br.readLine().split(" ");
		int[] num = new int[len];
		int index =0;
		for(int i=0; i<len; i++) {
			int temp = Integer.parseInt(input[i]);
			if(temp == -1) {
				index = i;
			}
			num[i] = temp;
		}
		int leftMin = Integer.MAX_VALUE;
		int rightMin = Integer.MAX_VALUE;
		for(int i=0; i<index; i++) {
			if(leftMin>num[i]) {
				leftMin = num[i];
			}
		}
		for(int i=index+1; i<len; i++) {
			if(rightMin>num[i]) {
				rightMin = num[i];
			}
		}
		System.out.println(leftMin+rightMin);
	}
}
