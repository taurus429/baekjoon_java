package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2263 {
	static int[] post;
	static int[] in;
	static void preOrder(int inStart, int inEnd, int postStart, int postEnd) {
		
		int middle = post[postEnd];
		System.out.print(post[postEnd]+" ");
		int index = -1;
		for (int i = 0; i < in.length; i++) {
			if (in[i] == middle) {
				index = i;
				break;
			}
		}
		int len = inEnd - inStart;
		int leftLen = index - inStart;
		int rightLen = len - leftLen;
		if (leftLen > 1) {
			preOrder(inStart, inStart+leftLen -1, postStart, postStart +leftLen -1);
		}
		if(leftLen== 1) {
			System.out.print(post[postStart]+" ");
		}
		if (rightLen > 1) {
			preOrder(inStart+leftLen +1,inEnd, postStart +leftLen, postEnd-1);
		}
		if(rightLen == 1) {
			System.out.print(post[postEnd-1]+" ");
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int len = Integer.parseInt(br.readLine());
		in = new int[len];
		post = new int[len];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < len; i++) {
			in[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < len; i++) {
			post[i] = Integer.parseInt(st.nextToken());
		}
		preOrder(0, len-1,0 ,len-1);
	}
}
