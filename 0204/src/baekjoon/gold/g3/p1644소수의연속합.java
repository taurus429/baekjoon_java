package baekjoon.gold.g3;

import java.util.Arrays;
import java.util.Scanner;

public class p1644소수의연속합 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt()+1;
		boolean check[] = new boolean[num];
		Arrays.fill(check, true);
		check[0] = false;
		check[1] = false;
		int cnt = num-2;
		for (int i = 2; i < num; i++) {
			if (check[i]) {
				int k = 2;
				while (k * i < num) {
					if (check[k * i]) {
						check[k * i] = false;
						cnt--;
					}
					k++;
				}
			}
		}
		int[] prime = new int[cnt];
		int idx =0;
		for(int i=2; i<num; i++) {
			if(check[i]) {
				prime[idx] = i;
				idx ++;
			}
		}
		int[] primeSum = new int[cnt+1];
		for(int i=1; i<cnt+1; i++) {
			primeSum[i] = primeSum[i-1]+prime[i-1];
		}
		int start  = 0;
		int end = 0;
		int ans =0;
		while(end<cnt+1) {
			if(primeSum[end]-primeSum[start]==num-1) {
				ans++;
				start++;
			}else if(primeSum[end]-primeSum[start]<num-1) {
				end ++;
			}else {
				start ++;
			}
		}
		System.out.println(ans);
		
	}
}
