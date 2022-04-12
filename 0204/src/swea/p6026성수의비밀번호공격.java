package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p6026성수의비밀번호공격 {
	static int bignum;
	static int pow(int n, int k) {
		int res = 1;
		for(int i=0; i<k; i++) {
			res *= n;
			res %= bignum;
		}
		return res;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		bignum = 1000000007;
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int[] ans = new int[M+1];
			ans[1] = 1;
			for(int i=2; i<=M; i++) {
				ans[i] = pow(i, N);
				for(int j=i; j>=1; j--) {
					ans[i] -= j*ans[j-1];
				}
			}
			System.out.println(ans[M]%bignum);
		}
	}
}
