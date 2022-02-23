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
	static int chickenDist = Integer.MAX_VALUE; // 정답을 저장하기 위한 변수
	static int m;
	static ArrayList<int[]> chicken;
	static ArrayList<int[]> house;
	static int[] com;
	
	static void combi(int cnt, int index) {
		if(cnt == m) { // 조합이 완성되었을 경우
			for(int i=0; i<house.size(); i++) {
				minList[i] = Integer.MAX_VALUE; //치킨거리 최악값으로 초기화
			}
			for(int i=0; i<house.size(); i++) {
				int[] h = house.get(i); //모든 집 정보에 대해서
				for(int j=0; j<m; j++) { // 선택된 조합의 모든 치킨 집에 대해서
					int[] c = chicken.get(com[j]);
					if(getDist(h, c)<minList[i]) {//거리가 기존 치킨 거리보다 작을 경우
						minList[i] = getDist(h, c);//갱신
					}
				}
			}
			int sum =0;
			for(int m: minList) {//모든 집의 치킨거리를 sum에 합산
				sum+= m;
			}
			if(sum<chickenDist) {//이 조합의 치킨거리가 최소일 경우 갱신
				chickenDist = sum;
			}
			return;
		}
		for(int i= index; i<chicken.size(); i++) { //for 구문을 돌면서 m개 크기의 조합 생성
			com[cnt] = i;
			combi(cnt+1, i+1);
		}
	}
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		chicken = new ArrayList<>(); //치킨집을 담기 위한 리스트
		house = new ArrayList<>(); //집을 담기 위한 리스트
		com = new int[m]; //조합 인덱스 저장을 위한 배열
		
		for (int i = 0; i < n; i++) { // 치킨집을 경우엔 치킨집 리스트, 집일 경우 집 리스트에 저장
			input = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				if (input[j].equals("1")) {
					house.add(new int[] { i, j });
				} else if(input[j].equals("2")) {
					chicken.add(new int[] {i, j});
				}
			}
		}
		minList = new int[house.size()]; //각 집에서의 최소 치킨 거리 저장을 위한 배열
		combi(0, 0);//조합 메서드 실행
		

		System.out.println(chickenDist);
	}
}
