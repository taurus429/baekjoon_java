package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class p10546 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0; i<n; i++) {
			String temp = br.readLine();
			if(map.containsKey(temp)) {
				map.replace(temp, map.get(temp)+1);
			}else {
				map.put(temp, 1);
			}
		}
		for(int i=0; i<n-1; i++) {
			String temp = br.readLine();
			if(map.get(temp)>1) {
				map.replace(temp, map.get(temp)-1);
			}else {
				map.remove(temp);
			}
		}
		System.out.println(map.keySet().toArray()[0]);
	}
}
