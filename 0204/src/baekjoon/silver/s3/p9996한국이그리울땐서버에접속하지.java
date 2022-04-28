package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p9996한국이그리울땐서버에접속하지 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), "*");
		String prefix = st.nextToken();
		String suffix = st.nextToken();
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			if(input.startsWith(prefix)) {
				input = input.substring(prefix.length());
				if(input.endsWith(suffix)) {
					System.out.println("DA");
				} else {
					System.out.println("NE");
				}
			}else {
				System.out.println("NE");
			}
		}
	}
}
