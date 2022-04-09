package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class p3020개똥벌레 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		Integer[] up = new Integer[N/2];
		Integer[] down = new Integer[N/2];
		for(int i=0; i<N; i++) {
			if(i%2==0) {
				up[i/2] = Integer.parseInt(br.readLine());
			} else {
				down[i/2] = Integer.parseInt(br.readLine());
			}
		}
		Arrays.sort(up, Collections.reverseOrder());
		Arrays.sort(down, Collections.reverseOrder());
		int[] upcount = new int[H];
		int idx = 0;
		for(int i=H; i>0; i--) {
			while(idx<N/2&&up[idx]==i) {
				idx ++;
			}
			upcount[i-1] = idx;
		}
		int[] downcount = new int[H];
		idx = 0;
		for(int i=H; i>0; i--) {
			while(idx<N/2&&down[idx]==i) {
				idx ++;
			}
			downcount[i-1] = idx;
		}
		int[] hit = new int[H];
		for(int i=0; i<H; i++) {
			hit[i] = upcount[i] + downcount[H-i-1];
		}
		Arrays.sort(hit);
		int min = hit[0];
		idx = 0;
		int cnt = 0;
		while(min == hit[idx]) {
			cnt ++;
			idx++;
		}
		System.out.println(min+" "+cnt);
	}
}
