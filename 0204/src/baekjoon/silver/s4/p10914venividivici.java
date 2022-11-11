package baekjoon.silver.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10914venividivici {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(st.hasMoreElements()) {
			String curStr = st.nextToken();
			for(int i=0; i<curStr.length()-1; i+=2) {
				int char1 = curStr.charAt(i)-97;
				int char2 = curStr.charAt(i+1)-97;
				char newchar = (char) ((char1+char2-N)%26+97);
				sb.append(newchar);
			}
			sb.append(" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
