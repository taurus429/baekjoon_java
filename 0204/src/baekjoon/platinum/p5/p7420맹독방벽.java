package baekjoon.platinum.p5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class p7420맹독방벽 {
	static long ccw(int[] A, int[] B, int[] C){
	    return ((long)B[1]-(long)A[1])*((long)C[0]-(long)A[0]) - ((long)B[0]-(long)A[0])*((long)C[1]-(long)A[1]);
	}
	static double getDist(double[] p1, double[] p2){
		return Math.sqrt(Math.pow(p1[0]-p2[0], 2)+Math.pow(p1[1]-p2[1], 2));
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] point = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			point[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		}
		Arrays.sort(point, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				} else {
					return o1[1] - o2[1];
				}
			}
		});
		Arrays.sort(point, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (((long)o1[1] - (long)point[0][1]) * ((long)o2[0] - (long)point[0][0]) < ((long)o1[0] - (long)point[0][0]) * ((long)o2[1] - (long)point[0][1]))
					return -1;
				else if (((long)o1[1] - (long)point[0][1]) * ((long)o2[0] - (long)point[0][0]) > ((long)o1[0] - (long)point[0][0]) * ((long)o2[1] - (long)point[0][1]))
					return 1;
				else if (o1[0]!=o2[0])
					return o1[1] - o2[1];
				else
					return o1[0] - o2[0];
			}
		});
		Stack<int[]> stack = new Stack<>();
		stack.push(point[0]);
		stack.push(point[1]);
		for(int i=2; i<N; i++) {
			int[] second = stack.pop();
			int[] first = stack.pop();
			int[] third = point[i];
			if(ccw(first, second, third)<0) {
				stack.push(first);
				stack.push(second);
				stack.push(third);
			}else {
				while(!stack.isEmpty()&&ccw(first, second, third)>=0) {
					second = first;
					first = stack.pop();
				}
				stack.push(first);
				stack.push(second);
				stack.push(third);
			}
		}
		int[] second = stack.pop();
		int[] first = stack.pop();
		int[] third = point[0];
		while(ccw(first, second, third)>=0&&!stack.isEmpty()) {
			second = first;
			first = stack.pop();
		}
		stack.push(first);
		stack.push(second);
		
		ArrayList<int[]> res = new ArrayList<>();
		int len = stack.size();
		for(int i=0; i<len; i++)
			res.add(stack.pop());
		res.add(res.get(0));
		double wall = 0;
		for(int i=0; i<res.size()-1; i++) {
			wall += getDist(new double[] {res.get(i)[0], res.get(i)[1]}, new double[] {res.get(i+1)[0], res.get(i+1)[1]});
		}
		wall += 2*Math.PI*R;
		System.out.println(Math.round(wall));
	}
}
