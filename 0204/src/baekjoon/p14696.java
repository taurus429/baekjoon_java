package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14696 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int round = Integer.parseInt(br.readLine());
		for(int i=0 ; i<round; i++) {
			int[] A = new int[5];
			int[] B = new int[5];
			st = new StringTokenizer(br.readLine(), " ");
			int len = Integer.parseInt(st.nextToken());
			for(int j=0; j<len; j++) {
				A[Integer.parseInt(st.nextToken())]++;
			}
			st = new StringTokenizer(br.readLine(), " ");
			len = Integer.parseInt(st.nextToken());
			for(int j=0; j<len; j++) {
				B[Integer.parseInt(st.nextToken())]++;
			}
			if(A[4]>B[4]) {
				System.out.println("A");
			}else if(A[4]<B[4]) {
				System.out.println("B");
			}else {
				if(A[3]>B[3]) {
					System.out.println("A");
				}else if(A[3]<B[3]) {
					System.out.println("B");
				}else {
					if(A[2]>B[2]) {
						System.out.println("A");
					}else if(A[2]<B[2]) {
						System.out.println("B");
					}else {
						if(A[1]>B[1]) {
							System.out.println("A");
						}else if(A[1]<B[1]) {
							System.out.println("B");
						}else {
							System.out.println("D");
						}
					}
				}
			}
		}
	}
}
