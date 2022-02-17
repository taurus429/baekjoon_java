import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static void boy(int[] switchArray, int num) {
		for(int i= 1;num*i-1 < switchArray.length;i++) {
			switchArray[num*i-1] ^= 1;
		}
	}
	static void girl(int[] switchArray, int num) {
		int left = num-1;
		int right = num-1;
		while (left>=0 && right<switchArray.length && ((switchArray[left]^switchArray[right]) == 0)) {
			left--;
			right++;
		}
		System.out.println(left);
		System.out.println(right);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int switchCount = Integer.parseInt(br.readLine());
		int[] switchArray = new int[switchCount];
		String[] input = br.readLine().split(" ");
		for(int i=0; i<switchCount; i++) {
			switchArray[i] = Integer.parseInt(input[i]);
		}
		
		int student = Integer.parseInt(br.readLine());
		boy(switchArray, 3);
		for(int i=0; i<switchCount; i++) {
			System.out.print(switchArray[i]);
		}
		
//		for(int i=0; i<student; i++) {
//			input = br.readLine().split(" ");
//			
//		}
	}
}
