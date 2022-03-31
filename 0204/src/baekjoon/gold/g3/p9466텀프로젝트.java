package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p9466텀프로젝트 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		for(int t=1; t<=testcase; t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] before = new int[N];
			int[] direct = new int[N];
			
			for(int i=0; i<N; i++) {
				int temp = Integer.parseInt(st.nextToken())-1;
				direct[i] = temp;
				before[temp] ++;
			}
			Queue<Integer> queue = new LinkedList<Integer>();
			for(int i=0; i<N; i++) {
				if(before[i]==0) {
					queue.offer(i);
				}
			}
			
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				before[direct[cur]] --;
				if(before[direct[cur]]==0) {
					queue.offer(direct[cur]);
				}
			}
			int cnt =0;
			for(int i=0; i<N; i++) {
				if(before[i]==0)
					cnt++;
			}
			System.out.println(cnt);
		}
	}
}
