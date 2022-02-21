package baekjoon.silver.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class p17219비밀번호찾기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		HashMap<String, String> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			input = br.readLine().split(" ");
			map.put(input[0], input[1]);
		}
		String key;
		for(int i=0; i<M; i++) {
			key = br.readLine();
			System.out.println(map.get(key));
		}
	}
}
