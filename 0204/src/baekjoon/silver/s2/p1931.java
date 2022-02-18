package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1931 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static class Meeting implements Comparable<Meeting>{
		int start;
		int end;
		@Override
		
		public int compareTo(Meeting o) {
			// TODO Auto-generated method stub
			return this.end!=o.end? this.end - o.end:this.start - o.start;
		}
		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int cnt = Integer.parseInt(br.readLine());
		Meeting[] m = new Meeting[cnt];
		for(int i=0; i<cnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			m[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(m);
		int endTime = 0;
		int meet = 0;
		for(int i=0; i<cnt; i++) {
			if(m[i].start>=endTime) {
				endTime = m[i].end;
				meet++;
			}
		}
		System.out.println(meet);
	}
}
