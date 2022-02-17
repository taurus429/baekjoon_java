package baekjoon;

import java.util.Scanner;

public class p2635 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int index=-1;
		int maxCnt = 1;
		for(int i=1; i<=num; i++) {
			int cnt =1;
			int before =num;
			int curr = i;
			int temp;
			while(curr>=0) {
				temp = curr;
				curr = before -curr;
				before = temp;
				cnt ++;
			}
			if(cnt> maxCnt) {
				maxCnt = cnt;
				index = i;
			}
		}
		System.out.println(maxCnt);
		int before =num;
		int curr = index;
		int temp;
		System.out.print(num+" ");
		while(curr>=0) {
			System.out.print(curr+" ");
			temp = curr;
			curr = before -curr;
			before = temp;
		}
	}
}
