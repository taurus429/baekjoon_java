package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class p15686 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int getDist(int[] a, int[] b) {
		return Math.abs(a[0] - b[0])+Math.abs(a[1] - b[1]);
	}
	static int[] minList;
	static int chickenDist = Integer.MAX_VALUE;
	static int m;
	static ArrayList<int[]> chicken;
	static ArrayList<int[]> house;
	static int[] com;
	
	static void combi(int cnt, int index) {
		if(cnt == m) {
			for(int i=0; i<house.size(); i++) {
				minList[i] = Integer.MAX_VALUE;
			}
			for(int i=0; i<house.size(); i++) {
				int[] h = house.get(i);
				for(int j=0; j<m; j++) {
					int[] c = chicken.get(com[j]);
					if(getDist(h, c)<minList[i]) {
						minList[i] = getDist(h, c);
					}
				}
			}
			int sum =0;
			for(int m: minList) {
				sum+= m;
			}
			if(sum<chickenDist) {
				chickenDist = sum;
			}
			return;
		}
		for(int i= index; i<chicken.size(); i++) {
			com[cnt] = i;
			combi(cnt+1, i+1);
		}
	}
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		chicken = new ArrayList<>();
		house = new ArrayList<>();
		com = new int[m];
		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				if (input[j].equals("1")) {
					house.add(new int[] { i, j });
				} else if(input[j].equals("2")) {
					chicken.add(new int[] {i, j});
				}
			}
		}
		minList = new int[house.size()];
		combi(0, 0);
		

		System.out.println(chickenDist);
	}
}
