package baekjoon.silver.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class p1302베스트셀러 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			if(map.containsKey(input)) {
				map.replace(input, map.get(input)+1);
			} else {
				map.put(input, 1);
			}
		}
		int max =0;
		String ans = "";
		for(String key: map.keySet()) {
			if(map.get(key)>max) {
				max = map.get(key);
				ans = key;
			} else if(map.get(key)==max) {
				if(key.compareTo(ans)>0) {
					ans = key;
				}
			}
		}
		System.out.println(ans);
	}
}
