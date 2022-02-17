package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p13300 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		int people = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());
		
		int[][] room = new int[2][6];
		for(int i=0; i<people; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			room[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())-1] ++;
		}
		int sum =0;
		for(int i=0; i<2; i++) {
			for(int j=0; j<6; j++) {
				if(room[i][j]!=0) {
					sum += (room[i][j]-1)/max +1;
				}
			}
		}
		System.out.println(sum);
	}
}
