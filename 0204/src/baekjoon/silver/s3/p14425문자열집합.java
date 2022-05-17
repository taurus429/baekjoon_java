package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p14425문자열집합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			map.put(br.readLine(), 7);
		}
		int ans = 0;
		for(int i=0; i<M; i++) {
			if(map.containsKey(br.readLine())) {
				ans ++;
			}
		}
		System.out.println(ans);
	}
}
