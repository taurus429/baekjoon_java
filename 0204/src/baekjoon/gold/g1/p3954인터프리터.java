package baekjoon.gold.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class p3954인터프리터 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			st = new StringTokenizer(br.readLine());
			int memLen = Integer.parseInt(st.nextToken());
			int codeLen = Integer.parseInt(st.nextToken());
			int inputLen = Integer.parseInt(st.nextToken());
			int[] mem = new int[memLen];
			String code = br.readLine();
			String input = br.readLine();
			int codePtr = 0;
			int inputPtr = 0;
			int memPtr = 0;
			Stack<Integer> stack = new Stack<>();
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < code.length(); i++) {
				if (code.charAt(i) == '[') {
					stack.push(i);
				} else if (code.charAt(i) == ']') {
					int end = i;
					int start = stack.pop();
					map.put(start, end + 1);
					map.put(end, start + 1);
				}
			}

			int p = 0;
			boolean loop = false;
			while (true) {
				if (codePtr >= codeLen) {
					System.out.println("Terminates");
					break;
				}
				if (p == 50000000) {
					loop = true;
					break;
				}
				char op = code.charAt(codePtr);
				switch (op) {
				case '-':
					mem[memPtr]--;
					if (mem[memPtr] < 0)
						mem[memPtr] = 255;
					codePtr++;
					break;
				case '+':
					mem[memPtr]++;
					if (mem[memPtr] > 255)
						mem[memPtr] = 0;
					codePtr++;
					break;
				case '<':
					memPtr--;
					if (memPtr < 0)
						memPtr = memLen - 1;
					codePtr++;
					break;
				case '>':
					memPtr++;
					if (memPtr >= memLen)
						memPtr = 0;
					codePtr++;
					break;
				case '[':
					if (mem[memPtr] == 0) {
						codePtr = map.get(codePtr);
					} else {
						codePtr++;
					}
					break;
				case ']':
					if (mem[memPtr] != 0)
						codePtr = map.get(codePtr);
					else
						codePtr++;
					break;
				case '.':
					codePtr++;
					break;
				case ',':
					if (inputPtr < inputLen)
						mem[memPtr] = input.charAt(inputPtr++);
					else
						mem[memPtr] = 255;
					codePtr++;
					break;
				default:
					break;
				}
				p++;
			}
			if(loop) {
				p = 0;
				int maxPtr = codePtr;
				int minPtr = codePtr;
				while (true) {
					if (p == 50000000) {
						loop = true;
						break;
					}
					char op = code.charAt(codePtr);
					switch (op) {
					case '-':
						mem[memPtr]--;
						if (mem[memPtr] < 0)
							mem[memPtr] = 255;
						codePtr++;
						break;
					case '+':
						mem[memPtr]++;
						if (mem[memPtr] > 255)
							mem[memPtr] = 0;
						codePtr++;
						break;
					case '<':
						memPtr--;
						if (memPtr < 0)
							memPtr = memLen - 1;
						codePtr++;
						break;
					case '>':
						memPtr++;
						if (memPtr >= memLen)
							memPtr = 0;
						codePtr++;
						break;
					case '[':
						if (mem[memPtr] == 0) {
							codePtr = map.get(codePtr);
						} else {
							codePtr++;
						}
						break;
					case ']':
						if (mem[memPtr] != 0)
							codePtr = map.get(codePtr);
						else
							codePtr++;
						break;
					case '.':
						codePtr++;
						break;
					case ',':
						if (inputPtr < inputLen)
							mem[memPtr] = input.charAt(inputPtr++);
						else
							mem[memPtr] = 255;
						codePtr++;
						break;
					default:
						break;
					}
					p++;
					maxPtr = Math.max(maxPtr, codePtr);
					minPtr = Math.min(minPtr, codePtr);
				}
				System.out.println("Loops "+(minPtr-1)+" "+maxPtr);
			}
			
		}
	}
}
