package baekjoon;

import java.util.Random;

public class p9490_2 {
	public static void main(String[] args) {
		for(int i=0; i<5; i++) {
		System.out.println("4 6 8");
		System.out.println("3 1 "+(int)(Math.random()*20)+" "+((int)(Math.random()*4)+1)+" "+1);
		System.out.println("4 3 "+(int)(Math.random()*20)+" "+((int)(Math.random()*4)+1)+" "+2);
		System.out.println("2 1 "+(int)(Math.random()*20)+" "+((int)(Math.random()*4)+1)+" "+3);
		System.out.println("4 4 "+(int)(Math.random()*20)+" "+((int)(Math.random()*4)+1)+" "+4);
		System.out.println("3 3 "+(int)(Math.random()*20)+" "+((int)(Math.random()*4)+1)+" "+5);
		System.out.println("1 4 "+(int)(Math.random()*20)+" "+((int)(Math.random()*4)+1)+" "+6);
		System.out.println("3 4 "+(int)(Math.random()*20)+" "+((int)(Math.random()*4)+1)+" "+7);
		System.out.println("2 4 "+(int)(Math.random()*20)+" "+((int)(Math.random()*4)+1)+" "+8);
	}}
}

