package toss.p2;

import java.util.Arrays;

class Solution {

	static public int solution(int[] levels) {
		Arrays.sort(levels);
		if (levels.length > 3) {
			int index = levels.length - levels.length / 4;
			return levels[index];
		} else {
			return -1;
		}

	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 6, 12, 3}));
	}
}