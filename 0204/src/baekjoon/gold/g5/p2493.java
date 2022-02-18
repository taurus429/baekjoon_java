package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p2493 {
	static Stack<int[]> stack = new Stack<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		int[] lader = new int[cnt];
		String[] input = br.readLine().split(" ");
		for(int i=0; i<cnt; i++) {
			lader[i] = Integer.parseInt(input[i]);
		}
		
		for(int i=0; i<cnt; i++) {
			if(stack.empty()) {
				System.out.print(0+" ");
				stack.push(new int[] {i, lader[i]});
			}else {
				while(!stack.isEmpty() && stack.peek()[1]<lader[i]) {
					stack.pop();
				}
				if(stack.empty()) {
					System.out.print(0 +" ");
					stack.push(new int[] {i, lader[i]});
				}else {
					System.out.print(stack.peek()[0]+1+" ");
					stack.push(new int[] {i, lader[i]});	
				}
			}
		}
	}
}
