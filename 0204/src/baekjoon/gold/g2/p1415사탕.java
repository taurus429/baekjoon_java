package baekjoon.gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class p1415사탕 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int zero = 1;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				zero ++;
				continue;
			}
			if (map.containsKey(num)) {
				map.replace(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
			sum += num;
		}
		int[][] candy = new int[map.size()][2];
		int idx = 0;
		for (Map.Entry<Integer, Integer> m : map.entrySet()) {
			candy[idx++] = new int[] { m.getKey(), m.getValue() };
		}
		long[] dp = new long[sum + 1];
		dp[0] = 1;
		
		for(int i=0; i<map.size(); i++) {
			for(int j=sum; j>=0; j--) {
				for(int k=1; k<=candy[i][1]; k++) {
					if(j-candy[i][0]*k<0)break;
					dp[j] += dp[j-candy[i][0]*k];
				}
			}
		}
		
		ArrayList<Integer> prime = new ArrayList<>();
		prime.add(2);
		for(int i=3; i<=sum; i++) {
			int x = (int) Math.sqrt(i);
			for(int p: prime) {
				if(x<p) {
					prime.add(i);
					break;
				}
				if(i%p==0) {
					break;
				}
				
			}
		}
		long ans = 0;
		for(int p: prime) {
			if(p<=sum)
			ans += dp[p];
		}
		System.out.println(ans*zero);

	}
}
