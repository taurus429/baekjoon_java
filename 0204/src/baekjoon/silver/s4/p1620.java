package baekjoon.silver.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class p1620 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int q = Integer.parseInt(input[1]);
		Map<Integer, String> map = new HashMap<Integer, String>();
		Map<String, Integer> map2 = new HashMap<>();
		for(int i=1; i<=n; i++) {
			String line = br.readLine();
			map.put(i, line);
			map2.put(line, i);
		}
		for(int i=0; i<q; i++) {
			String temp = br.readLine();
			if(map2.containsKey(temp)) {
				System.out.println(map2.get(temp));
			}else {
				System.out.println(map.get(Integer.parseInt(temp)));
			}
		}
	}
}
