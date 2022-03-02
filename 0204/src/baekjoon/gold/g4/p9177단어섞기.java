package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class p9177단어섞기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String[] input;
	static boolean found = false;

	static boolean compare(int Fidx, int Sidx, int Tidx) {
		while (Fidx==input[0].length() || Sidx == input[1].length() || input[0].charAt(Fidx) != input[1].charAt(Sidx)) {
			if(input[2].length()==Tidx) {
				return true;
			}
			if (Fidx<input[0].length() && input[0].charAt(Fidx) == input[2].charAt(Tidx)) {
				Fidx++;
				Tidx++;
				continue;
			} else if (Sidx<input[1].length() && input[1].charAt(Sidx) == input[2].charAt(Tidx)) {
				Sidx++;
				Tidx++;
				continue;
			}
			return false;
		}
		if (input[0].charAt(Fidx) == input[2].charAt(Tidx)) {
			return compare(Fidx+1, Sidx, Tidx+1)||compare(Fidx, Sidx+1, Tidx+1);
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			input = br.readLine().split(" ");
			
			Set<Character> set = new HashSet<>();
			for (int j = 0; j < Math.max(input[0].length(), input[1].length()); j++) {
				if(j < input[0].length()) set.add(input[0].charAt(j));
				if(j < input[1].length()) set.add(input[1].charAt(j));
			}
			boolean flag = true;
			for (int j = 0; j < input[2].length(); j++) {
				if (!set.contains(input[2].charAt(j))) {
					flag = false;
					break;
				}
			}
			if (!flag) {
				System.out.println("Data set " + i + ": no");
				continue;
			}
			
			
			System.out.print("Data set "+i+": ");
			if(compare(0, 0, 0)) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
	}
}
