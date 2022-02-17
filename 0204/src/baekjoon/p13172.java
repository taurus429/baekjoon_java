package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p13172 {
	static long getGcd(long a, long b) {
		if(b>a) {
			long temp = a;
			a= b;
			b= temp;
		}
		while(b!=0) {
			long temp = a;
			a = b;
			b = temp % b;
		}
		return a;
	}
	static long getMod(long b, long x, long prime) {
		if(x==1) {
			return b;
		}else {
			if(x%2==0) {
				long res = getMod(b, x/2, prime);
				return ((res%prime)*(res%prime))%prime;
			}else {
				return b*getMod(b, x-1, prime)%prime;
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		long sum =0;
		long prime = 1000000007;
		for(int i=0; i<len; i++) {
			String[] input = br.readLine().split(" ");
			long son =  Long.parseLong(input[0]);
			long mother = Long.parseLong(input[1]);
			long gcd = getGcd(son, mother);
			son /= gcd;
			mother /= gcd;
			sum += getMod(son, prime-2, prime)*mother%prime;
			sum %= prime;
		}
		System.out.println(sum);
	}
}