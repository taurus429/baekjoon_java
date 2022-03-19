package codingTest.t0319.p2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
	public static String[] solution(String[] arr, String[] processes) {
		Queue<int[]> readQ = new LinkedList<int[]>();
		Queue<int[]> writeQ = new LinkedList<int[]>();
		StringTokenizer st;
		String[] temp = processes[0].split(" ");
		int time = Integer.parseInt(temp[1]);
		int starttime = time;
		int minus = 0;
		for (String p : processes) {
			st = new StringTokenizer(p);
			String rw = st.nextToken();
			if (rw.equals("read")) {
				readQ.offer(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });

			} else {
				writeQ.offer(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()) });
			}
		}
		String[] answer = new String[readQ.size()+1];
		int idx= 0;
		while (!(readQ.isEmpty() && writeQ.isEmpty())) {
			if (!writeQ.isEmpty() && writeQ.peek()[0] <= time) {
				int[] write = writeQ.poll();
				time += write[1];
				for (int i = write[2]; i <= write[3]; i++) {
					arr[i] = write[4] + "";
				}
			} else if (!readQ.isEmpty() && readQ.peek()[0] <= time) {
				int newtime = 0;
				int start = time;
				if (!writeQ.isEmpty()) {
					while (!readQ.isEmpty() && readQ.peek()[0] <= time && readQ.peek()[0] < writeQ.peek()[0]) {
						int[] read = readQ.poll();
						StringBuilder sb = new StringBuilder();
						for (int i = read[2]; i <= read[3]; i++) {
							sb.append(arr[i]);
						}
						answer[idx++] = sb.toString();
						time = Math.max(time, Math.max(start, read[0])+read[1]);
					}
					
				} else {
					while (!readQ.isEmpty() && readQ.peek()[0] <= time) {
						int[] read = readQ.poll();
						StringBuilder sb = new StringBuilder();
						for (int i = read[2]; i <= read[3]; i++) {
							sb.append(arr[i]);
						}
						answer[idx++] = sb.toString();
						time = Math.max(time, Math.max(start, read[0])+read[1]);
					}
				}

			} else {
				time++;
				minus++;
			}
		}

		answer[answer.length-1] = (time-starttime-minus)+"";

		
		return answer;
	}

	public static void main(String[] args) {
		String[] ans = solution(new String[] { "1", "2", "4", "3", "3", "4", "1", "5" }, new String[] { "read 1 3 1 2", "read 2 6 4 7",
				"write 4 3 3 5 2", "read 5 2 2 5", "write 6 1 3 3 9", "read 9 1 0 7" });
		System.out.println(Arrays.toString(ans));
		 ans = solution(new String[] { "1","1","1","1","1","1","1" }, new String[] { "write 1 12 1 5 8","read 2 3 0 2","read 5 5 1 2","read 7 5 2 5",
				 "write 13 4 0 1 3","write 19 3 3 5 5","read 30 4 0 6","read 32 3 1 5" });
		 System.out.println(Arrays.toString(ans));
	}
}