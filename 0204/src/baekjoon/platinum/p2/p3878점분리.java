package baekjoon.platinum.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class p3878점분리 {
	static long ccw(int[] A, int[] B, int[] C) {
		return ((long) B[1] - (long) A[1]) * ((long) C[0] - (long) A[0])
				- ((long) B[0] - (long) A[0]) * ((long) C[1] - (long) A[1]);
	}
	static int ccw2(int[] p1, int[] p2, int[] p3) {
		return (long)p1[0]*(long)p2[1] + (long)p2[0]*(long)p3[1] + (long)p3[0]*(long)p1[1] -(long)p1[1]*(long)p2[0] - (long)p2[1]*(long)p3[0] - (long)p3[1]*(long)p1[0] < 0 ? 1: -1;
	}
	static boolean isInside(int[] p, ArrayList<int[]> res) {
		ArrayList<int[]> temp = (ArrayList<int[]>) res.clone();
		temp.add(res.get(0));
		for(int i=0; i<temp.size()-1; i++) {
			if(ccw(temp.get(i), temp.get(i+1), p)<0) {
				return false;
			}
		}
		return true;
	}
	static ArrayList<int[]> getArea(int[][] point){
		Arrays.sort(point, new Comparator<int[]>() {

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
		Arrays.sort(point, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (((long) o1[1] - (long) point[0][1])
						* ((long) o2[0] - (long) point[0][0]) < ((long) o1[0] - (long) point[0][0])
								* ((long) o2[1] - (long) point[0][1]))
					return -1;
				else if (((long) o1[1] - (long) point[0][1])
						* ((long) o2[0] - (long) point[0][0]) > ((long) o1[0] - (long) point[0][0])
								* ((long) o2[1] - (long) point[0][1]))
					return 1;
				else if (o1[0] != o2[0])
					return o1[1] - o2[1];
				else
					return o1[0] - o2[0];
			}
		});
		Stack<int[]> stack = new Stack<>();
		stack.push(point[0]);
		stack.push(point[1]);
		for (int i = 2; i < point.length; i++) {
			int[] second = stack.pop();
			int[] first = stack.pop();
			int[] third = point[i];
			if (ccw(first, second, third) < 0) {
				stack.push(first);
				stack.push(second);
				stack.push(third);
			} else {
				while (!stack.isEmpty() && ccw(first, second, third) >= 0) {
					second = first;
					first = stack.pop();
				}
				stack.push(first);
				stack.push(second);
				stack.push(third);
			}
		}
		int[] second = stack.pop();
		int[] first = stack.pop();
		int[] third = point[0];
		while (ccw(first, second, third) >= 0) {
			second = first;
			first = stack.pop();
		}
		stack.push(first);
		stack.push(second);

		ArrayList<int[]> res = new ArrayList<>();
		int len = stack.size();
		for (int i = 0; i < len; i++)
			res.add(stack.pop());

		return res;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			boolean ans = false;
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int[][] black = new int[b][2];
			int[][] white = new int[w][2];
			for (int i = 0; i < b; i++) {
				st = new StringTokenizer(br.readLine());
				black[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			}
			for (int i = 0; i < w; i++) {
				st = new StringTokenizer(br.readLine());
				white[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			}
			if(b==1&&w==1) {
				ans = true;
			} else if (b==1&&w==2) {
				if(ccw(black[0], white[0], white[1])==0&&(white[1][0]-black[0][0])*(white[0][0]-black[0][0])<=0) {
					ans =false;
				} else {
					ans = true;
				}
			} else if (w==1&&b==2) {
				if(ccw(white[0], black[0], black[1])==0&&(black[1][0]-white[0][0])*(black[0][0]-white[0][0])<=0) {
					ans = false;
				} else {
					ans = true;
				}
			} else if (b<3&&w>=3) {
				ans = true;
				ArrayList<int[]> whitearea = getArea(white);
				for(int i=0; i<b; i++)
					ans &= !isInside(black[i], whitearea);
			} else if (w<3&&b>=3) {
				ans = true;
				ArrayList<int[]> blackarea = getArea(black);
				for(int i=0; i<w; i++)
					ans &= !isInside(white[i], blackarea);
			} else if (b==2&&w==2) {
				if(ccw(black[0], black[1], white[0])*ccw(black[0], black[1], white[1])<0&&
						ccw(white[0], white[1], black[0])*ccw(white[0], white[1], black[1])<0) {
					ans = false;
				} else if((ccw(black[0], black[1], white[0])==0&&(black[0][0]-white[0][0])*(black[1][0]-white[0][0])<=0)||
						(ccw(black[0], black[1], white[1])==0&&(black[0][0]-white[1][0])*(black[1][0]-white[1][0])<=0)||
						(ccw(white[0], white[1], black[0])==0&&(white[0][0]-black[0][0])*(white[1][0]-black[0][0])<=0)||
						(ccw(white[0], white[1], black[1])==0&&(white[0][0]-black[1][0])*(white[1][0]-black[1][0])<=0)){
					ans = false;
				}else {
					ans = true;
				}
			} else {
				ArrayList<int[]> blackarea = getArea(black);
				ArrayList<int[]> whitearea = getArea(white);
				ans = true;
				for(int i=0; i<blackarea.size(); i++) {
					ans &= !isInside(blackarea.get(i), whitearea);
				}
				for(int i=0; i<whitearea.size(); i++) {
					ans &= !isInside(whitearea.get(i), blackarea);
				}
			}
			if(ans) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
}
