package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p1269대칭차집합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<Integer, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			map.put(Integer.parseInt(st.nextToken()), 1);
		}
		int ans = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			if(map.containsKey(Integer.parseInt(st.nextToken()))) {
				ans ++;
			}
		}
		System.out.println(N+M-2*ans);
	}
}
