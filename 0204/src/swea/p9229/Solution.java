package swea.p9229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			String[] input = br.readLine().split(" ");
			int snack = Integer.parseInt(input[0]);
			int limit = Integer.parseInt(input[1]);
			input = br.readLine().split(" ");
			int[] snacks = new int[snack];
			for (int i = 0; i < snack; i++) {
				snacks[i] = Integer.parseInt(input[i]);
			}
			int sum =0;
			int maximum=Integer.MIN_VALUE;
			for(int i=0; i<snack-1; i++) {
				for(int j=i+1; j<snack; j++) {
					sum = snacks[i] + snacks[j];
					if(sum>maximum && sum<=limit) {
						maximum = sum;
					}
				}
			}
			if(maximum==Integer.MIN_VALUE) {				
				System.out.println("#"+ t+" "+-1);
			}else {				
				System.out.println("#"+ t+" "+maximum);
			}
			maximum =0;
		}

	}
}
