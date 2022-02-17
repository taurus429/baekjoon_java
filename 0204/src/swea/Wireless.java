package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Wireless {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] dx = new int[] { 0, 0, 1, 0, -1 }; //제자리 위 오른쪽 아래 왼쪽 순으로 움직이도록
	static int[] dy = new int[] { 0, -1, 0, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int time = Integer.parseInt(st.nextToken());
			int bc = Integer.parseInt(st.nextToken());
			String[] moveA = br.readLine().split(" "); //움직임 정보 미리 저장
			String[] moveB = br.readLine().split(" ");

			int[][][] grid = new int[10][10][bc+1]; //battery charger 보다 한개 많게
			for (int k = 0; k < bc; k++) {// 모든 battery charger에 대해
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken()) - 1;//배열 인덱스로 쓰기 위해 1감소
				int y = Integer.parseInt(st.nextToken()) - 1;
				int cover = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						if (Math.abs(x - j) + Math.abs(y - i) <= cover) {
							grid[j][i][k] = power; // 중심부 부터의 거리가 cover이하일 때 power 저장
						}
					}
				}
			}
			int[] posA = new int[] { 0, 0 };// 시작 위치 배열
			int[] posB = new int[] { 9, 9 };
			int maxSum = 0;//최대값 저장

			for (int k = -1; k < time; k++) {
				if (k != -1) { // 초기 값일때는 움직이지 않는다.
					int a = Integer.parseInt(moveA[k]);
					posA[0] += dy[a];
					posA[1] += dx[a];
					int b = Integer.parseInt(moveB[k]);
					posB[0] += dy[b];
					posB[1] += dx[b];
				}
				int max = 0;

				for (int i = 0; i < bc+1; i++) {
					for (int j = 0; j < bc+1; j++) { //2개의 charger 선택
						int sum = grid[posA[1]][posA[0]][i] + grid[posB[1]][posB[0]][j];
						if (i == j) { // 같은 charger 사용시
							sum /= 2;
						}
						if (sum > max) {// 최대값 갱신
							max = sum;
						}
					}
				}
				maxSum += max;//해당 스텝에서 최대값을 추가

			}
			System.out.println("#"+t+" "+maxSum);
		}
	}
}
