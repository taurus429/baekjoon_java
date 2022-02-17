package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p2628 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		int width = Integer.parseInt(input[0]);
		int height = Integer.parseInt(input[1]);
		boolean[] widthCut = new boolean[height+1];//종이 끝 부분도 잘린 부분이므로 크기 1 추가
		boolean[] heightCut = new boolean[width+1];
		widthCut[height] = true;//종이 끝 부분도 잘림 표시
		heightCut[width] = true;
		
		int line = Integer.parseInt(br.readLine());
		for(int i=0; i<line; i++) {
			input = br.readLine().split(" ");
			if(input[0].equals("0")) {//가로 컷
				widthCut[Integer.parseInt(input[1])] = true;//잘렸을 때 true 표시
			}else {//세로 컷
				heightCut[Integer.parseInt(input[1])] = true;
			}
		}
		int widthMax = 0;// 가로 부분 최대 길이를 0으로 초기화
		int widthLen = 0;// 현재 가로 길이를 0으로
		for(int i=0; i<=width; i++) {
			if(heightCut[i]) {//잘린 부분을 만나면
				if(widthMax<widthLen) {
					widthMax = widthLen;//최대값 갱신
				}
				widthLen = 0;//현재 가로 길이 다시 0으로
			}
			widthLen += 1;
		}
		int heightMax = 0;
		int heightLen = 0;
		for(int i=0; i<=height; i++) {
			if(widthCut[i]) {
				if(heightMax<heightLen) {
					heightMax = heightLen;
				}
				heightLen = 0;
			}
			heightLen += 1;
		}
		System.out.println(heightMax*widthMax);
	}
}
