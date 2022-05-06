package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p1062가르침 {
	static char[] res;
	static int K, N;
	static String[] word;
	static ArrayList<Character> candidate;
	static HashMap<Character, Integer>[] map;
	static int ans;
	static void check() {
		int result = 0;
		for(int i=0; i<N; i++) {
			int cnt =0;
			for(char r : res) {
				if(map[i].containsKey(r)) {
					cnt++;
				}
			}
			if(cnt == map[i].size()) {
				result ++;
			}
		}
		ans = Math.max(ans, result);
	}
	static void combi(int cnt, int idx) {
		if(cnt == K) {
			check();
			return;
		}
		
		for(int i=idx; i<candidate.size(); i++) {
			res[cnt] = candidate.get(i);
			combi(cnt +1, i+1);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		word = new String[N];
		candidate = new ArrayList<>();
		map = new HashMap[N];
		for(int i=0; i<N; i++) {
			map[i] = new HashMap<>();
		}
		for(int i=0; i<N; i++) {
			word[i] = br.readLine();
			word[i] = word[i].substring(4, word[i].length()-4);
			for(int j=0; j<word[i].length(); j++) {
				if(word[i].charAt(j)!='a'&&word[i].charAt(j)!='c'&&word[i].charAt(j)!='i'&&word[i].charAt(j)!='n'&&word[i].charAt(j)!='t') {
					map[i].put(word[i].charAt(j), 1);
					if(!candidate.contains(word[i].charAt(j))) {
						candidate.add(word[i].charAt(j));
					}
				}
			}
		}
		if(K>=candidate.size()+5) {
			System.out.println(N);
			return;
		}
		K = K-5;
		if(K<0) {
			System.out.println(0);
			return;
		}
		res = new char[K];
		combi(0, 0);
		System.out.println(ans);
	}
}
