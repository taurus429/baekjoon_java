package baekjoon.bronze.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class p2309 {
	static int[] combi;
	static int n;
	static ArrayList<int[]> combis = new ArrayList<>();
	static void generateCombi(int cnt, int start) {
		if (cnt == n) {
			combis.add(combi.clone());
			return;
		}
		for(int i=start; i<9; i++) {
			combi[cnt] = i;
			generateCombi(cnt+1, i+1);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		ArrayList<Integer> men = new ArrayList<>();
		int []answer = new int[7];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i =0; i<9; i++) {
			men.add(Integer.parseInt(br.readLine()));
		}
		n=7;
		combi = new int[n];
		generateCombi(0, 0);
		int sum =0;
		for(int[] c: combis) {
			for(int index: c) {
				sum += men.get(index);
			}
			if(sum==100) {
				int i=0;
				for(int index: c) {
					answer[i++] = men.get(index);
				}
				break;
			}
			sum =0;
		}
		Arrays.sort(answer);
		for(int i: answer) {
			System.out.println(i);
		}
	}
}
