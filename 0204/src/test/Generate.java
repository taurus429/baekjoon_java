package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Generate {
	static boolean[] check;

	static void binary(int[] t, int target) {
		int start = 0;
		int end = t.length;
		while (start < end) {
			int mid = start + (end-start)/2;
			if(t[mid]>=target) {
				end = mid;
			}
			else {
				start = mid + 1;
			}
		}
		System.out.println(start);
	}
	static void binary2(int[] t, int target) {
		int start = 0;
		int end = t.length;
		while (start < end) {
			int mid = start + (end-start)/2;
			if(t[mid]>target) {
				start = mid+1;
			}
			else {
				end = mid;
			}
		}
		System.out.println(start);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] t = new int[] {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 4, 4, 4, 4, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 9, 10, 10, 10, 11};
		int[] b = new int[] {9, 9, 9, 9, 9, 8, 8, 8, 8, 8, 7, 7, 6, 6, 6, 6, 5, 4, 4, 4, 4, 3, 3, 3, 3, 2, 1, 0, 0, 0, -1};
//		binary(t, 1);
//		binary(t, 2);
//		binary(t, 3);
//		binary(t, 4);
//		binary(t, 5);
//		binary(t, 6);
//		binary(t, 7);
//		binary(t, 8);
//		binary(t, 9);
//		binary(t, 10);
//		binary(t, 11);
		binary2(b, 1);
		binary2(b, 2);
		binary2(b, 3);
		binary2(b, 4);
		binary2(b, 5);
		binary2(b, 6);
		binary2(b, 7);
		binary2(b, 8);
		binary2(b, 9);
		binary2(b, 10);
		binary2(b, 11);
	}
}
