package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10158 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		int height = Integer.parseInt(input[0]);
		int width = Integer.parseInt(input[1]);
		input = br.readLine().split(" ");
		int startI = Integer.parseInt(input[0]);
		int startJ = Integer.parseInt(input[1]);
		int hour = Integer.parseInt(br.readLine());
		int hourI = hour%(height*2);
		int hourJ = hour%(width*2);
		if(hourI>=(height - startI)+height) {
			startI =hourI - ((height - startI)+height);			
		}else if(hourI >= (height - startI)) {
			startI =height-( hourI - (height - startI));
		}else {
			startI += hourI;
		}
		if(hourJ>=(width - startJ)+width) {
			startJ =hourJ - ((width - startJ)+width);			
		}else if(hourJ >= (width - startJ)) {
			startJ =width-( hourJ - (width - startJ));
		}else {
			startJ += hourJ;
		}
		System.out.println(startI+" "+startJ);
		
	}
}
