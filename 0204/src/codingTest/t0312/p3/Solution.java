package codingTest.t0312.p3;

import java.util.Arrays;

class Solution {
	static int bignum =  10000019;
	static long getWay(int posI, int posJ, int destI, int destJ) {
		int a = Math.abs(destI-posI);
		int b = Math.abs(destJ-posJ);
		long[][] grid = new long[a+1][b+1];
		grid[0][0] = 1;
		for(int i=0; i<a+1; i++) {
			for(int j=0; j<b+1; j++) {
				if(i>0) {
					grid[i][j] += grid[i-1][j]%bignum;
				}
				if(j>0) {
					grid[i][j] += grid[i][j-1]%bignum;
				}
			}
		}
		return grid[a][b]%bignum;
	}
    public static int solution(int width, int height, int[][] diagonals) {
        long answer = 0;
        for(int[] diagonal: diagonals) {
        	answer += getWay(diagonal[1]-1, diagonal[0], height, width)*getWay(diagonal[1], diagonal[0]-1,0,0);
        	answer %= bignum;
        	
        	answer += (getWay(diagonal[1], diagonal[0]-1,height,width)%bignum)*(getWay(diagonal[1]-1, diagonal[0], 0, 0)%bignum);
        	answer %= bignum;
        }
        return (int)answer;
    }
    public static void main(String[] args) {
		//System.out.println(solution(2, 2, new int[][] {{1, 1}, {2,2}}));
    	System.out.println(solution(51, 37, new int[][] {{17, 19}}));
	}
}