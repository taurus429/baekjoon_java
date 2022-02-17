package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class p1918 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		Stack<Character> oper = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			char infix = input.charAt(i);
			switch (infix) {
			case '+':
			case '-':
				while (!oper.isEmpty()) {
					if(oper.peek()=='(') break;
					System.out.print(oper.pop());
				}
				oper.push(infix);
				break;
			case '*':
			case '/':
				if (!oper.isEmpty()) {
					while (oper.peek() == '*' || oper.peek() == '/') {
						if(oper.peek()=='(') break;
						System.out.print(oper.pop());
						if (oper.isEmpty())
							break;
					}
				}
				oper.push(infix);
				break;
			case '(':
				oper.push(infix);
				break;
			case ')':
				while (oper.peek() != '(')
					System.out.print(oper.pop());
				oper.pop();
				break;
			default:
				System.out.print(infix);
				break;
			}
		}
		while (!oper.isEmpty()) {
			System.out.print(oper.pop());
		}
	}
}
