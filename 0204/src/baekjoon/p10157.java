package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10157 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int width = Integer.parseInt(input[0]);
		int height = Integer.parseInt(input[1]);
		int myNum = Integer.parseInt(br.readLine());
		if(myNum>width*height) {
			System.out.println(0);
			return;
		}
		int startNum = 1;
		int startI = 1;
		int startJ = 1;
		int range = 2 * width + 2 * height - 4;
		while (true) {
			if (startNum <= myNum && myNum < startNum + range)// 범위 내에 존재
			{ break;
			}
			else {
				width -= 2;
				height -= 2;
				startNum += range;
				startI ++;
				startJ ++;
				range = 2 * width + 2 * height - 4;
			}
		}
		if(startNum == myNum) 
		System.out.println(startJ+" "+startI);
		for(int i=0; i<height-1; i++) {
			startI++;
			startNum++;
			if(startNum == myNum) {
				System.out.println(startJ+" "+startI);
				return;
			}
		}
		for(int i=0; i<width-1; i++) {
			startJ++;
			startNum++;
			if(startNum == myNum) {
				System.out.println(startJ+" "+startI);
				return;
			}
		}
		for(int i=0; i<height-1; i++) {
			startI--;
			startNum++;
			if(startNum == myNum) {
				System.out.println(startJ+" "+startI);
				return;
			}
		}
		for(int i=0; i<width-1; i++) {
			startJ--;
			startNum++;
			if(startNum == myNum) {
				System.out.println(startJ+" "+startI);
				return;
			}
		}
	}
}
