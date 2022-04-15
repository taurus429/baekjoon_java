package baekjoon.silver.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1015수열정렬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st= new StringTokenizer(br.readLine());
		int[] num = new int[N];
		for(int i=0; i<N; i++) {
			num[i]=  Integer.parseInt(st.nextToken());
		}
		int[] origin = num.clone();
		Arrays.sort(num);
		Queue<Integer>[] queue = new LinkedList[1001];
		for(int i=0; i<=1000; i++) {
			queue[i] = new LinkedList<Integer>();
		}
		for(int i=0; i<N; i++) {
			queue[num[i]].offer(i);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(queue[origin[i]].poll()).append(" ");
		}
		System.out.println(sb);
	}
}
