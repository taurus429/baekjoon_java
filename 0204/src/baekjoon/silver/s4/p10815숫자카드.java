package baekjoon.silver.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p10815숫자카드 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<n; i++) {
			map.put(Integer.parseInt(st.nextToken()), 0);
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			if(map.containsKey(Integer.parseInt(st.nextToken()))) {
				System.out.print("1 ");
			}else {				
				System.out.print("0 ");
			}
		}
	}
}
