package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class calc {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		for(int t=1; t<=10; t++) {
			int len = Integer.parseInt(br.readLine());
			String input = br.readLine();
			Stack<Character> oper = new Stack<>();
			Queue<Character> queue = new LinkedList<Character>();
			for(int i=0; i<len; i++) {
				char temp = input.charAt(i);
				switch (temp) {
				case '+':
					while(!oper.isEmpty()&&(oper.peek()=='*')){
						queue.offer(oper.pop());
					}
					if(!oper.isEmpty()&&(oper.peek()=='+')) {
						queue.offer(oper.pop());
					}
					oper.push(temp);
					break;
				case '*':
					if(!oper.isEmpty()&&(oper.peek()=='*')) {
						queue.offer(oper.pop());
					}
					oper.push(temp);
					break;
				case '(':
					oper.push(temp);
					break;
				case ')':
					while(oper.peek()!='(') {
						queue.offer(oper.pop());
					}
					oper.pop();
					break;

				default:
					queue.offer(temp);
					break;
				}
			}
			while(!oper.isEmpty()) {
				queue.offer(oper.pop());				
			}
			Stack<Integer> numStack = new Stack<Integer>();
			Stack<Character> operStack = new Stack<Character>();
			
			while(!queue.isEmpty()) {
				char temp = queue.poll();
				if(temp=='+'||temp=='*') {
					operStack.push(temp);
				}else {
					numStack.push(temp-48);
				}
				while(numStack.size()>=2 && operStack.size()>=1) {
					char oper1 = operStack.pop();
					int num1 = numStack.pop();
					int num2 = numStack.pop();
					switch (oper1) {
					case '+':
						numStack.push(num1+num2);
						break;
					case '*':
						numStack.push(num1*num2);
						break;

					default:
						break;
					}
				}
			}
			System.out.println("#"+t+" "+numStack.peek());
			
		}
	}
}
