package baekjoon.silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p1495기타리스트 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Start = Integer.parseInt(st.nextToken());
		int Max = Integer.parseInt(st.nextToken());
		HashMap<Integer, Integer> volume = new HashMap<>();
		HashMap<Integer, Integer> newVolume = new HashMap<>();
		volume.put(Start, 1);

		st= new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int change = Integer.parseInt(st.nextToken());
			for(Integer v: volume.keySet()) {
				if(v+change<=Max) {
					newVolume.put(v+change, 1);
				}
				if(v-change>=0) {
					newVolume.put(v-change, 1);
				}
			}
			volume = newVolume;
			newVolume = new HashMap<>();
		}
		if(volume.size()==0) {
			System.out.println(-1);
			return;
		}
		int answer = -1;
		for(Integer v: volume.keySet()) {
			answer = Math.max(answer, v);
		}
		System.out.println(answer);
		
	}
}
