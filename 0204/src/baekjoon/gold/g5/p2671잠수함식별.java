package baekjoon.gold.g5;

import java.io.*;

public class p2671잠수함식별 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String regex = "^(100+1+|01)+$";
		
    String sound = br.readLine();
    if(sound.matches(regex)) {
      System.out.println("SUBMARINE");
    }else {
      System.out.println("NOISE");
    }
  }
}