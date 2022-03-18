package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p9935문자열폭발 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Stack<Character> stack;
	static String bomb;
	
	static void check() {
		char[] pop = new char[bomb.length()];
		for(int i=bomb.length()-1; i>=0; i--) {
			pop[i] = stack.pop();
		}
		boolean flag = true;
		for(int i=0; i<bomb.length();i++) {
			if(bomb.charAt(i)!=pop[i]) {
				flag = false;
				break;
			}
		}
		if(!flag) {
			for(int i=0; i<bomb.length(); i++) {
				stack.push(pop[i]);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		String input = br.readLine();
		bomb = br.readLine();
		stack = new Stack<>();
		
		for(int i=0; i<input.length(); i++) {
			stack.push(input.charAt(i));
			if(stack.peek()==bomb.charAt(bomb.length()-1) && stack.size()>=bomb.length()) {
				check();
			}
		}
		if(stack.size()==0) {
			System.out.println("FRULA");
		} else {
			char[] ans  = new char[stack.size()];
			for(int i=stack.size()-1; i>=0; i--) {
				ans[i] = stack.pop();
			}
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<ans.length; i++) {
				sb.append(ans[i]);
			}
			System.out.println(sb);
		}
	}
}
