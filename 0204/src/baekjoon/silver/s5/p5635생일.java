package baekjoon.silver.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p5635생일 {
	static class Person implements Comparable<Person>{
		String name;
		int day;
		int month;
		int year;
		
		public Person(String name, int day, int month, int year) {
			super();
			this.name = name;
			this.day = day;
			this.month = month;
			this.year = year;
		}

		@Override
		public int compareTo(Person o) {
			if(this.year!=o.year) {
				return this.year-o.year;
			}else {
				if(this.month!=o.month) {
					return this.month-o.month;
				} else {
					return this.day-o.day;
				}
			}
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Person[] list = new Person[N];
		for(int i=0 ;i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			list[i] = new Person(name, day, month, year);
		}
		Arrays.sort(list);
		System.out.println(list[N-1].name);
		System.out.println(list[0].name);
	}
}
