import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st= new StringTokenizer(br.readLine());
		int[] dice = new int[6];
		for(int i=0;i<3;i++) {
			dice[Integer.parseInt(st.nextToken())-1]++;
		}
		int max = 0;
		int idx = -1;
		for(int i=0; i<6; i++) {
			if(dice[i]>=max) {
				max = dice[i];
				idx = i;
			}
		}
		if(max ==3) {
			System.out.println(10000+(idx+1)*1000);
		} else if(max == 2) {
			System.out.println(1000 +(idx+1)*100);
		} else {
			System.out.println((idx+1)*100);
		}
	}
}