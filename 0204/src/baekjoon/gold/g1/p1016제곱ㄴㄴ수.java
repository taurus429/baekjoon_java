package baekjoon.gold.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p1016제곱ㄴㄴ수 {
	
	static ArrayList<Integer> find(){
		ArrayList<Integer> prime = new ArrayList<>();
		prime.add(2);
		for(int i=3; i<1000001; i++) {
			int x = (int) Math.sqrt(i);
			for(int p: prime) {
				if(x<p) {
					prime.add(i);
					break;
				}
				if(i%p==0)
					break;
			}
		}
		return prime;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		boolean[] notprime = new boolean[(int) (max-min+(long)1)];
		ArrayList<Integer> prime = find();
		int count = 0;
		for(int p: prime) {
			long powP = (long) Math.pow(p, 2);
			long mul = (min/powP)+1;
			if(min%powP==0) {
				mul--;
			}
			int i = 0;
			while((mul+i)*powP<=max) {
				notprime[(int) ((mul+i)*powP-min)] = true;
				i++;
			}
		}
		for(int i=0; i<max-min+1; i++) {
			if(notprime[i])
				count++;
		}
		System.out.println(max-min+1-count);
	}
}
