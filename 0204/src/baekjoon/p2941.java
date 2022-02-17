package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2941 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String input = br.readLine();
		String[] prefix = new String[] {"c=","c-","dz=","d-","lj","nj","s=","z="};
		int cnt =0;
		while(input.length()!=0) {
			boolean found = false;
			for(String pre : prefix) {
				if(input.startsWith(pre)) {
					cnt++;
					input = input.substring(pre.length());
					found = true;
					break;
				}
			}
			if(!found) {
				cnt++;
				input = input.substring(1);
			}
		}
		System.out.println(cnt);
	}
}
