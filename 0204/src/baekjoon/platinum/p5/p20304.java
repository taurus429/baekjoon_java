package baekjoon.platinum.p5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p20304 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int maxPass = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int shift = (int)(Math.log(maxPass)/Math.log(2))+1;
		String[] input = br.readLine().split(" ");
		Queue<Integer> queue = new LinkedList<Integer>();

		int[] num = new int[maxPass+1];
		int[] password = new int[m];
		for(int i=0; i<= maxPass; i++) {
			num[i] = -1;
		}
		for(int i=0; i<m; i++) {
			password[i] = Integer.parseInt(input[i]);
			num[password[i]] = 0;
			queue.add(password[i]);
		}
		int max=Integer.MIN_VALUE;
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			for(int i=0; i<shift; i++) {
				int candi = temp^(1<<i);
				if(candi<=maxPass&&num[candi]==-1) {
					num[candi] = num[temp]+1;
					queue.add(candi);
					if(max<num[candi]) {
						max = num[candi];
					}
				}
			}
		}
		System.out.println(max);
		
		
	
	}
}
