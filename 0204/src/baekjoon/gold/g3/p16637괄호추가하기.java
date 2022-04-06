package baekjoon.gold.g3;

import java.io.InputStreamReader;
import java.util.Arrays;

import javax.management.openmbean.OpenMBeanOperationInfo;

import java.io.BufferedReader;
import java.io.IOException;

public class p16637괄호추가하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static boolean[] bracket;
	static int[] oper;
	static int[] num;
	static int max = Integer.MIN_VALUE;
	
	static int calculate(int[] num, int[] oper) {
		int NaN = Integer.MAX_VALUE;
		for(int i=0; i<N/2; i++) {
			if(bracket[i]) {
				int res = 0;
				switch (oper[i]) {
				case 0:
					num[i+1] += num[i];
					break;
				case 1:
					num[i+1] = num[i] - num[i+1];
					break;
				case 2:
					num[i+1] *= num[i];
					break;
				default:
					break;
				}
				num[i] = NaN;
				oper[i] = NaN;
			}
		}
		int startpoint;
		if(num[0]!=NaN) {
			startpoint =0;
		}else {
			startpoint = 1;
		}
		int res = num[startpoint];
		int operIdx = startpoint;
		int numIdx = startpoint+1;
		while(true) {
			if(oper[operIdx]==NaN) {
				operIdx++;
			}
			if(num[numIdx]==NaN) {
				numIdx ++;
			}
			if(operIdx>=N/2 || numIdx>=N/2+1)
				break;
			switch (oper[operIdx]) {
			case 0:
				res += num[numIdx];
				break;
			case 1:
				res -= num[numIdx];
				break;
			case 2:
				res *= num[numIdx];
				break;

			}
			operIdx++;
			numIdx++;
			if(operIdx>=N/2 || numIdx>=N/2+1)
				break;
		}
		return res;
	}
	
	static void combination(int start) {
		if(start>=N/2) {
			int[] tempNum = num.clone();
			int[] tempOper = oper.clone();
			int res = calculate(tempNum, tempOper);
			if(res>max) {
				max = res;
			}
			return;
		}
			
		for(int i=start+2; i<N/2+2; i++) {
			if(i<N/2)
			bracket[i] = true;
			combination(i);
			if(i<N/2)
			bracket[i] = false;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		num = new int[N/2+1];
		oper = new int[N/2];
		bracket = new boolean[N/2];
		String calc = br.readLine();
		for(int i=0; i<N; i++) {
			if(i%2==0) {//숫자일때
				num[i/2] = (int)calc.charAt(i) - 48;
			}else {
				switch (calc.charAt(i)) {
				case '+':
					oper[i/2] = 0;
					break;
				case '-':
					oper[i/2] = 1;			
					break;
				case '*':
					oper[i/2] = 2;								
					break;
				}
			}
		}
		if(N==1) {
			System.out.println(num[0]);
			return;
		}
		if(N==3) {
			switch (oper[0]) {
			case 0:
				System.out.println(num[0]+num[1]);
				break;
			case 1:
				System.out.println(num[0]-num[1]);
				break;
			case 2:
				System.out.println(num[0]*num[1]);
				break;
			}
			return;
		}
		combination(-2);
		System.out.println(max);
	}
}
