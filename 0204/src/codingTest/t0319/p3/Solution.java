package codingTest.t0319.p3;

import java.awt.Cursor;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	static class Res {
		int[][] b;
		int m;
		int cnt;

		public Res(int[][] b, int m, int cnt) {
			super();
			this.b = b.clone();
			this.m = m;
			this.cnt = cnt;
		}

	}

	static int compare(int[][] a, int[][] b) {
		int cnt = 0;
		for (int[] posA : a) {
			for (int[] posB : b) {
				if ((posA[0] == posB[0] && posA[1] == posB[1]) || posA[1] == posB[0] && posA[0] == posB[1]) {
					cnt++;
					break;
				}
			}
		}
		return cnt;
	}

	static void change(int[][] b, int num1, int num2) {
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				if (b[i][j] == num1) {
					b[i][j] = num2;
				} else if (b[i][j] == num2) {
					b[i][j] = num1;
				}
			}
		}
	}

	static boolean duplicated(int[][] b) {
		for (int i = 0; i < b.length - 1; i++) {
			for (int j = i + 1; j < b.length; j++) {
				if ((b[i][0] == b[j][0] && b[i][1] == b[j][1]) || (b[i][1] == b[j][0] && b[i][0] == b[j][1])) {
					return true;
				}
			}
		}
		return false;
	}
	static void print(int[][]a) {
		for(int[] s: a) {
			System.out.println(Arrays.toString(s));
		}
		System.out.println();
	}
	static void clone(int[][] temp, int[][] b) {
		for(int i=0; i<temp.length; i++) {
			temp[i] = b[i].clone();
		}
	}
	public static int solution(int[][] a, int[][] b, int m) {
		int N = a.length + 1;
		Queue<Res> queue = new LinkedList<Res>();
		queue.offer(new Res(b, m, 0));
		while (!queue.isEmpty()) {
			Res cur = queue.poll();
			int curScore = compare(a, cur.b);
			//print(b);
			if(curScore==N-1) {
				System.out.println(cur.cnt-(m-cur.m));
				break;
			}
			if (cur.m > 0) {
				for (int i = 1; i < N; i++) {
					for (int j = i + 1; j < N + 1; j++) {
						change(cur.b, i, j);
						if (compare(a, cur.b) >= curScore) {
							int[][] temp = new int[cur.b.length][];
							clone(temp, b);
							queue.offer(new Res(temp, cur.m - 1, cur.cnt + 1));
						}
						change(cur.b, i, j);
					}
				}
			}
			for (int i = 0; i < b.length; i++) {
				int origin0 = cur.b[i][0];
				int origin1 = cur.b[i][1];
				for (int j = 1; j <= N; j++) {
					if (cur.b[i][1] != j&& cur.b[i][0] != j) {
						cur.b[i][0] = j;
						if(!duplicated(cur.b)&&compare(a, cur.b) > curScore) {
							int[][] temp = new int[cur.b.length][];
							clone(temp, cur.b);
							queue.offer(new Res(temp, cur.m, cur.cnt + 1));
						}
						cur.b[i][0] = origin0;
						
						cur.b[i][1] = j;
						if(!duplicated(cur.b)&&compare(a, cur.b) > curScore) {
							int[][] temp = new int[cur.b.length][];
							clone(temp, cur.b);
							queue.offer(new Res(temp, cur.m - 1, cur.cnt + 1));
						}
						cur.b[i][1] = origin1;
					}
				}
			}
		}
		int answer = -1;
		return answer;
	}

	public static void main(String[] args) {
		solution(new int[][] {{1,2}, {2,3}}, new int[][] {{1,3},{3,2}}, 1);
//		solution(new int[][] { { 1, 2 }, { 3, 1 }, { 2, 4 }, { 3, 5 } },
//				new int[][] { { 2, 1 }, { 4, 1 }, { 2, 5 }, { 3, 2 } }, 1);
//		solution(new int[][] { { 3, 4 }, { 7, 2 }, { 5, 4 }, { 2, 3 }, { 6, 5 }, { 1, 2 } },
//				new int[][] { { 2, 1 }, { 3, 6 }, { 1, 4 }, { 1, 5 }, { 7, 1 }, { 3, 2 } }, 2);
//	Res cur = new Res(new int[][] { { 3, 4 }, { 7, 2 }, { 5, 4 }, { 2, 3 }, { 6, 5 }, { 1, 2 } }, 0, 0);
//	cur.b[0][1] = 100;
//	print(cur.b);
	}
}