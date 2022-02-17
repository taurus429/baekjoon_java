package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class p15663 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int m;
	static int[] com;
	static Integer[] num;
	static int[] count = new int[10000];

	static void combi(int cnt) {
		if (cnt == m) {
			for(int i=0; i<m; i++) {
				System.out.print(com[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if(count[num[i]]!=0) {
				com[cnt] = num[i];				
				count[num[i]]--;
				combi(cnt + 1);
				count[num[i]]++;	
			}
		}
	}

	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		input = br.readLine().split(" ");
		com = new int[m];
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(input[i]);
			set.add(num);
			count[num]++;
		}
		num = set.toArray(new Integer[0]);
		Arrays.sort(num);
		combi(0);
	}
}
