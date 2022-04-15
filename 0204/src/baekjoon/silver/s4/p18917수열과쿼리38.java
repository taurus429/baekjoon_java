package baekjoon.silver.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class p18917수열과쿼리38 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		HashMap<Long, Integer> map = new HashMap<>();
		long sum = 0;
		long xor = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			switch (order) {
			case 1:
				long input = Long.parseLong(st.nextToken());
				if(map.containsKey(input)) {
					map.replace(input, map.get(input)+1);
				}else {
					map.put(input, 1);
				}
				sum += input;
				xor ^= input;
				break;
			case 2:
				long input2 = Long.parseLong(st.nextToken());
				if(map.get(input2)==1) {
					map.remove(input2);
				}else {
					map.replace(input2, map.get(input2)-1);
				}
				sum -= input2;
				xor ^= input2;
				break;
			case 3:
				System.out.println(sum);
				break;
			case 4:
				System.out.println(xor);
				break;
			}
		}
	}
}
