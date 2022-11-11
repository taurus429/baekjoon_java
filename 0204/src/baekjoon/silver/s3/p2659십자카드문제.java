package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p2659십자카드문제 {
	static int clockNum(int n1, int n2, int n3, int n4) {
		int[] nums = new int[4];
		nums[0] = n1*1000 + n2*100 + n3*10 + n4;
		nums[1] = n2*1000 + n3*100 + n4*10 + n1;
		nums[2] = n3*1000 + n4*100 + n1*10 + n2;
		nums[3] = n4*1000 + n1*100 + n2*10 + n3;
		Arrays.sort(nums);
		return nums[0];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] inputList = new int[4];
		inputList[0] = Integer.parseInt(st.nextToken());
		inputList[1] = Integer.parseInt(st.nextToken());
		inputList[2] = Integer.parseInt(st.nextToken());
		inputList[3] = Integer.parseInt(st.nextToken());
		int input = clockNum(inputList[0], inputList[1], inputList[2], inputList[3]);
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=1; i<10; i++) {
			for(int j=1; j<10; j++) {
				for(int k=1; k<10; k++) {
					for(int l=1; l<10; l++) {
						map.put(clockNum(i, j, k, l), 1);
					}
				}
			}
		}
		int[] clock = new int[map.keySet().size()];
		int index = 0;
		for(int i: map.keySet()) {
			clock[index++] = i;
		}
		Arrays.sort(clock);
		for(int i=0; i<clock.length; i++) {
			if(clock[i] == input) {
				System.out.println(i+1);
				break;
			}
		}
	}
}
