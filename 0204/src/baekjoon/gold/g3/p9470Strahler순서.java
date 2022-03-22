package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class p9470Strahler순서 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		for(int t=1; t<= testcase; t++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int node = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());
			int[] from = new int[node];
			int[] ans = new int[node];
			Stack<Integer>[] stack = new Stack[node];
			ArrayList<Integer>[] in = new ArrayList[node];
			for(int i=0; i<node; i++) {
				stack[i] = new Stack<Integer>();
				in[i] = new ArrayList<Integer>();
			}
			
			for(int i=0; i<edge; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken())-1;
				int end = Integer.parseInt(st.nextToken())-1;
				from[end] ++;
				stack[start].push(end);
			}
			int sea = node-1;
			for(int i=0; i<node ;i++) {
				if(stack[i].size()==0) {
					sea = i;
				}
			}
			Queue<Integer> queue = new LinkedList<Integer>();
			for(int i=0; i<node; i++) {
				if(from[i]==0) {
					in[i].add(1);
					queue.offer(i);
				}
			}
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				Integer[] inArray = in[cur].toArray(new Integer[0]);
				Arrays.sort(inArray, Collections.reverseOrder());
				if(inArray.length==1||inArray[0] != inArray[1]) {
					ans[cur] = inArray[0];
				} else {
					ans[cur] = inArray[0]+1;
				}
				while(!stack[cur].isEmpty()) {
					int temp = stack[cur].pop();
					in[temp].add(ans[cur]);
					from[temp] --;
					if(from[temp]==0) {
						queue.offer(temp);
					}
				}
			}
			System.out.println(K+" "+ans[sea]);
 		}
	}
}
