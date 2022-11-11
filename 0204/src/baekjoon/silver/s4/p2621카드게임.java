package baekjoon.silver.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class p2621카드게임 {
	static boolean isStraight(boolean[] exists) {
		boolean res = false;
		for(int i=1; i<=5; i++) {
			res |= (exists[i]&exists[i+1]&exists[i+2]&exists[i+3]&exists[i+4]);
		}
		return res;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		HashMap<String, Integer> colors = new HashMap<>();
		HashMap<Integer, Integer> nums = new HashMap<>();
		boolean[] exists = new boolean[10];
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			String color = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			if(colors.containsKey(color)) {
				colors.replace(color, colors.get(color)+1);
			} else {
				colors.put(color, 1);
			}
			if(nums.containsKey(num)) {
				nums.replace(num, nums.get(num)+1);
			} else {
				nums.put(num, 1);
			}
			exists[num] = true;
		}
		int maxColor = -1;
		for(Entry<String, Integer> e:colors.entrySet()) {
			maxColor = Math.max(maxColor, e.getValue());
		}
		int[][] inputNums = new int[nums.size()][2];
		int index = 0;
		for(Entry<Integer, Integer> e: nums.entrySet()) {
			inputNums[index][0] = e.getKey();
			inputNums[index++][1] = e.getValue();
		}
		Arrays.sort(inputNums, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
			
		});
		int[][] bigger = inputNums.clone();
		Arrays.sort(bigger, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
			
		});
		System.out.println(bigger[0][0]);
		//1.스티플
		if(maxColor==5&&isStraight(exists)) {
			System.out.println(900+bigger[0][0]);
		}
		//2.포카드
		else if (inputNums[0][1]==4) {
			System.out.println("포카드");
		}
		//3.풀하우스
		//4.플러쉬
		//5.스트레이트
		//6.트리플
		//7.투페어
		//8.페어
		//9.탑
	}
}
