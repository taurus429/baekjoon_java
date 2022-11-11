package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class p2668숫자고르기 {
	static int[] array;
	static boolean[] visited;
	static ArrayList<Integer> checkCycle(int start) {
		ArrayList<Integer> res = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		int before = start;
		int cur = -1;
		stack.push(start);
		map.put(start, 1);
		while(true) {
			cur = array[before];
			if(visited[cur])
				return null;
			if(map.containsKey(cur)) {
				stack.push(cur);
				break;
			}
			stack.push(cur);
			map.put(cur, 1);
			before = cur;
		}
		int temp = stack.pop();
		res.add(temp);
		while(stack.peek()!=temp) {
			res.add(stack.pop());
		}
		return res;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		array = new int[N+1];
		visited = new boolean[N+1];
		for(int i=1; i<N+1; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		ArrayList<Integer> res = new ArrayList<>();
		for(int i=1; i<N+1; i++) {
			res = checkCycle(i);
			if(!visited[i]&&res!=null) {
				for(Integer r: res) {
					visited[r] = true;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		int count =0;
		for(int i=1; i<N+1; i++) {
			if(visited[i]) {
				sb.append(i+"\n");
				count ++;
			}
		}
		System.out.println(count);
		System.out.println(sb);
	}
}
