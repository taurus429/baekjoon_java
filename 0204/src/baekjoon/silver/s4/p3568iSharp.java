package baekjoon.silver.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p3568iSharp {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String front = st.nextToken();
		StringBuilder sb = new StringBuilder();
		while(true) {
			String temp = st.nextToken();
			int end = 0;
			for(int i=0; i<temp.length(); i++) {
				if(temp.charAt(i)=='['||temp.charAt(i)=='*'||temp.charAt(i)=='&') {
					end = i;
					break;
				}
			}
			if(end == 0) {
				sb.append(front+" "+temp.substring(0, temp.length()-1)+";\n");
			}else {
				sb.append(front);
				for(int i=temp.length()-2; i>=end; i--) {
					if(temp.charAt(i)=='[') {
						sb.append(']');
					}else if(temp.charAt(i)==']') {
						sb.append('[');
					}else
					sb.append(temp.charAt(i));
				}
				sb.append(" "+temp.substring(0,end)+";\n");
			}
			if(temp.charAt(temp.length()-1)==';')
				break;
			
		}
		System.out.println(sb);
	}
}
