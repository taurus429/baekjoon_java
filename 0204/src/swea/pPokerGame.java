package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pPokerGame {
	static boolean isStraight(int[] num) {
		boolean res = false;
		for(int i=0; i<9; i++) {
			if(num[i]*num[i+1]*num[i+2]*num[i+3]*num[i+4]==1)
				return true;
		}
		if(num[0]*num[9]*num[10]*num[11]*num[12]==1)
			return true;
		return res;
	}
	static boolean isFlush(int[] kind) {
		for(int i=0; i<4; i++) {
			if(kind[i]==5)
				return true;
		}
		return false;
	}
	static boolean isFullhouse(int[] num) {
		boolean pair = false;
		boolean triple = false;
		for(int i=0; i<13; i++) {
			if(num[i]==2) {
				pair = true;
			} else if(num[i] == 3) {
				triple = true;
			}
		}
		return pair&triple;
	}
	static boolean isFour(int[] num) {
		for(int i=0; i<13; i++) {
			if(num[i]==4)
				return true;
		}
		return false;
	}
	static boolean isTriple(int[] num) {
		boolean triple = false;
		for(int i=0; i<13; i++) {
			if(num[i] == 3) {
				triple = true;
			}
		}
		return triple;
	}
	static int countPair(int[] num) {
		int cnt = 0;
		for(int i=0; i<13; i++) {
			if(num[i] == 2) {
				cnt ++;
			}
		}
		return cnt;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			st = new StringTokenizer(br.readLine());
			String[] card = new String[5];
			for(int i=0; i<5; i++) {
				card[i] = st.nextToken();
			}
			int[] num = new int[13];
			int[] kind = new int[4];
			for(int j=0; j<5; j++) {
				char k = card[j].charAt(0);
				char n = card[j].charAt(1);
				if(50<=n&&n<=57) {
					num[n-49]++;
				}else {
					switch (n) {
					case 'A':
						num[0]++;
						break;
					case 'T':
						num[9]++;
						break;
					case 'J':
						num[10]++;
						break;
					case 'Q':
						num[11]++;
						break;
					case 'K':
						num[12]++;
						break;
					}
				}
				switch (k) {
				case 'S':
					kind[0]++;
					break;
				case 'D':
					kind[1]++;
					break;
				case 'H':
					kind[2]++;
					break;
				case 'C':
					kind[3]++;
					break;
				}
			}
			if(isStraight(num)&&isFlush(kind)) {
				System.out.println("#"+t+" Straight Flush");
			} else if(isFour(num)){
				System.out.println("#"+t+" Four of a Kind");
			} else if(isFullhouse(num)) {
				System.out.println("#"+t+" Full House");
			} else if(isFlush(kind)) {
				System.out.println("#"+t+" Flush");
			} else if(isStraight(num)) {
				System.out.println("#"+t+" Straight");
			} else if(isTriple(num)) {
				System.out.println("#"+t+" Three of a kind");
			} else if(countPair(num)==2) {
				System.out.println("#"+t+" Two pair");
			} else if(countPair(num)==1) {
				System.out.println("#"+t+" One pair");
			} else {
				System.out.println("#"+t+" High card");
			}
		}
	}
}
