package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p달리기 {
	static int N, M;
	static int[] needs;
	static long[] memo;
	static long dfs(int flag) {
		if(flag==(1<<N)-1) {
			return 1;
		}
		if(memo[flag]>0) {
			return memo[flag];
		}
		for(int i=0; i<N; i++) {
			if((flag&1<<i)==0) { //정해줘야 하면
				if((flag&needs[i])==needs[i]){
					memo[flag] += dfs(flag|1<<i);
				}
			}
		}
		return memo[flag];
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int f, s;
		for(int t=1; t<=T; t++) {
			st =new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			needs = new int[N];
			memo = new long[(1<<N)];
			for(int m=0; m<M; m++) {
				st = new StringTokenizer(br.readLine());
				f = Integer.parseInt(st.nextToken()) -1;
				s = Integer.parseInt(st.nextToken()) - 1;
				needs[f] |= (1<<s);
			}
			System.out.println("#"+t+" "+dfs(0));
		}
	}
}
