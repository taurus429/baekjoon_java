package codingTest.p3;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	static int[][] dest = new int[][] {{1,1,2,2},{1,1,2,2},{2,2,1,1},{2,2,1,1}};
	static class Turn{
		int move;
		int[][] grid;
		public Turn(int move, int[][] grid) {
			super();
			this.move = move;
			this.grid = grid;
		}
		
	}
	static int toIndex(int[][] grid) {
		int res =0;
		for(int i=0; i<16; i++) {
			int posI = i/4;
			int posJ = i%4;
			if(grid[posI][posJ]==2) {
				res += Math.pow(2, i);
			}
		}
		return res;
	}
	static int compare(int[][] grid) {
		int res =0;
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				if(grid[i][j] == dest[i][j])
					res ++;
			}
		}
		return res;
	}
	static int[][] move(int pos, int direction, int[][] grid){
		int[][] res = new int[4][4];
		for(int i=0; i<4; i++) {
			res[i] = grid[i].clone();
		}
		if(pos<4) {
			if(direction==1) {
				for(int i=0; i<3; i++) {
					res[pos][i] = res[pos][i+1];
				}
				res[pos][3] = grid[pos][0];
			} else {
				for(int i=3; i>=1; i--) {
					res[pos][i] = res[pos][i-1];
				}
				res[pos][0] = grid[pos][3];				
			}
		} else {
			if(direction==1) {
				for(int i=0; i<3; i++) {
					res[i][pos-4] = res[i+1][pos-4];
				}
				res[3][pos-4] = grid[0][pos-4];
			} else {
				for(int i=3; i>=1; i--) {
					res[i][pos-4] = res[i-1][pos-4];
				}
				res[0][pos-4] = grid[3][pos-4];				
			}
		}
		return res;
	}
    public static int solution(int[][] grid) {
    	int answer = -1;
    	int curPoint = -1;
    	boolean[] visited = new boolean[(int)Math.pow(2, 17)];
    	Queue<Turn> queue = new LinkedList<>();
    	queue.offer(new Turn(0, grid));
    	visited[toIndex(grid)] = true;
    	while(true) {
    		Turn cur = queue.poll();
    		int[][] curGrid = cur.grid;
    		int curMove = cur.move;
    		curPoint = Math.max(curPoint, compare(curGrid));
    		if(curPoint == 16) {
    			answer = curMove;
    			break;
    		}
    		
    		for(int i=0; i<16; i++) {
    			int[][] moveGrid = move(i/2, i%2, curGrid);
    			if(!visited[toIndex(moveGrid)]&&curPoint<=compare(moveGrid)) {
    				queue.offer(new Turn(curMove+1, moveGrid));
    				visited[toIndex(moveGrid)] = true;
    			}
    		}
    	}
        return answer;
    }
    public static void main(String[] args) {
//		int[][] grid = new int[][] {{1,1,1,1},{2,1,2,2},{2,2,2,1},{1,1,2,2}};
		int[][] grid = new int[][] {{1,1,1,2},{1,1,1,2},{2,2,2,1},{1,2,2,2}};
		System.out.println(solution(grid));
	}
}