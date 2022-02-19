package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1182 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] nums;
	static int N;
	static int S;
	static int ans;
	
	static void back(int idx, int sum) {
		if(idx == N) {
			if(sum == S)
				ans ++;
			return;
		}else {
			if(sum>S&&nums[idx]>=0) // 합이 이미 목표를 넘겼는데 배열 값이 양수인 경우
				return;
			back(idx+1, sum+nums[idx]);//포함
			back(idx+1, sum);//비포함
		}
	}
	
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		S = Integer.parseInt(input[1]);
		nums = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);//오름차순으로 정렬
		back(0, 0);//백트래킹 호출
		if(S==0) {//s가 0이였을 경우 크기가 0인 부분집합의 경우가 1개 카운팅 되므로 하나 빼준다.
			System.out.println(ans-1);
		}else {
			System.out.println(ans);
		}
	}
}
