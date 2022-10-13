package toss.p4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

class Solution {

	public static long[] solution(long[][] invitationPairs) {
		
		HashMap<Long, Long[]> map = new HashMap<>();
		HashMap<Long, Long> score = new HashMap<>();
		long[][] res = {};
		for(int i=0; i<invitationPairs.length; i++) {
			long inviter = invitationPairs[i][0];
			long invitee = invitationPairs[i][1];
			System.out.println(inviter);
			System.out.println(invitee);
			if(!map.containsKey(inviter)) {
				map.put(inviter, new Long[] {(long)0, (long)0, (long)0});
				score.put(inviter, (long)0);
			}
			map.put(invitee, new Long[] {inviter, map.get(inviter)[0], map.get(inviter)[1]});
			score.put(invitee, (long)0);
			if(inviter!=(long)0) {
				score.put(inviter, score.get(inviter)+(long)10);
			}
			if(map.get(inviter)[0]!=(long)0) {
				score.put(map.get(inviter)[0], score.get(map.get(inviter)[0])+(long)3);
			}
			if(map.get(inviter)[1]!=(long)0) {
				score.put(map.get(inviter)[1], score.get(map.get(inviter)[1])+(long)1);
			}
		}
		res = new long[score.size()][];
		int idx = 0;
		for(Entry<Long, Long> entry: score.entrySet()) {
			res[idx] = new long[] {entry.getKey(), entry.getValue()};
			idx++;
		}
		Arrays.sort(res, new Comparator<long[]>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				return (int) (o2[1] - o1[1]); 
			}
		});
		System.out.println(score);
        long[] answer = {res[0][1]==0?0:res[0][0],res[1][1]==0?0:res[1][0],res[2][1]==0?0:res[2][0]};
        System.out.println(Arrays.toString(answer));
        return answer;
    }

	public static void main(String[] args) {
//		solution(new long[][] {{(long)1, (long)2}, {(long)2, (long)3}, {(long)2, (long)4},{(long)2, (long)5}, {(long)5, (long)6}, {(long)5, (long)7}, {(long)6, (long)8}, {(long)2, (long)9}});
//		solution(new long[][] { { (long) 1, (long) 2 }, { (long) 2, (long) 3 }, { (long) 2, (long) 4 },
//				{ (long) 2, (long) 5 }, { (long) 5, (long) 6 }, { (long) 5, (long) 7 }, { (long) 6, (long) 8 },
//				{ (long) 2, (long) 9 } });
		solution(new long[][] { { (long) 1, (long) 2 }, { (long) 3, (long) 4 }});
		
	}
}