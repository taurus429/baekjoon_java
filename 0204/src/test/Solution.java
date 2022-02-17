package test;


import java.io.IOException;
import java.util.Arrays;


public class Solution {
	static int[][] getCombi(int n){
		int len = n*(n-1)/2;
		int cnt =0;
		int[][] res = new int[len][];
		for(int i=0; i<n-1; i ++) {
			for(int j=i+1; j<n; j++) {
				res[cnt] = new int[] {i,j};
				cnt++;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[][] res = getCombi(3);
		for(int[] r: res) {
			System.out.println(Arrays.toString(r));			
		}
	}
}