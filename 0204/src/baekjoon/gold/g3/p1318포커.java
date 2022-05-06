package baekjoon.gold.g3;

import java.util.Arrays;

public class p1318포커 {
	static boolean[] card = new boolean[52];
	static int[] res = new int[12];
	static int cnt;

	static boolean isPair() {
		int num[] = new int[13];
		for (int i = 0; i < 52; i++) {
			if (card[i])
				num[i % 13]++;
		}
		Arrays.sort(num);
		if (num[12] == 2)
			return true;
		return false;
	}

	static boolean isTwoPair() {
		int num[] = new int[13];
		for (int i = 0; i < 52; i++) {
			if (card[i])
				num[i % 13]++;
		}
		Arrays.sort(num);
		if (num[12] == 2 && num[11] == 2)
			return true;
		return false;
	}

	static boolean isTriple() {
		int num[] = new int[13];
		for (int i = 0; i < 52; i++) {
			if (card[i])
				num[i % 13]++;
		}
		Arrays.sort(num);
		if (num[12] == 3)
			return true;
		return false;
	}

	static boolean isStraight() {
		int num[] = new int[13];
		for (int i = 0; i < 52; i++) {
			if (card[i])
				num[i % 13]++;
		}

		for (int i = 1; i <= 8; i++) {
			if (num[i + 0] >= 1 && num[i + 1] >= 1 && num[i + 2] >= 1 && num[i + 3] >= 1 && num[i + 4] >= 1)
				return true;
		}
		return false;
	}

	static boolean isBackStraight() {
		int num[] = new int[13];
		for (int i = 0; i < 52; i++) {
			if (card[i])
				num[i % 13]++;
		}
		if (num[0] >= 1 && num[1] >= 1 && num[2] >= 1 && num[3] >= 1 && num[4] >= 1)
			return true;
		return false;
	}

	static boolean isMountain() {
		int num[] = new int[13];
		for (int i = 0; i < 52; i++) {
			if (card[i])
				num[i % 13]++;
		}
		if (num[0] >= 1 && num[9] >= 1 && num[10] >= 1 && num[11] >= 1 && num[12] >= 1)
			return true;
		return false;
	}

	static boolean isFlush() {
		int num[] = new int[4];
		for (int i = 0; i < 52; i++) {
			if (card[i])
				num[i / 13]++;
		}
		Arrays.sort(num);
		if (num[3] >= 5)
			return true;
		return false;
	}

	static boolean isFullHouse() {
		int num[] = new int[13];
		for (int i = 0; i < 52; i++) {
			if (card[i])
				num[i % 13]++;
		}
		Arrays.sort(num);
		if (num[12] == 3 && num[11] >= 2)
			return true;
		return false;
	}

	static boolean isFourCard() {
		for (int i = 0; i < 13; i++) {
			if (card[i] && card[i + 13] && card[i + 26] && card[i + 39]) {
				return true;
			}
		}
		return false;
	}

	static boolean isStraightFlush() {
		boolean res = false;
		for (int i = 0; i < 4; i++) {
			int shape = i * 13;
			for (int num = 1; num <= 8; num++) {
				if (card[shape + num] && card[shape + num + 1] && card[shape + num + 2] && card[shape + num + 3]
						&& card[shape + num + 4]) {
					return true;
				}
			}
		}
		return res;
	}

	static boolean isRoyalStraightFlush() {
		boolean res = false;
		for (int i = 0; i < 4; i++) {
			int tmp = i * 13;
			if (card[tmp] && card[tmp + 1] && card[tmp + 2] && card[tmp + 3] && card[tmp + 4]) {
				res = true;
				break;
			}
		}
		return res;
	}

	static void check() {
		cnt++;
		if (isRoyalStraightFlush()) {
			res[11]++;
		} else if (isStraightFlush()) {
			res[10]++;
		} else if (isFourCard()) {
			res[9]++;
		} else if (isFullHouse()) {
			res[8]++;
		} else if (isFlush()) {
			res[7]++;
		} else if (isMountain()) {
			res[6]++;
		} else if (isBackStraight()) {
			res[5]++;
		} else if (isStraight()) {
			res[4]++;
		} else if (isTriple()) {
			res[3]++;
		} else if (isTwoPair()) {
			res[2]++;
		} else if (isPair()) {
			res[1]++;
		} else {
			res[0]++;
		}

	}

	static void combi(int idx, int cnt) {
		if (cnt == 6) {
			check();
			return;
		}
		for (int i = idx; i < 52; i++) {
			card[i] = true;
			combi(i + 1, cnt + 1);
			card[i] = false;
		}
	}

	static int gcd(int a, int b) {
		if (b > a) {
			int temp = a;
			a = b;
			b = temp;
		}
		while (b != 0) {
			int temp = a;
			a = b;
			b = temp % b;
		}
		return a;
	}

	public static void main(String[] args) {
		combi(0, 0);
		for(int i=0; i<12; i++) {
			int g = gcd(cnt, res[i]);
			System.out.println(res[i]/g+"/"+(cnt/g));
		}
	}
}
