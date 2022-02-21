package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p2784가로세로퍼즐 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] input = new String[6];
		for(int i=0 ;i<6; i++) {
			input[i] = br.readLine();
		}
		Arrays.sort(input);
		char[][] answer = new char[3][3];
		boolean[] isSelected = new boolean[6];
		for (int i = 0; i < 6; i++) {
			isSelected[i] = true;
			answer[0] = input[i].toCharArray();
			for (int j = 0; j < 6; j++) {
				if (!isSelected[j]) {
					isSelected[j] = true;
					answer[1] = input[j].toCharArray();
					for (int k = 0; k < 6; k++) {
						if (!isSelected[k]) {
							isSelected[k] = true;
							answer[2] = input[k].toCharArray();
							char[][]temp = new char[3][];
							for(int l=0; l<3; l++) {
								temp[l] = new char[3];
							}
							
							for(int l=0; l<3; l++) {
								temp[0][l] = answer[l][0];
								temp[1][l] = answer[l][1];
								temp[2][l] = answer[l][2];
							}
							boolean[] checked = new boolean[3];
							for(int m=0; m<6; m++) {
								if(!isSelected[m]) {
									for(int n=0; n<3; n++) {
										if(!checked[n]&&String.valueOf(temp[n]).equals(input[m])) {
											checked[n] = true;
											isSelected[m] = true;
											break;
										}
									}
								}
							}
							if(checked[0]&&checked[1]&&checked[2]) {
								for(int a=0; a<3; a++) {
									for(int b=0; b<3; b++) {
										System.out.print(temp[b][a]);
									}
									System.out.println();
								}
								return;
							}
							isSelected = new boolean[6];
							isSelected[i] = true;
							isSelected[j] = true;
						}
					}
					isSelected[j] = false;
				}
			}
			isSelected[i] = false;
		}
		System.out.println(0);
	}
}
