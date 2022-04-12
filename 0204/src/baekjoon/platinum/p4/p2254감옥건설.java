package baekjoon.platinum.p4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class p2254감옥건설 {
	static long ccw(int[] A, int[] B, int[] C) {
		return ((long) B[1] - (long) A[1]) * ((long) C[0] - (long) A[0])
				- ((long) B[0] - (long) A[0]) * ((long) C[1] - (long) A[1]);
	}
	static boolean isInside(int[] p, ArrayList<int[]> res) {
		res.add(res.get(0));
		for(int i=0; i<res.size()-1; i++) {
			if(ccw(res.get(i), res.get(i+1), p)<=0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Px = Integer.parseInt(st.nextToken());
		int Py = Integer.parseInt(st.nextToken());
		int ans = 0;
		ArrayList<int[]> point = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			point.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}
		while (point.size()>=4) {
			Collections.sort(point, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					if (o1[1] != o2[1]) {
						return o1[1] - o2[1];
					} else {
						return o1[0] - o2[0];
					}
				}

			});

			Collections.sort(point, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					if (((long) o1[1] - (long) point.get(0)[1])
							* ((long) o2[0] - (long) point.get(0)[0]) < ((long) o1[0] - (long) point.get(0)[0])
									* ((long) o2[1] - (long) point.get(0)[1]))
						return -1;
					else if (((long) o1[1] - (long) point.get(0)[1])
							* ((long) o2[0] - (long) point.get(0)[0]) > ((long) o1[0] - (long) point.get(0)[0])
									* ((long) o2[1] - (long) point.get(0)[1]))
						return 1;
					else if (o1[0] != o2[0])
						return o1[1] - o2[1];
					else
						return o1[0] - o2[0];
				}
			});

			Stack<int[]> stack = new Stack<>();
			stack.push(point.get(0));
			stack.push(point.get(1));
			for (int i = 2; i < point.size(); i++) {
				int[] second = stack.pop();
				int[] first = stack.pop();
				int[] third = point.get(i);
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
			int[] third = point.get(0);
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
			boolean inside = isInside(new int[] {Px,Py}, res);
			if (!inside) {
				break;
			}
			ans ++;
			for(int[] r: res) {
				for(int i=point.size()-1; i>=0; i--) {
					if(r[0]==point.get(i)[0]&&r[1]==point.get(i)[1]) {
						point.remove(point.get(i));
						break;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
