package programmers.lv2;

import java.util.LinkedList;

public class 리코쳇로봇 {
	public static void main(String[] args) {

//		String[] board = new String[] {".D.R", "....", ".G..", "...D"};
		String[] board = new String[] {"..R", "...", "...", "..D","DG."};
		Solution sol = new Solution();
		System.out.println(sol.solution(board));
	}
}

class Solution {
	
	static int[] dx = new int[] {1, -1, 0, 0};
	static int[] dy = new int[] {0, 0, 1, -1};
    public int solution(String[] board) {
        int answer = 0;
        int height = board.length;
        int width = board[0].length();
        char[][] map = new char[height][width];
        boolean[][] visited = new boolean[height][width];
        int[] startPos = new int[] {-1, -1};
        for(int i=0; i<height; i++) {
        	for (int j=0; j<width; j++) {
        		map[i][j] = board[i].charAt(j);
        		if (map[i][j] == 'R') {
        			startPos = new int[] {i, j};
        		}
        	}
        }
        visited[startPos[0]][startPos[1]] = true;
        
        LinkedList<int[]> queue = new LinkedList<int[]>();
        queue.push(new int[] {startPos[0], startPos[1], 0});
        while(!queue.isEmpty()) {
        	int[] curr = queue.poll();
        	for(int i=0; i<4; i++) {
        		int[] nextPos = findEnd(map, new int[] {curr[0], curr[1]}, i);
        		if(map[nextPos[0]][nextPos[1]]=='G') {
        			return curr[2]+1;
        		}
        		if(!visited[nextPos[0]][nextPos[1]]) {
        			visited[nextPos[0]][nextPos[1]] = true;
        			queue.push(new int[] {nextPos[0], nextPos[1], curr[2]+1});
        		}
        	}
        }
        return -1;
    }
    public int[] findEnd(char[][] map, int[] pos, int direction) {
    	int posY = pos[0];
    	int posX = pos[1];
    	int height = map.length;
    	int width = map[0].length;
    	while(0<=posY+dy[direction]&&posY+dy[direction]<height&&0<=posX+dx[direction]&&posX+dx[direction]<width&&map[posY+dy[direction]][posX+dx[direction]]!='D') {
    		posY = posY+dy[direction];
    		posX = posX+dx[direction];
    	}
    	
    	return new int[] {posY, posX};
    }
}