package baekjoon.platinum.p5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p14003가장긴증가하는부분수열5 {
	static int find(ArrayList<Long> dp, long num) {
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
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		long[] num = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Long.parseLong(st.nextToken());
		}
		ArrayList<Long> dp = new ArrayList<>();
		ArrayList<PriorityQueue<Long>> pq = new ArrayList<>();
		pq.add(new PriorityQueue<Long>());
		pq.get(0).offer(Long.MIN_VALUE);
		dp.add(Long.MIN_VALUE);
		for(int i=0; i<N; i++) {
			if(i==0) {
				dp.add(num[i]);
			}else {
				if(dp.get(dp.size()-1)<num[i]){
					dp.add(num[i]);
				} else {
					int idx = find(dp, num[i]);
					if(dp.get(idx)!=num[i])
						dp.set(idx, num[i]);
				}
			}
		}
		System.out.println(dp.size()-1);
		
	}
}
