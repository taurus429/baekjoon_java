package baekjoon.silver.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1358하키 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int ans = 0;
		for(int i=0; i<P; i++) {
			st= new StringTokenizer(br.readLine());
			int posX = Integer.parseInt(st.nextToken());
			int posY = Integer.parseInt(st.nextToken());
			if(X<=posX&&posX<=X+W&&Y<=posY&&posY<=Y+H) {
				ans ++;
			} else if(Math.pow((X-posX), 2)+Math.pow((Y+H/2-posY), 2)<=Math.pow(H/2, 2)) {
				ans ++;
			} else if(Math.pow((X+W-posX), 2)+Math.pow((Y+H/2-posY), 2)<=Math.pow(H/2, 2)) {
				ans ++;
			}  
		}
		System.out.println(ans);
	}
}
