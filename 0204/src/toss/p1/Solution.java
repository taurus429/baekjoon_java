package toss.p1;

class Solution {

	static  public int solution(String s) {
        if(s.length()<3) {
        	return -1;
        } else {
        	int answer = -1;
        	for(int i=0; i<s.length()-2; i++) {
        		String subNumber = s.substring(i, i+3);
        		if(subNumber.charAt(0)==subNumber.charAt(1)&&subNumber.charAt(1)==subNumber.charAt(2)) {
        			answer = Math.max(answer, Integer.parseInt(subNumber));
        		}
        	}
        	return answer;
        }
        
    }

	public static void main(String[] args) {
		System.out.println(solution("12223"));
	}
}