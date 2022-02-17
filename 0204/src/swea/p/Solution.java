package swea.p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t < 11; t++) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<String> password = new ArrayList<String>();
			String[] input = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				password.add(input[i]);
			}
			int commandCnt = Integer.parseInt(br.readLine());
			int index = 1;
			String[] command = br.readLine().split(" ");
			for (int i = 0; i < commandCnt; i++) {
				int insertPos = Integer.parseInt(command[index]);
				int cnt = Integer.parseInt(command[index + 1]);
				for (int j = index + 1 + cnt; j >= index + 2; j--) {
					password.add(insertPos, command[j]);
				}
				index += (3 + cnt);
			}
			System.out.print("#"+t+" ");
			for (int k = 0; k < 10; k++) {
				System.out.print(password.get(k)+" ");
			}
			System.out.println();
		}
	}
}
