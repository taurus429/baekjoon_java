package baekjoon.silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14888연산자끼워넣기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int len;
	static int[] num;
	static int[] oper;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	static void permutate(int value, int cnt) {
		if(len == cnt) {
			if(value>max) {
				max = value;
			}
			if(value<min) {
				min = value;
			}
			return;
		}
		for(int i=0; i<4; i++) {
			if(oper[i]!=0) {
				oper[i] --;
				if(i==0) {
					permutate(value+num[cnt], cnt+1);
				}else if(i==1) {
					permutate(value-num[cnt], cnt+1);
				}else if(i==2) {
					permutate(value*num[cnt], cnt+1);
				}else {
					permutate(value/num[cnt], cnt+1);
				}
				oper[i]++;
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		len = Integer.parseInt(br.readLine());
		num = new int[len];
		oper = new int[4];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<len; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		permutate(num[0], 1);
		System.out.println(max);
		System.out.println(min);
	}
}
