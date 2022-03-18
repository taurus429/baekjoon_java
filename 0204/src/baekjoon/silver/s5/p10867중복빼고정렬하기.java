package baekjoon.silver.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class p10867중복빼고정렬하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<n; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		Integer[] num = set.toArray(new Integer[0]);
		Arrays.sort(num);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<num.length; i++) {
			sb.append(num[i]);
			sb.append(" ");
		}
		System.out.println(sb);
	}
}
