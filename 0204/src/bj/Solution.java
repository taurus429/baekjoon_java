package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] input1 = "2455384,2086240,2444682,2427417,2386606,2417368,2406995,2401111,2385149,2373288,2363197,2356940,2345919,2302408,2280263,2252860,2231670,2211491,2181553,2153989".split(",");
		String[] input2 = "2211491, 2231670, 2252860, 2302408, 2319995, 2345919, 2363197, 2373288, 2401111, 2406995, 2417368".split(", ");
		boolean[] b = new boolean[input1.length];
		for(int i=0; i<b.length; i++) {
			b[i] = true;
		}
		for(int i= input1.length-1; i>=0; i--) {
			for(int j=0; j<input2.length; j++) {
				if(input1[i].equals(input2[j])) {
					b[i] = false;
				}
			}
		}
		for(int i=0; i<input1.length; i++) {
			if(b[i])
			System.out.println(input1[i]);
		}
	}
}
