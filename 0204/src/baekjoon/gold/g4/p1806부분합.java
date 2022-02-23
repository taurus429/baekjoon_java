package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1806부분합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int sum = Integer.parseInt(st.nextToken());
		int[] sumArray = new int[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<N+1; i++) {
			sumArray[i] = sumArray[i-1] + Integer.parseInt(st.nextToken());
		}
		int startPoint =0;
		int endPoint = 0;
		int minLenght = Integer.MAX_VALUE;
		while(endPoint<N+1&&startPoint<N+1) {
			if(sumArray[endPoint]-sumArray[startPoint]<sum) {
				endPoint ++;
			}  else {
				if(endPoint - startPoint< minLenght) {
					minLenght = endPoint - startPoint;
				}
				startPoint++;
			}
		}
		if(minLenght == Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(minLenght);
		}
	}
}
