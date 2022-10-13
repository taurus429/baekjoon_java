package toss.p3;

class Solution {
	
	static boolean[] visited;
	static int answer;
	static void enter(int health, int index, int[][] dungeons, int depth) {
		answer = Math.max(answer, depth);
		for(int i=0; i<dungeons.length; i++) {
			if(!visited[i]&&dungeons[i][0]<=health) {
				visited[i] = true;
				enter(health - dungeons[i][1], i, dungeons, depth+1);
				visited[i] = false;
			}
		}
	}
	static public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        for(int i=0; i<dungeons.length; i++) {
			if(!visited[i]&&dungeons[i][0]<=k) {
        	visited[i] = true;
        	enter(k- dungeons[i][1], i, dungeons, 1);
        	visited[i] = false;
			}
        }
        return answer;
    }
	public static void main(String[] args) {
	}
}