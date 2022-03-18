package codingTest.p1;

import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	static void fillMoney(int day, int money, int[] dayMoney) {
		for (int i = day; i < day + 30; i++) {
			if (i >= 365) {
				return;
			}
			dayMoney[i] += money;
		}
	}

	public static int[] solution(String[] purchase) {
		int[] mountCount = new int[] { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };
		int[] dayMoney = new int[365];
		for (int i = 0; i < purchase.length; i++) {
			StringTokenizer st = new StringTokenizer(purchase[i]);
			StringTokenizer st2 = new StringTokenizer(st.nextToken(), "/");
			st2.nextToken();
			int month = Integer.parseInt(st2.nextToken());
			int day = Integer.parseInt(st2.nextToken());
			int money = Integer.parseInt(st.nextToken());
			fillMoney(mountCount[month - 1] + day - 1, money, dayMoney);
			System.out.println(mountCount[month - 1] + day - 1);
		}
		int[] answer = new int[5];
		for (int i = 0; i < 365; i++) {
			if(dayMoney[i]>=100000) {
				answer[4] ++;
			}else if(dayMoney[i]>=50000) {	
				answer[3] ++;
			}else if(dayMoney[i]>=20000) {	
				answer[2] ++;
			}else if(dayMoney[i]>=10000) {	
				answer[1] ++;
			}else{	
				answer[0] ++;
			}
				
		}
		return answer;
	}

	public static void main(String[] args) {
//		String[] purchase = new String[] { "2019/01/30 5000", "2019/04/05 10000", "2019/06/10 20000", "2019/08/15 50000", "2019/12/01 100000" };
		String[] purchase = new String[] { "2019/12/31 100000" };
		System.out.println(Arrays.toString(solution(purchase)));
	}
}