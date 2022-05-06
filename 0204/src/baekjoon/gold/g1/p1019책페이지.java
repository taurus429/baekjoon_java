package baekjoon.gold.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p1019책페이지 {
	static int[] cal(int m, int n) { //(m+1 자리에 숫자 n처리)
		int[] res = new int[10];
		Arrays.fill(res, n*m*(int)Math.pow(10, m-1));
		res[0] = makenum(m-1, true) * 9 + (n-1) * m*(int)Math.pow(10, m-1);
		for(int i=1; i<n; i++) {
			res[i] += (int)Math.pow(10, m);
		}
		res[0] += m;
		res[n] ++;
//		System.out.println(Arrays.toString(res));
		return res;
	}
	static int makenum(int a, boolean reverse) {
		String res = "";
		if (reverse) {
			for (int i = a; i > 0; i--) {
				res = res + String.valueOf(i);
			}
		} else {
			for (int i = a; i > 0; i--) {
				res = String.valueOf(i) + res;
			}
		}
		if(res=="")
			return 0;
		return Integer.parseInt(res);
	}

	static int[] res = new int[10];

	static void check(int n) {
		String num = String.valueOf(n);
		for (int i = 0; i < num.length(); i++) {
			res[num.charAt(i) - 48]++;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		
		for(int i=0; i<num.length()-1; i++) {
			int m = num.length()-i;
			int n = (int)num.charAt(i)-48;
			if(n!=0) {
				int[] temp = cal(m-1, n);
				for(int j=0; j<10; j++) {
					res[j] += temp[j];
				}
				if(i!=0)
				res[0] += makenum(m-1, false)*9;
			}
			res[n] += (Integer.parseInt(num.substring(i+1)));
		}
		int last = (int)num.charAt(num.length()-1)-48;
		if(last!=0) {
			for(int i=1; i<=last; i++) {
				res[i] ++;
			}
		}
		for(int i=0; i<10; i++) {
			System.out.print(res[i]+" ");
		}
	}
}
