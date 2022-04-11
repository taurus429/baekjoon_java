package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1022소용돌이예쁘게출력하기 {
	static int[][] ans;
	static int height, width, startI, startJ;
	static void draw(int len, int pos, int idx) {
		if(len==1) {
			if(startI<=pos&&pos<startI+height+1&&startJ<=pos&&pos<startJ+width+1) {
				ans[pos-startI][pos-startJ] = idx;
			}
			return;
		}
		int posI= pos;
		int posJ = pos;
		for(int i=0; i<len-1; i++) {
			if(startI<=posI&&posI<startI+height+1&&startJ<=posJ&&posJ<startJ+width+1) {
				ans[posI-startI][posJ-startJ] = idx;
			}
			posJ--; idx--;
		}
		for(int i=0; i<len-1; i++) {
			if(startI<=posI&&posI<startI+height+1&&startJ<=posJ&&posJ<startJ+width+1) {
				ans[posI-startI][posJ-startJ] = idx;
			}
			posI--; idx--;
		}
		for(int i=0; i<len-1; i++) {
			if(startI<=posI&&posI<startI+height+1&&startJ<=posJ&&posJ<startJ+width+1) {
				ans[posI-startI][posJ-startJ] = idx;
			}
			posJ++; idx--;
		}
		for(int i=0; i<len-1; i++) {
			if(startI<=posI&&posI<startI+height+1&&startJ<=posJ&&posJ<startJ+width+1) {
				ans[posI-startI][posJ-startJ] = idx;
			}
			posI++; idx--;
		}
		draw(len-2, posI-1, idx);
	}
	static int digit(int num) {
		int res = 0;
		int n =0;
		while(num/(int)Math.pow(10, n)!=0) {
			res ++;
			n ++;
		}
		return res;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		int N = Math.max(Math.abs(r1), Math.max(Math.abs(r2), Math.max(Math.abs(c1), Math.abs(c2))));
		int len = 2*N +1;
		width = c2 - c1;
		height = r2 - r1;
		startI = r1+N;
		startJ = c1+N;
		ans = new int[height+1][width+1];
		draw(len, len-1, len*len);
		int maxdigit = 0;
		for(int i= 0; i<height+1; i++) {
			for(int j=0; j<width+1; j++) {
				maxdigit = Math.max(maxdigit, digit(ans[i][j]));
			}
		}
		for(int i= 0; i<height+1; i++) {
			for(int j=0; j<width+1; j++) {
				if(j!=0) {
					System.out.print(" ");
				}
				int digit = digit(ans[i][j]);
				for(int k=0; k<maxdigit-digit; k++) {
					System.out.print(" ");
				}
				System.out.print(ans[i][j]);
			}
			System.out.println();
		}
	}
}
