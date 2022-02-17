package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1592 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int L = Integer.parseInt(input[2]);
		int start = 0;
		int[] friend = new int [N];
		int cnt=0;
		while(true) {
			if(friend[start]%2==1) {
				start = (start+L)%N;
				friend[start]++;
				cnt++;
				if(friend[start]==M) {
					break;
				}
			}else{
				start = (start-L+N)%N;
				friend[start]++;
				cnt++;
				if(friend[start]==M) {
					break;
				}
			}
		}
		System.out.println(cnt-1);
	}
}
