package baekjoon.gold.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p13711LCS4 {
	
	static int lowerbound(ArrayList<Integer> dp, int num) {
		int start = 0;
		int end = dp.size();
		while(start+1<end) {
			int mid = (start+end)/2;
			if(dp.get(mid)>num) {
				end = mid;
			}else if(dp.get(mid)<num) {
				start = mid;
			}else {
				return mid;
			}
		}
		return start+1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] lcs1 = new int[N];
		int[] lcs2 = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			lcs1[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			lcs2[i] = Integer.parseInt(st.nextToken());
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			map.put(lcs1[i], i);
		}
		ArrayList<Integer> dp = new ArrayList<>();
		dp.add(Integer.MIN_VALUE);
		
		for(int i=0; i<N; i++) {
			if(dp.get(dp.size()-1)<map.get(lcs2[i])) {
				dp.add(map.get(lcs2[i]));
			} else {
				dp.set(lowerbound(dp, map.get(lcs2[i])), map.get(lcs2[i]));
			}
		}
		System.out.println(dp.size()-1);
	}
}
