package solution;

import java.io.*;
import java.util.StringTokenizer;

public class p2577회전초밥 {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int [] sushi = new int[N+k];
        int [] v = new int[d+1];

        for (int i = 0; i< N; i++) {
            sushi[i] = Integer.parseInt(in.readLine());
        }
        for (int i = N; i < N+k; i++) {
            sushi[i] = sushi[i-N];
        }

        int answer = -1;
        int count = 0;
        int coupon = 0;
        for (int i = 0; i < N+k; i++) {
            if (i >= k){
                if (--v[sushi[i-k]] == 0) count--;
                if (sushi[i-k] == c) coupon--;
            }
            if (++v[sushi[i]] == 1) count++;
            if (sushi[i] == c) coupon++;
            if (i >= k)
                answer = Math.max(answer, coupon == 0 ? count + 1: count);
        }
        System.out.println(answer);
    }
}