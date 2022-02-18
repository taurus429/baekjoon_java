package baekjoon.bronze.b3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p10817 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		int[] nums = new int[3];
		for(int i=0; i<3; i++) {
			nums[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(nums);
		System.out.println(nums[1]);
	}
}
