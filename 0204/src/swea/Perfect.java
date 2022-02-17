package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Perfect {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int testcase = Integer.parseInt(br.readLine());
		for(int t=1; t<= testcase; t++) {
			int card = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			ArrayList<String> suff = new ArrayList<>();
			int front = card - card/2;
			for(int i=0; i<front; i++) {
				suff.add(input[i]);
			}
			int index= 1;
			for(int i=front; i<card; i++) {
				suff.add(index, input[i]);
				index+=2;
			}
			System.out.print("#"+t+" ");
			for(String e: suff) {
				System.out.print(e+" ");
			}
			System.out.println();
		}
	}
}
