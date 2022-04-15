package baekjoon.gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p17143낚시왕 {
	static int height, width;
	static class Shark{
		int posI;
		int posJ;
		int speed;
		int direction;
		int size;
		public Shark(int posI, int posJ, int speed, int direction, int size) {
			super();
			this.posI = posI;
			this.posJ = posJ;
			this.direction = direction;
			if(direction==1||direction==2) {
				this.speed = speed%(height*2-2);
			} else {
				this.speed = speed%(width*2-2);
			}
			this.size = size;
		}
		void move() {
			switch (direction) {
			case 1://위
				posI -=speed;
				if(posI<0) {
					posI *= -1;
					if(posI>=height) {
						posI = (height-1)*2 - posI;
					} else {
						direction = 2;
					}
				}
				break;
			case 2://아래
				posI +=speed;
				if(posI>=height) {
					posI = (height-1)*2 - posI;
					if(posI<0) {
						posI *= -1;
					} else {
						direction = 1;
					}
				}
				break;
			case 3://오른쪽
				posJ +=speed;
				if(posJ>=width) {
					posJ = (width-1)*2 - posJ;
					if(posJ<0) {
						posJ *= -1;
					} else {
						direction = 4;
					}
				}
				break;
			case 4://왼쪽
				posJ -=speed;
				if(posJ<0) {
					posJ *= -1;
					if(posJ>=width) {
						posJ = (width-1)*2 - posJ;
					} else {
						direction = 3;
					}
				}
				break;
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(st.nextToken());
		Queue<Shark> queue = new LinkedList<Shark>();
		for(int i=0; i<cnt; i++) {
			st = new StringTokenizer(br.readLine());
			int posI = Integer.parseInt(st.nextToken())-1;
			int posJ = Integer.parseInt(st.nextToken())-1;
			int speed = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			queue.offer(new Shark(posI, posJ, speed, direction, size));
		}
		int ans = 0;
		for(int i=0; i<width; i++) {
			Shark[][] grid = new Shark[height][width];
			while(!queue.isEmpty()) {
				Shark cur = queue.poll();
				if(grid[cur.posI][cur.posJ]==null) {
					grid[cur.posI][cur.posJ] = cur;
				} else {
					if(grid[cur.posI][cur.posJ].size<cur.size) {
						grid[cur.posI][cur.posJ] = cur;
					}
				}
			}
			for(int j=0; j<height; j++) {
				if(grid[j][i]!=null) {
					ans += grid[j][i].size;
					grid[j][i] =null;
					break;
				}
			}
			for(int j=0; j<height; j++) {
				for(int k=0; k<width; k++) {
					if(grid[j][k]!=null) {
						grid[j][k].move();
						queue.offer(grid[j][k]);
					}
				}
			}
		}
		System.out.println(ans);
	}
}
