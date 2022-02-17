package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1828 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class C implements Comparable<C>{
		
		int low;
		int high;
		
		public C(int low, int high) {
			super();
			this.low = low;
			this.high = high;
		}

		@Override
		public int compareTo(C o) {
			return this.low != o.low?this.low - o.low:o.high- this.high;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int cnt = Integer.parseInt(br.readLine());
		C[] list = new C[cnt];
		for(int i=0; i<cnt; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = new C(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(list);
		int ans = 0;
		int highBound = Integer.MIN_VALUE;
		for(C c: list) {
			if(c.low>highBound) {
				ans ++;
				highBound = c.high;
			}else {
				if(c.high<highBound) {
					highBound = c.high;
				}				
			}
		}
		System.out.println(ans);
	}
	
}
