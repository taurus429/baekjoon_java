package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Card {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean[] visited = new boolean[9];
	static int[] p = new int[9];
	static int[] myCard;
	static int[] iCard;
	static int[] card = new int[9];
	static int win =0;
	static int lose =0;
	
	static void game(int[] myCard, int[] iCard) {
		int myScore = 0;
		int iScore = 0;
		for(int i=0; i<9; i++) {
			if(myCard[i]>iCard[i]) {
				myScore += (myCard[i] + iCard[i]);
			} else {
				iScore += (myCard[i] + iCard[i]);
			}
		}
		if(myScore>iScore) {
			win ++;
		}else if(myScore<iScore) {
			lose ++;
		}
	}
	static void permutate(int cnt) {
		if(cnt==9) {
			for(int i=0; i<9; i++) {
				card[i] = iCard[p[i]];
			}
			game(myCard, card);
		}
		for(int i=0; i<9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				p[cnt] = i;
				permutate(cnt+1);
				visited[i] = false;
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int testcase = Integer.parseInt(br.readLine());
		for(int t=1; t<=testcase; t++) {
			String[] input = br.readLine().split(" ");
			win =0;
			lose =0;
			myCard = new int[9];
			iCard = new int[9];
			boolean[] mask = new boolean[19];
			for(int i=0; i<9; i++) {
				myCard[i] = Integer.parseInt(input[i]);
				mask[myCard[i]] = true;
			}
			int index=0;
			for(int i=1; i<19; i++) {
				if(!mask[i]) {
					iCard[index++] = i;
				}
			}
			permutate(0);
			System.out.println("#"+t+ " "+win +" " + lose);
		}
	}
}
