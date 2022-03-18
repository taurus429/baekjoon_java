package codingTest.samsungA.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean[] place;
	static int N, min;
	static boolean[] permu;
	static int[] visited;
	static int[][] gate;
	static class Res {
		int move;
		boolean[] place;

		public Res(int move, boolean[] place) {
			super();
			this.move = move;
			this.place = place.clone();
		}

	}

	static int findEmpty(int idx, boolean[] place) {
		if (place[idx]) {
			return 1;
		}
		int i = 1;
		boolean left = false;
		boolean right = false;
		while (true) {
			if (idx - i >= 0 && place[idx - i]) {
				left = true;
			}
			if (idx + i < N && place[idx + i]) {
				right = true;
			}
			if (left || right)
				break;
			i++;
		}
		return i + 1;
	}

	static ArrayList<Res> opengate(ArrayList<Res> input, int[] gate) {
		ArrayList<Res> ret = new ArrayList<>();
		for (Res r : input) {
			int move = r.move;
			boolean[] place = r.place;
			for (int i = 0; i < gate[1] - 1; i++) {
				int dist = findEmpty(gate[0], place);
				move += dist;
				if (gate[0] + (dist - 1) < N && place[gate[0] + (dist - 1)]) {
					place[gate[0] + (dist - 1)] = false;
				} else {
					place[gate[0] - (dist - 1)] = false;
				}
			}
			int dist = findEmpty(gate[0], place);
			if (gate[0] + (dist - 1) < N && gate[0] - (dist - 1) >= 0 && 
					place[gate[0] + (dist - 1)] && place[gate[0] - (dist - 1)]) {
				boolean[] lplace = place.clone();
				boolean[] rplace = place.clone();
				lplace[gate[0] - (dist - 1)] = false;
				rplace[gate[0] + (dist - 1)] = false;
				move += dist;
				ret.add(new Res(move, rplace));
				ret.add(new Res(move, lplace));
			} else {
				move += dist;
				if (gate[0] + (dist - 1) < N && place[gate[0] + (dist - 1)]) {
					place[gate[0] + (dist - 1)] = false;
				} else {
					place[gate[0] - (dist - 1)] = false;
				}
				ret.add(new Res(move, place));
			}
		}
		return ret;
	}
	static void permutate(int cnt) {
		if(cnt==3) {
			ArrayList<Res> input = new ArrayList<>();
			input.add(new Res(0, place));
			input = opengate(input, gate[visited[0]]);
			
			input = opengate(input, gate[visited[1]]);
		
			input = opengate(input, gate[visited[2]]);
			for(Res r: input) {
				min = Math.min(min, r.move);
			}
			return;
		}
		for(int i=0; i<3; i++) {
			if(!permu[i]) {
				permu[i] = true;
				visited[i] = cnt;
				permutate(cnt+1);
				permu[i] = false;
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			N = Integer.parseInt(br.readLine());
			place = new boolean[N];
			Arrays.fill(place, true);
			gate = new int[3][2];
			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine());
				gate[i] = new int[] { Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) };
			}
			ArrayList<Res> input = new ArrayList<>();

			permu = new boolean[3];
			visited = new int[3];
			min = Integer.MAX_VALUE;
			permutate(0);
			System.out.println("#"+t+" "+min);
		}
	}
}
