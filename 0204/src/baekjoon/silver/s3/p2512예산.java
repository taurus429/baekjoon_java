package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2512예산 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int getMoney(int[] money, int amount) {
		int res = 0;
		for(int i=0; i<money.length; i++) {
			if(money[i]<amount) {
				res += money[i];
			} else {
				res += amount;
			}
		}
		return res;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[] money = new int[N];
		st= new StringTokenizer(br.readLine());
		int end = -1;
		for(int i=0; i<N; i++) {
			money[i] = Integer.parseInt(st.nextToken());
			if(money[i] > end) {
				end= money[i];
			}
		}
		int all = Integer.parseInt(br.readLine());
		int start =0;
		int ans = 0;
		while(start<=end) {
			int mid = (start+end)/2;
			if(getMoney(money, mid)>all) {
				end = mid-1;
			} else if(getMoney(money, mid)<all) {
				start = mid+1;
			} else {
				System.out.println(mid);
				return;
			}
		}
		System.out.println(end);
		
	}
}
