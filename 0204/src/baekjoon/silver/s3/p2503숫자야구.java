package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class p2503숫자야구 {
	static boolean check(int answer, int guess, int strike, int ball) {
		int firstNum = answer / 100;
		int secondNum = (answer / 10) % 10;
		int thirdNum = answer % 10;
		int guessFirst = guess / 100;
		int guessSecond = (guess / 10) % 10;
		int guessThird = guess % 10;
		int[] res = new int[2];
		if (firstNum == guessFirst) {
			res[0]++;
		} else if (firstNum == guessSecond || firstNum == guessThird) {
			res[1]++;
		}
		if (secondNum == guessSecond) {
			res[0]++;
		} else if (secondNum == guessFirst || secondNum == guessThird) {
			res[1]++;
		}
		if (thirdNum == guessThird) {
			res[0]++;
		} else if (thirdNum == guessSecond || thirdNum == guessFirst) {
			res[1]++;
		}
		if (res[0] == strike && res[1] == ball) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if (i != j) {
					for (int k = 1; k < 10; k++) {
						if (k != i && k != j) {
							map.put(i * 100 + j * 10 + k, 1);
						}
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int guess = Integer.parseInt(st.nextToken());
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());
			ArrayList<Integer> removeList = new ArrayList<>();
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				if (!check(entry.getKey(), guess, strike, ball)) {
					removeList.add(entry.getKey());
				}
			}
			for(Integer removeKey: removeList) {
				map.remove(removeKey);
			}
		}
		System.out.println(map.size());
	}
}
