package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1759 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] combination; // 조합 인덱스 저장을 위한 배열
	static int C;
	static int L;
	static boolean[] gather; // 모음을 표시하기 위한 배열
	static String[] candidate; //비번이 될 수 있는 모든 문자를 저장
	
	static void combi(int cnt, int startIdx) {// 배열을 생성하는 메서드
		if(cnt == L) {
			check();//배열 생성후 체크 메서드 호출
			return;
		}
		for(int i= startIdx; i<C; i++) {
			combination[cnt] = i;
			combi(cnt+1, i+1);
		}
	}
	static void check() {
		int consonant = 0;//자음과 모음 개수 0으로 초기화
		int gatherCount =0;
		for(int i=0; i<L; i++) {//만들어진 인덱스 조합에서 자음 모음 카운트
			if(gather[combination[i]]) {
				gatherCount++;
			}else {
				consonant++;
			}
		}
		if(consonant>1&&gatherCount>0) {//조건 만족시 출력
			print();
		}
	}
	static void print() {// 출력함수
		for(int i=0; i<L; i++) {
			System.out.print(candidate[combination[i]]);
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		gather = new boolean[C];
		combination = new int[L];
		
		st = new StringTokenizer(br.readLine());
		
		candidate = new String[C];
		for (int i = 0; i < C; i++) {
			candidate[i] = st.nextToken();
				
		}
		Arrays.sort(candidate);
		for(int i=0; i<C; i++) {
			if (candidate[i].charAt(0) == 'a' || candidate[i].charAt(0) == 'e' || candidate[i].charAt(0) == 'i'
					|| candidate[i].charAt(0) == 'o' || candidate[i].charAt(0) == 'u') {
				gather[i] = true;
			}			
		}

		combi(0, 0);
	}
}
