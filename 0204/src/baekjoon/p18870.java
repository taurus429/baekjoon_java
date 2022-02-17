package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class p18870 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] stringInput = br.readLine().split(" ");
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(stringInput[i]);
		}
		int[] inputCopy = input.clone();
		Arrays.sort(input);
		int index = 0;
		
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < input.length; i++) {
			if (i == 0) {
				map.put(input[i], index++);
			} else {
				if (input[i] != input[i - 1]) {
					map.put(input[i], index++);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
        for (int i : inputCopy)
            sb.append(map.get(i)).append(' ');

        System.out.println(sb.toString());
	}
}
