package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2527 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		for (int t = 0; t < 4; t++) {
			String[] input = br.readLine().split(" ");
			int startX1 = Integer.parseInt(input[0]);
			int startY1 = Integer.parseInt(input[1]);
			int endX1 = Integer.parseInt(input[2]);
			int endY1 = Integer.parseInt(input[3]);
			int startX2 = Integer.parseInt(input[4]);
			int startY2 = Integer.parseInt(input[5]);
			int endX2 = Integer.parseInt(input[6]);
			int endY2 = Integer.parseInt(input[7]);
			
			//먼저 d인 경우 처리
			if(endX1<startX2||endX2<startX1||endY1<startY2||endY2<startY1) {
				System.out.println("d");
			}else if((startX1==endX2)&&(startY1==endY2)||(startX1==endX2)&&(endY1==startY2)||(endX1==startX2)&&(endY1==startY2)||(startX2==endX1)&&(endY2==startY1)) {
				//꼭지점 겹치는 4가지 경우
				System.out.println("c");
			}else if(startX1==endX2||startX2==endX1||startY1==endY2||startY2==endY1) {
				//선분 겹치는 경우
				System.out.println("b");
			}else {
				System.out.println("a");
			}
			
		}
	}
}
