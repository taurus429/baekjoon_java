package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class p1406에디터 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String line = br.readLine();
		LinkedList<Character> list = new LinkedList<Character>();
		for(int i=0; i<line.length(); i++) {
			list.add(line.charAt(i));			
		}
		ListIterator<Character> iter = list.listIterator();
		while(iter.hasNext()) {
			iter.next();
		}
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			
			String command = br.readLine();
			char c = command.charAt(0);
			switch (c) {
			case 'L':
				if(iter.hasPrevious()) {
					iter.previous();
				}
				break;
			case 'D':
				if(iter.hasNext()) {
					iter.next();
				}
				break;
			case 'B':
				if(iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
				break;
			case 'P':
				char input = command.charAt(2);
				iter.add(input);
				break;

			default:
				break;
			}
		}
		for(Character chr : list) {
			bw.write(chr);
		}
		
		bw.flush();
		bw.close(); 
	}
}
