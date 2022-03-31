package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class p17140이차원배열과연산 {
	static int width = 3, height = 3;
	static int[][] grid = new int[100][100];

	static void calc() {
		if (height >= width) {// 행정렬
			int newWidth = 0;
			for (int i = 0; i < height; i++) {
				HashMap<Integer, Integer> map = new HashMap<>();
				for (int j = 0; j < width; j++) {
					if(grid[i][j]==0)
						continue;
					if (map.containsKey(grid[i][j])) {
						map.replace(grid[i][j], map.get(grid[i][j]) + 1);
					} else {
						map.put(grid[i][j], 1);
					}
					grid[i][j] = 0;
				}
				ArrayList<int[]> temp = new ArrayList<>();
				for (Map.Entry<Integer, Integer> m : map.entrySet()) {
					temp.add(new int[] { m.getKey(), m.getValue() });
				}
				
				Collections.sort(temp, new Comparator<int[]>() {

					@Override
					public int compare(int[] o1, int[] o2) {
						// TODO Auto-generated method stub
						if (o1[1] == o2[1]) {
							return o1[0] - o2[0];
						} else {
							return o1[1] - o2[1];
						}
					}

				});
				Queue<Integer> queue = new LinkedList<Integer>();
				for(int[] t: temp) {
					queue.add(t[0]);
					queue.add(t[1]);
				}
				int idx = 0;
				while(!queue.isEmpty()&&idx<100) {
					grid[i][idx] = queue.poll();
					idx ++;
					newWidth = Math.max(newWidth, idx);
				}
			}
			width = newWidth;
		} else { //열정렬
			int newHeight = 0;
			for (int j = 0; j < width; j++) {
				HashMap<Integer, Integer> map = new HashMap<>();
				for (int i = 0; i < height; i++) {
					if(grid[i][j]==0)
						continue;
					if (map.containsKey(grid[i][j])) {
						map.replace(grid[i][j], map.get(grid[i][j]) + 1);
					} else {
						map.put(grid[i][j], 1);
					}
					grid[i][j] = 0;
				}
				ArrayList<int[]> temp = new ArrayList<>();
				for (Map.Entry<Integer, Integer> m : map.entrySet()) {
					temp.add(new int[] { m.getKey(), m.getValue() });
				}
				
				Collections.sort(temp, new Comparator<int[]>() {

					@Override
					public int compare(int[] o1, int[] o2) {
						// TODO Auto-generated method stub
						if (o1[1] == o2[1]) {
							return o1[0] - o2[0];
						} else {
							return o1[1] - o2[1];
						}
					}

				});
				Queue<Integer> queue = new LinkedList<Integer>();
				for(int[] t: temp) {
					queue.add(t[0]);
					queue.add(t[1]);
				}
				int idx = 0;
				while(!queue.isEmpty()&&idx<100) {
					grid[idx][j] = queue.poll();
					idx ++;
					newHeight = Math.max(newHeight, idx);
				}
			}
			height = newHeight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken())-1;
		int c = Integer.parseInt(st.nextToken())-1;
		int k = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(grid[r][c]==k) {
			System.out.println(0);
			return;
		}
		for(int i=1; i<=100; i++) {
			calc();
			if(grid[r][c]==k) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
		return;
	}
}
