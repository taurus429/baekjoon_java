package codingTest.t0319.p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
	public static String[] solution(String[] goods) {
		int maxlen = 0;
		ArrayList<String>[] ans = new ArrayList[goods.length];
		for (int i = 0; i < goods.length; i++) {
			ans[i] = new ArrayList<String>();
			maxlen = Math.max(maxlen, goods[i].length());
		}
		boolean[] checked = new boolean[goods.length];

		HashMap<String, Integer> dict = new HashMap<>();
		for (int t = 1; t <= maxlen; t++) {
			for (String good : goods) {
				HashSet<String> set = new HashSet<>();
				for (int i = 0; i < good.length() - t + 1; i++) {
					if (i + t > good.length())
						break;
					String search = good.substring(i, i + t);
					set.add(search);
				}
				for (String s : set) {
					if (dict.containsKey(s)) {
						dict.replace(s, dict.get(s) + 1);
					} else {
						dict.put(s, 1);
					}
				}
			}
			for (int i = 0; i < goods.length; i++) {
				if (!checked[i]) {
					HashSet<String> set = new HashSet<>();
					for (int j = 0; j < goods[i].length() - t + 1; j++) {
						if (j + t > goods[i].length())
							break;
						String search = goods[i].substring(j, j + t);
						set.add(search);
					}
					for (String s : set) {
						if (dict.get(s) == 1) {
							ans[i].add(s);
							checked[i] = true;
						}
					}
				}

			}
			int cnt = 0;
			for (int i = 0; i < goods.length; i++) {
				if (ans[i].size() != 0) {
					cnt++;
				}
			}
			if (cnt == goods.length) {
				break;
			}
		}
		String[] answer = new String[goods.length];
		for (int i = 0; i < goods.length; i++) {
			if (ans[i].size() != 0) {
				StringBuilder sb = new StringBuilder();
				Collections.sort(ans[i]);
				for (String a : ans[i]) {
					sb.append(a + " ");
				}
				answer[i] = sb.toString();
			} else {
				answer[i] = "None";
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		//String[] goods = new String[] { "pencil", "cilicon", "contrabase", "picturelist" };
		String[] goods = new String[] { "abcdeabcd","cdabe","abce","bcdeab" };
		String[] ans = solution(goods);
		for(String a: ans) {
			System.out.println(a);
		}

	}
}