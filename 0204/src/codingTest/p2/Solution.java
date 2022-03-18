package codingTest.p2;

class Solution {
	static boolean[][] grid;
	static int height, width, ans;
	
	static void check(int posI, int posJ, int n) {
		int res = 0;
		if(posI<height-n+1) {
			boolean bingo = true;
			if(posI-1>=0)
				bingo &= !grid[posI-1][posJ];
			for(int i=0; i<n; i++) {
				bingo &= grid[posI+i][posJ];
			}
			if(posI+n<height)
				bingo &= !grid[posI+n][posJ];
			if(bingo)
				res++;
		}
		if(posJ<width-n+1) {
			boolean bingo = true;
			if(posJ-1>=0)
				bingo &= !grid[posI][posJ-1];
			for(int i=0; i<n; i++) {
				bingo &= grid[posI][posJ+i];
			}
			if(posJ+n<width)
				bingo &= !grid[posI][posJ+n];
			if(bingo)
				res++;
		}
		if(posI<height-n+1&&posJ<width-n+1) {
			boolean bingo = true;
			if(posJ-1>=0&&posI-1>=0)
				bingo &= !grid[posI-1][posJ-1];
			for(int i=0; i<n; i++) {
				bingo &= grid[posI+i][posJ+i];
			}
			if(posJ+n<width&&posI+n<height)
				bingo &= !grid[posI+n][posJ+n];
			if(bingo)
				res++;
		}
		if(posI>n-2&&posJ<width-n+1) {
			boolean bingo = true;
			if(posJ-1>=0&&posI+1<height)
				bingo &= !grid[posI+1][posJ-1];
			for(int i=0; i<n; i++) {
				bingo &= grid[posI-i][posJ+i];
			}
			if(posJ+n<width&&posI-n>=0)
				bingo &= !grid[posI-n][posJ+n];
			if(bingo)
				res++;
		}
		System.out.println(posI+" "+posJ+" "+res);
		ans += res;
	}
	
    public static int solution(int h, int w, int n, String[] board) {
    	height = h;
    	width = w;
    	grid = new boolean[h][w];
    	for(int i=0; i<h; i++) {
    		for(int j=0; j<w; j++) {
    			if(board[i].charAt(j)=='1')
    				grid[i][j]= true;
    		}
    	}
    	for(int i=0; i<h; i++) {
    		for(int j=0; j<w; j++) {
    			if(grid[i][j])
    				check(i, j, n);
    		}
    	}
        int answer = ans;
        return answer;
    }
    public static void main(String[] args) {
    	String[] board = new String[] {"111100000","000010011","111100011","111110011","111100011","111100010","111100000"};
		System.out.println(solution(7, 9, 4, board));
		board = new String[] {"11111","11111","11111","11111","11111"};
		System.out.println(solution(5, 5, 5, board));
	}
}