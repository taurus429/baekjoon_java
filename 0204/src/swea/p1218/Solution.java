package swea.p1218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	static Stack<Character> stack = new Stack<Character>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = 0;
		for (int t = 1; t <= 10; t++) {
			len = Integer.parseInt(br.readLine());
			String input = br.readLine();
			System.out.print("#"+t+" ");
			if(checkline(input)) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
	}

	static boolean checkline(String input) {
		char temp;
		for (int i = 0; i < input.length(); i++) {
			char sel = input.charAt(i);
			switch (sel) {
			case '(':
			case '[':
			case '{':
			case '<':
				stack.push(sel);
				break;
			case ')':
				temp = stack.pop();
				if (temp != '(') {
					return false;
				}
				break;
			case ']':
				temp = stack.pop();
				if (temp != '[') {
					return false;
				}
				break;
			case '}':
				temp = stack.pop();
				if (temp != '{') {
					return false;
				}
				break;
			case '>':
				temp = stack.pop();
				if (temp != '<') {
					return false;
				}
				break;
			}
		}
		return true;
	}
}
