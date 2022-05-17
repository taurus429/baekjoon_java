package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P11478서로다른부분문자열의개수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = input.length();
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n+1; j++) {
				map.put(input.substring(i,j), 1);
			}
		}
		System.out.println(map.size());
	}
}
