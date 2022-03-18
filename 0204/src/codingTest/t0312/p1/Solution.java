package codingTest.t0312.p1;

public class Solution {
    public static int solution(int money, int[] costs) {
    	int[] dp = new int[money+1];
    	for(int i=1; i<money+1; i++) {
    		int min = 0;
    		if(i>=1) {
    			min = dp[i-1] + costs[0];
    		}
    		if(i>=5) {
    			min = Math.min(min, dp[i-5] + costs[1]);
    		}
    		if(i>=10) {
    			min = Math.min(min, dp[i-10] + costs[2]);
    		}
    		if(i>=50) {
    			min = Math.min(min, dp[i-50] + costs[3]);
    		}
    		if(i>=100) {
    			min = Math.min(min, dp[i-100] + costs[4]);
    		}
    		if(i>=500) {
    			min = Math.min(min, dp[i-500] + costs[5]);
    		}
    		dp[i] = min;
    	}
        int answer = dp[money];
        return answer;
    }
    public static void main(String[] args) {
		int res = solution(4578, new int[] {1, 4, 99, 35, 50, 1000});
		System.out.println(res);
	}
}