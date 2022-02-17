package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class p2605 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> answer = new ArrayList<>();
		int cnt = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		
		for(int i=1; i<=cnt; i++) {
			answer.add(Integer.parseInt(input[i-1]), i);
		}
		for(int i=cnt-1; i>=0; i--) {
			System.out.print(answer.get(i)+" ");
		}
	}
}
