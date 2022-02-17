package swea.p1215_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int k = 0; k < 10; k++) {
			int t = Integer.parseInt(br.readLine());
			String input = br.readLine();
			String[] stringNumber = input.split(" ");
			int[] number = new int[8];
			for (int i = 0; i < 8; i++) {
				queue.add(Integer.parseInt(stringNumber[i]));
			}
			boolean res;
			do {
				res = cycle(number);
			} while (res);

			System.out.print("#"+t+" ");
			for(int e: queue) {
				System.out.print(e+" ");
			}
			System.out.println();
			queue.removeAll(queue);
		}
	}

	static boolean cycle(int[] number) {
		for (int i = 1; i <= 5; i++) {
			int temp = queue.poll() - i;
			if (temp <= 0) {
				temp = 0;
				queue.add(temp);
				return false;
			}
			queue.add(temp);
		}
		return true;
	}

}