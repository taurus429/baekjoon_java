package test;


import java.io.IOException;
import java.util.Arrays;


public class Solution {
	static int[][] getCombi(int n){
		int len = n*(n-1)/2;
		int cnt =0;
		int[][] res = new int[len][];
		for(int i=0; i<n-1; i ++) {
			for(int j=i+1; j<n; j++) {
				res[cnt] = new int[] {i,j};
				cnt++;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[][] res = getCombi(3);
		for(int[] r: res) {
			System.out.println(Arrays.toString(r));			
		}
		String str1 = "....................................................................................................\r\n" + 
				"....................................................................................................\r\n" + 
				"....................................................................................................\r\n" + 
				"................................................x.........................xxxxxxxxxxxxxxxxxxxx......\r\n" + 
				"................................................x.........................x.........................\r\n" + 
				"....xx.x..x.xxxxxxx.xx..xx.x.x.xxxxxx..xx.xxx...x....xxxxx.xxxx...xx.xxxxxx.........................\r\n" + 
				"....xxxx..x.xxx.x.x.xx..xx.x.xxx..xx..xxx.x.....x....x.xxx.xxxx..xxxxx.xx...........................\r\n" + 
				"......xxxxxxx.x.xxxxx...x..xx..x..xx..xxxxx.....x....x.xxxxxx.x.x.xx...x............................\r\n" + 
				"..xxxxx...xxxxxx.xx.x...xx.xx..x...x..xxx.......x....x..xxxxx.xxx..xxxx.x.x.........................\r\n" + 
				"..xxxx...xxxx...xxxxx...xx..xxxx...x..x.x......xx...xxxxxx.x.xxxx..xxxx.xxxxxx......................\r\n" + 
				"....xx.x..x.xxxxxxx.xx..xx.x.x.xxxxxx..xx.xxx...x....xxxxx.xxxx...xx.xxxxxx.........................\r\n" + 
				"...xxxxx..x.xxx.x.x.xx..xx.x.xxx..xx..xxx.x.....x....x.xxx.xxxx..xxxxx.x............................\r\n" + 
				"....xxxxxxxxx.x.xxxxx...x..xx..x..xx..xxxxx.....x....x.xxxxxx.x.x.xx...xx..x........................\r\n" + 
				".xxxxxx...xxxxxx.xx.x...xx.xx..x...x..xxx.......x....x..xxxxx.xxx..xxxx.x.xx........................\r\n" + 
				"..xxxx...xxxx...xxxxx...xx..xxxx...x..x.x......xx...xxxxxx.x.xxxx..xxxx.xxxxxxx.....................\r\n" + 
				".....x.x..x.xxxxxxx.xx..xx.x.x.xxxxxx..xx.xxx...x....xxxxx.xxxx...xx.xxxxxx.........................\r\n" + 
				"...xxxxx..x.xxx.x.x.xx..xx.x.xxx..xx..xxx.x.....x....x.xxx.xxxx..xxxxx.xx...................xx......\r\n" + 
				"....xxxxxxxxx.x.xxxxx...x..xx..x..xx..xxxxx.....x....x.xxxxxx.x.x.xx...xx..x................xx......\r\n" + 
				".xxxxxx...xxxxxx.xx.x...xx.xx..x...x..xxx.......x....x..xxxxx.xxx..xxxx.x.xx.......xxxxxxxxxx.......\r\n" + 
				"..xxxx...xxxx...xxxxx...xx..xxxx...x..x.x......xx...xxxxxx.x.xxxx..xxxx.xxxxxxx...xxxxx.xx.xxx.xxx..\r\n" + 
				".....x.x..x.xxxxxxx.xx..xx.x.x.xxxxxx..xx.xxx...x....xxxxx.xxxx...xx.xxxxxx.......xxx...xxxxx..x....\r\n" + 
				"...xxxxx..x.xxx.x.x.xx..xx.x.xxx..xx..xxx.x.....x....x.xxx.xxxx..xxxxx.xx.........x.x...xx.xx.xxx.x.\r\n" + 
				".......xxxxxx.x.xxxxx...x..xx..x..xx..xxxxx.....x....x.xxxxxx.x.x.xx...xx..x......x.x.x.xx..x.xxxxx.\r\n" + 
				"..xxxxx...xxxxxx.xx.x...xx.xx..x...x..xxx.......x....x..xxxxx.xxx..xxxx.x.xx......x.xxxxxx..xx.xxxx.\r\n" + 
				".xxxxx...xxxx...xxxxx...xx..xxxx...x..x.x......xx...xxxxxx.x.xxxx..xxxx.xxxxxxx...x..xx.xx.xxx.xxx..\r\n" + 
				"....xx.x..x.xxxxxxx.xx..xx.x.x.xxxxxx..xx.xxx...x....xxxxx.xxxx...xx.xxxxxx.......x.....xxxxx..x....\r\n" + 
				"...xxxxx..x.xxx.x.x.xx..xx.x.xxx..xx..xxx.x.....x....x.xxx.xxxx..xxxxx.xx.........x.x...xx.xx.xxx...\r\n" + 
				"....xxxxxxxxx.x.xxxxx...x..xx..x..xx..xxxxx.....x....x.xxxxxx.x.x.xx...xx..x......x.x.x.xx..x.xxxxx.\r\n" + 
				"..xxxxx...xxxxxx.xx.x...xx.xx..x...x..xxx.......x....x..xxxxx.xxx..xxxx.x.xx......x.xxxxxx..xx.xxx..\r\n" + 
				".xxxxx...xxxx...xxxxx...xx..xxxx...x..x.x......xx...xxxxxx.x.xxxx..xxxx.xxxxxxx...x..xx.xx.xxx.xx...\r\n" + 
				"....xx.x..x.xxxxxxx.xx..xx.x.x.xxxxxx..xx.xxx...x....xxxxx.xxxx...xx.xxxxxx.......x.....xxxxx..xx...\r\n" + 
				"...xxxxx..x.xxx.x.x.xx..xx.x.xxx..xx..xxx.x.....x....x.xxx.xxxx..xxxxx.xx.........x.x...xx.xx.xxx.x.\r\n" + 
				".....xxxxxxxx.x.xxxxx...x..xx..x..xx..xxxxx.....x....x.xxxxxx.x.x.xx...xx..x......xxx.x.xx..xxxxxxx.\r\n" + 
				".xxxxxx...xxxxxx.xx.x...xx.xx..x...x..xxx.......x....x..xxxxx.xxx..xxxx.x.xx......x.xxxxxx..xx.xxx..\r\n" + 
				"..xxxx...xxxx...xxxxx...xx..xxxx...x..xxx......xx...xxxxxx.x.xxxx..xxxx.xxxxxxx...x..xx.xx.xxx.xxxx.\r\n" + 
				"...xxxxxx...xxxx....xx...xxxxxxx..xxxx.x..x.xxxxxxxx.x.......x...xxxxx...................xxxx.......\r\n" + 
				"...xxx..xx..xxxx.xxxxx.xxx.xxxx..xx.xxxx..x.xx...x...x.....xxxxx..xxxxx..................xxxx.......\r\n" + 
				"...xxx.xx.x.xxx.xxx.xx.xxx.x.xx.x.xxxx.xx.x.x........x......xxxx.xxx..xxx.x.............xx.xx.......\r\n" + 
				"....xx.x..x.xxxxxxx.xx..xx.x.x.xxxxxx..xx.xxx........xxxxx.xxxx...xx.xxxxxx.............xxxxx..x....\r\n" + 
				"...xxxxx..x.xxx.x.x.xx..xx.x.xxx..xx..xxx.x..........x.xxx.xxxx..xxxxx.xx...........x...xx.xx.xxx...\r\n" + 
				"....xxxxxxxxx.x.xxxxx...x..xx..x..xx..xxxxx..........x.xxxxxx.x.x.xx...xx..x........x.x.xx..x.xxxxx.\r\n" + 
				"...xxxx...xxxxxx.xx.x...xx.xx..x...x..xxx.......x....x..xxxxx.xxx..xxxx.x.xx........xxxxxx..xx.x....\r\n" + 
				".xxxxx...xxxx...xxxxx...xx..xxxx...x..x.x......xx...xxxxxx.x.xxxx..xxxx.xxxx.xx...x..xx.xx.xxx.xxxx.\r\n" + 
				".x.xxxx.xx..xx..xxxxxxx..x...xxx.xxx.xxxxx....xxxxx..xxxxxxxxxx..xx.xxxxx....xx...xx.xxxx..xxx.xx...\r\n" + 
				".xx.xx..xx.xx..xxxxxxxxxxxx.xxx..xxxxxxxxx...xxx.x.xxxxx.xxx.xx...x.xxxx.xxxxxxxxxx.xxxx.x.x.xxxx...\r\n" + 
				".xx.x...xxxxx..xxx..xxxxxxx...xx.xxxxxx.xx...xx.xx.xx.xxxxxx.xxxx.x..xxxxxx..xxxxx..x.xxxxxx.x..x...\r\n" + 
				".x....xxxxx.xxx..xx..xxxxxxx...xxxxxxxxxx..xxxx.xxxxxxxxxx.x.xxxxxxx.xxxxx..xx..x......xxxx..x..x...\r\n" + 
				"xx.....xxxxxxxxx.x..xxxx.xxx.xxx.xxxxxx.xxxx.xxxxxxxxxxxx...xxx.xxx...xx.x.xxx..x........x...xx.x.x.\r\n" + 
				"xxx..xx.xxxxxxx.xxx.x.xxxx.xxx.x.xxxx.xx..xx.x..x....xxx......xxx......xx..xxxxxxx.x.x.......xx.xxx.\r\n" + 
				"xxxx.xxxx.xx....x.xxxx.xx.xxxxxx.x.xxx.xxxxx.xxx.....x.xx....xxxx..x..xxxx.xx.x.xxxx.x.......xxxxx..\r\n" + 
				"x.x.....xxxxxxxxxx.xxxxx..x...xx.x.x.xxxxxxx...xx......x...xx..xx.xxx....xxxxxx...xx.xxx....xxxxxxx.\r\n" + 
				"........xxxx..xxx..xxx.xx.xx..xx.x...x.x.x.xxxx.xx.xx..x...xxxxxxx.x.x.xxxxxxxx..xxx.x.x.xxx..xxxxxx\r\n" + 
				"...........x...xx....x..x.xxxxxxxx.x.xxxxx.x..xxxx.xxx.....xxxxx.xxx.x.xx...xx...x.x.x.x.xxxxxxxxxxx\r\n" + 
				"...xxxx....xx.xx........x.xxxxxxxxxxxxxx...xx.x.xxxxx....xxxxx.xxxxxxxxx..xx.xx..x..xxx..xx.xxxxxx..\r\n" + 
				"xxxxxxxx....x.xxx.x..xx...xxxxx...x.xx...xxxxx.x.xxxxxxxxxxxxxxx.xxx.x.xxxxx....xx..xxxxx.xxxxxx.xx.\r\n" + 
				"xxxxxxxx......x..xxx.xxx...x.x..xxx..xxxxxxx.x.x....xxxxxx.xxxxxxx.x.xxx.xxxxxx.x....xx...x.........\r\n" + 
				".xx.xxxx.xx......xxxxxxxxx..x....xx.xxxx..xx.xxx.xxxxxx.x.....x..xxx.x.x.x.xxxxxxxxxxx.x..x.........\r\n" + 
				"xxxxx.x.xxxxx..xxxx.xxxxx...xxx..xx.xxx...xxxxxxxxxx.x.......xx..xxx.xxxx...x.xx.xxxxxxxxxxxx.......\r\n" + 
				".xx.xxxxxxxxx..xxxx.xxxx.xxxxxxxx.x..xxx.xxxx.xx....xxx..x...xx.xxxxx...x....xx.xxx.xxx..x.xx.......\r\n" + 
				"xxx...xxx.xxx....xxxxx.xxxxxx.xxxxx.xxx.xxx.xx.x...x.xx..xxxxx.x.xxxxx.xx.xxxx.xxxxxx.xx....x.......\r\n" + 
				"...x...xxxxx....xxx.xxxx...xx.x.xxxx.xx.xxx.xx.....x..x.xxx..xxxxx.x.......x.xx.x..xxxxx........x.xx\r\n" + 
				"..xxxx.xxx.x.x...xxxx.xxx.xx.xxxxx.x.x.xx.xxx.xxxxxx.xxxxx.x.x..x.xxxx..xx.xx.xxxx.xx..x.x...xx.xxxx\r\n" + 
				"..xxxxx..xxxxxx..xx.xx..x....x..xxxxx.xxx..x...xxxxxxxx..xxx........x.x..xxxxxxx.xxxxxx..xxxxxxxxxx.\r\n" + 
				"..xxxxxxxx....x.xxxx.....xxx.x....xxxx..x...xxx.x.xxx.x..xxxx.xx...xx.x.xx.....xxx.xx.x..xx..xxxxxxx\r\n" + 
				"..xxx..x..xxxxx..xxx..xx..x...xx.xxxxxxxxx.xxxx.xxx.x....x.x..x..xxxxxxxxxx...xx...x....xxxxxxxxxxxx\r\n" + 
				"...x..xxxxxxxxx..xxxxxx.x.xxxxxx.xxxx..xx.xx.xxx.xx.....xxx..xxxxx.xx.xxx.xxx.xx...x....xx..xxxxxx..\r\n" + 
				"..xxxx.x.xxx.x.x..xxxxx.xx.xx..x.xx.x...xx.x.xxxxx....xxxxx.xxxxxxx.x..xxxxxxxxx...xxxxxx..xxxxxx...\r\n" + 
				"xx..x..xxx.xxxxxx..xx..x.xxxxx....x..x..x.xxxx.xx..xxxxxxxxxx...xxxxxxx.xx..x.xxx..x.xxxxxxx..xxx.xx\r\n" + 
				"xx.x.x.xxxxxxxxxx.xxxx.xx..xxxxxxxxxxxxxxx.x..xxxxxxx...x...xxxxxx.xxxxxxx..xx...xx..xxxxxx.xxx...x.\r\n" + 
				".xxx.xx.xx.x.x.xx.xxxxxxx.xx..xxxx.xx.xxxxxx...xx.xxxx...xxx.xxx....xxx..x...xxxxxxxxxxxx....xx.xxx.\r\n" + 
				".xxx.xxxx.xxxxx.....xx..x..xxxxx......xxxxxxxxx...xxxxx.xxxxx.xx..xx..x..xxxxxxx..xxxxx.xx....xxxxx.\r\n" + 
				".xxx.x..x.xx.xxxxxxx.x.x.xxxx..xxx.xxxxxxx.xxxxxxxxxxxx.x..x.xxxxxx.xx.x.xxxxxx...xxxxxx.xxxx.xxxx..\r\n" + 
				"xxx.xxxxxxxx.xxxxxxx.xxxx..x..xxxx.xxx...x.xxxxxxxxxxxxx.xxxx.xxxxx.xxxx.xx.xxxx.xxx...x.xx.x.xxxx..\r\n" + 
				".xxxxx..x.x.xx.xx.xxx..xxxx...xx.xxxx.xxxxxxxxx..xx.xx.xxx.xxx.xxx.x.xxx.xxxx.x.xxxx..xxx.xxxxxxxxxx\r\n" + 
				"....xxxx.xx..x..xxxx...xx.xxxxxx.x.xxxxxx.x.xxxx.x.xxxxxx..xxxxxx.xxx.xxx.xx..xx.x..xxxx.xxx.xxxxxx.\r\n" + 
				"xx..xx.xx..xxx....xx.x.xxx.xx.xxx.xx.x..x.xxxxx.xx.xxx...xxxxx.xxxx.x..x.x....x..x.xx.xxx...........\r\n" + 
				"xxxx.xxxxxxx...xxxx..xxxx.xxxx....xxxx..x.xxxx.x.xxxxxxxxxxxxxxxx.xxxx.xxxx.xxx..x.xx.........x...x.\r\n" + 
				"...x...x..x.xxxxxx...xxxxx.xx.xxxx.xx.......xxxxx...x.xxxxxxx..xxxxxxxxxxxxxx..xxxxxxxxxx..xxxxxx.xx\r\n" + 
				".xxxxxxxxx.xxxxx...x..xx..xxx..xx.xx..xx..xxxxxxxxxxxxxxxxxxx..x...xxxxxxxxx.xx...xxx....xxxxxxxxxx.\r\n" + 
				"xxxxxxx..x.xxxxx..xxxxxxxxxxxx.xxxxxxxxxxxxx..xx.xxxxx.x.xxxxx...xxxxxxxxxxx.xxxxxxxx.xxxxx.xxxx....\r\n" + 
				".xx.xx.xxxx..xxxxxxxxx..x.x..xx.xx.xxx.xxx.xxxx.x.x..xx.xxxx.xxx.xxx.x.xxxxx.xx.xxxxx.x.x.xxx..xxxxx\r\n" + 
				"..xx.xx.xxx.xxxxxxxxxxxxx.x.xxx.xxxxxxxxxxxxxx.xxxxxxx.xxxxxxxxxxxxx.xxxxxx..xxxxxxx..xxxx.x..xxxxxx\r\n" + 
				"..xxxxxxx.xxx.xxxx.xxx..xxxxxxxxx..xxxx.xxxxxxxxxxxxx..xxx.xxxx.xxxxx.xxxxxxxxxxxxx...xxx.xxxxx.xxxx\r\n" + 
				"xxxxxx...xxx.xxxxx.x...xxxxxx...x.xx.xxx.xxxxx..xxx.xxxxxxxx.xx.xx..xxxxx.xxxxxxxxxxxxx.x.xxxxxxx.xx\r\n" + 
				".............................................................................................x......\r\n" + 
				"xxx.xxx.xx.xxxxxx.xxxxxxx.xxx.x..xxxxxxxx.xxx.xxxx.xx.xxx.xxxxxxxx.x.xxxx.xxxxx.xx.xxxxxx.xxxxxxxx..\r\n" + 
				"xx.xxxxx.xxxxxxxxxx..xxxxxxxxxxxxx.xx.xxxx.xxxxxx.xx.xx.xxx.xxxxxx.xxxxxx.xxx.x.xxxxxxxxxx.x.xx.xxxx\r\n" + 
				".xxx.xxxxxxxxxxxxxxxxxxxxxx.xxxxxxx.x.xxxxxxxxxxx.x..x.xxxx.xx.xxx.xxxxxxxx.xxxxx.xx..xxx..x.xxx.xxx\r\n" + 
				"..xx.xxxxxx.xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.xxxxxxxxxxxxxxxxxxxxxxxx.xx.x.xxx.x.xxxxxxx.xxxxxxxxxxx.x\r\n" + 
				"..xxxx.xxxxx.xxxxxxxx.xx.xxxxxx.xxxxxxxxxx.xxxxxxxxxxxxxxx.xxxxxxxxxx.xxxx.x.xxxxx.xxxx.xxxxxxx.xxxx\r\n" + 
				"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.xxxxxxxxx.xxxxxxx...xxx.xxxxx.xxxxxxxxxxxxxxxxxxxxx.xxxxx.xxx.xx\r\n" + 
				"xxxxxxxxxxx.xx.xxxxxxxxxxxxxxx.xx.xxxxxxxxxxx.xxxxxxxxxxxxxx.xxxxxx.xxxxxxxxxxx.xx.xxxxx.xx..xxx.xx.\r\n" + 
				".xxxxx..xxxxxxxxxxxxx.xxxxxxxxxxxx.xxxxx.xxxxxxxx.x.xxxxxxxxxxxx.xx.xxxxxxxxxxxx.xxxxx.xx.xxxxxxxxxx\r\n" + 
				"xxxxxxxxxxxx.xxxxxxxxxxxxxxxxxxx.x.xxxxxxxxxxxxx.xxxxxxxxxx.xxxxxxxxxxxx.xxx.xxxxxxxxxxxxxxxxxxxxxxx\r\n" + 
				"xxxxxxxxx.xxxx.xxxxxxxxxxx..xxx.xxxx.xx.xxxxxxxxxxxxxxxxxxxxx.xxxx.xxxxxxxxxxxxxxxxxxxxxxxxxx.xxxxx.\r\n" + 
				"...xxx..xxxx.xxxx.xxxxxx.xxxxxxxx.xxxxxxxxxxxxxx.xxx.xxxx.x.xxxxxxxx.xxxxxxxxxxxx.xxxxxxxxxxxxxxxxx.\r\n" + 
				"...x.xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.xx.xx..xxxxxxxxxxxxxxxxxxxxxxxxxxxx\r\n" + 
				"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.xxxxxxxxxxxxxxxxxxxxxxx.xxxxxxxxxxx.xx.xxxxxxxxxx\r\n" + 
				".xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.\r\n" + 
				"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
		String str2 = "....................................................................................................\r\n" + 
				"....................................................................................................\r\n" + 
				"....................................................................................................\r\n" + 
				"................................................x.........................xxxxxxxxxxxxxxxxxxxx......\r\n" + 
				"................................................x.........................x.........................\r\n" + 
				"....xx.x..x.xxxxxxx.xx..xx.x.x.xxxxxx..xx.xxx...x....xxxxx.xxxx...xx.xxxxxx.........................\r\n" + 
				"....xxxx..x.xxx.x.x.xx..xx.x.xxx..xx..xxx.x.....x....x.xxx.xxxx..xxxxx.xx...........................\r\n" + 
				"......xxxxxxx.x.xxxxx...x..xx..x..xx..xxxxx.....x....x.xxxxxx.x.x.xx...x............................\r\n" + 
				"..xxxxx...xxxxxx.xx.x...xx.xx..x...x..xxx.......x....x..xxxxx.xxx..xxxx.x.x.........................\r\n" + 
				"..xxxx...xxxx...xxxxx...xx..xxxx...x..x.x......xx...xxxxxx.x.xxxx..xxxx.xxxxxx......................\r\n" + 
				"....xx.x..x.xxxxxxx.xx..xx.x.x.xxxxxx..xx.xxx...x....xxxxx.xxxx...xx.xxxxxx.........................\r\n" + 
				"...xxxxx..x.xxx.x.x.xx..xx.x.xxx..xx..xxx.x.....x....x.xxx.xxxx..xxxxx.x............................\r\n" + 
				"....xxxxxxxxx.x.xxxxx...x..xx..x..xx..xxxxx.....x....x.xxxxxx.x.x.xx...xx..x........................\r\n" + 
				".xxxxxx...xxxxxx.xx.x...xx.xx..x...x..xxx.......x....x..xxxxx.xxx..xxxx.x.xx........................\r\n" + 
				"..xxxx...xxxx...xxxxx...xx..xxxx...x..x.x......xx...xxxxxx.x.xxxx..xxxx.xxxxxxx.....................\r\n" + 
				".....x.x..x.xxxxxxx.xx..xx.x.x.xxxxxx..xx.xxx...x....xxxxx.xxxx...xx.xxxxxx.........................\r\n" + 
				"...xxxxx..x.xxx.x.x.xx..xx.x.xxx..xx..xxx.x.....x....x.xxx.xxxx..xxxxx.xx...................xx......\r\n" + 
				"....xxxxxxxxx.x.xxxxx...x..xx..x..xx..xxxxx.....x....x.xxxxxx.x.x.xx...xx..x................xx......\r\n" + 
				".xxxxxx...xxxxxx.xx.x...xx.xx..x...x..xxx.......x....x..xxxxx.xxx..xxxx.x.xx.......xxxxxxxxxx.......\r\n" + 
				"..xxxx...xxxx...xxxxx...xx..xxxx...x..x.x......xx...xxxxxx.x.xxxx..xxxx.xxxxxxx...xxxxx.xx.xxx.xxx..\r\n" + 
				".....x.x..x.xxxxxxx.xx..xx.x.x.xxxxxx..xx.xxx...x....xxxxx.xxxx...xx.xxxxxx.......xxx...xxxxx..x....\r\n" + 
				"...xxxxx..x.xxx.x.x.xx..xx.x.xxx..xx..xxx.x.....x....x.xxx.xxxx..xxxxx.xx.........x.x...xx.xx.xxx.x.\r\n" + 
				".......xxxxxx.x.xxxxx...x..xx..x..xx..xxxxx.....x....x.xxxxxx.x.x.xx...xx..x......x.x.x.xx..x.xxxxx.\r\n" + 
				"..xxxxx...xxxxxx.xx.x...xx.xx..x...x..xxx.......x....x..xxxxx.xxx..xxxx.x.xx......x.xxxxxx..xx.xxxx.\r\n" + 
				".xxxxx...xxxx...xxxxx...xx..xxxx...x..x.x......xx...xxxxxx.x.xxxx..xxxx.xxxxxxx...x..xx.xx.xxx.xxx..\r\n" + 
				"....xx.x..x.xxxxxxx.xx..xx.x.x.xxxxxx..xx.xxx...x....xxxxx.xxxx...xx.xxxxxx.......x.....xxxxx..x....\r\n" + 
				"...xxxxx..x.xxx.x.x.xx..xx.x.xxx..xx..xxx.x.....x....x.xxx.xxxx..xxxxx.xx.........x.x...xx.xx.xxx...\r\n" + 
				"....xxxxxxxxx.x.xxxxx...x..xx..x..xx..xxxxx.....x....x.xxxxxx.x.x.xx...xx..x......x.x.x.xx..x.xxxxx.\r\n" + 
				"..xxxxx...xxxxxx.xx.x...xx.xx..x...x..xxx.......x....x..xxxxx.xxx..xxxx.x.xx......x.xxxxxx..xx.xxx..\r\n" + 
				".xxxxx...xxxx...xxxxx...xx..xxxx...x..x.x......xx...xxxxxx.x.xxxx..xxxx.xxxxxxx...x..xx.xx.xxx.xx...\r\n" + 
				"....xx.x..x.xxxxxxx.xx..xx.x.x.xxxxxx..xx.xxx...x....xxxxx.xxxx...xx.xxxxxx.......x.....xxxxx..xx...\r\n" + 
				"...xxxxx..x.xxx.x.x.xx..xx.x.xxx..xx..xxx.x.....x....x.xxx.xxxx..xxxxx.xx.........x.x...xx.xx.xxx.x.\r\n" + 
				".....xxxxxxxx.x.xxxxx...x..xx..x..xx..xxxxx.....x....x.xxxxxx.x.x.xx...xx..x......xxx.x.xx..xxxxxxx.\r\n" + 
				".xxxxxx...xxxxxx.xx.x...xx.xx..x...x..xxx.......x....x..xxxxx.xxx..xxxx.x.xx......x.xxxxxx..xx.xxx..\r\n" + 
				"..xxxx...xxxx...xxxxx...xx..xxxx...x..xxx......xx...xxxxxx.x.xxxx..xxxx.xxxxxxx...x..xx.xx.xxx.xxxx.\r\n" + 
				"...xxxxxx...xxxx....xx...xxxxxxx..xxxx.x..x.xxxxxxxx.x.......x...xxxxx...................xxxx.......\r\n" + 
				"...xxx..xx..xxxx.xxxxx.xxx.xxxx..xx.xxxx..x.xx...x...x.....xxxxx..xxxxx..................xxxx.......\r\n" + 
				"...xxx.xx.x.xxx.xxx.xx.xxx.x.xx.x.xxxx.xx.x.x........x......xxxx.xxx..xxx.x.............xx.xx.......\r\n" + 
				"....xx.x..x.xxxxxxx.xx..xx.x.x.xxxxxx..xx.xxx........xxxxx.xxxx...xx.xxxxxx.............xxxxx..x....\r\n" + 
				"...xxxxx..x.xxx.x.x.xx..xx.x.xxx..xx..xxx.x..........x.xxx.xxxx..xxxxx.xx...........x...xx.xx.xxx...\r\n" + 
				"....xxxxxxxxx.x.xxxxx...x..xx..x..xx..xxxxx..........x.xxxxxx.x.x.xx...xx..x........x.x.xx..x.xxxxx.\r\n" + 
				"...xxxx...xxxxxx.xx.x...xx.xx..x...x..xxx.......x....x..xxxxx.xxx..xxxx.x.xx........xxxxxx..xx.x....\r\n" + 
				".xxxxx...xxxx...xxxxx...xx..xxxx...x..x.x......xx...xxxxxx.x.xxxx..xxxx.xxxx.xx...x..xx.xx.xxx.xxxx.\r\n" + 
				".x.xxxx.xx..xx..xxxxxxx..x...xxx.xxx.xxxxx....xxxxx..xxxxxxxxxx..xx.xxxxx....xx...xx.xxxx..xxx.xx...\r\n" + 
				".xx.xx..xx.xx..xxxxxxxxxxxx.xxx..xxxxxxxxx...xxx.x.xxxxx.xxx.xx...x.xxxx.xxxxxxxxxx.xxxx.x.x.xxxx...\r\n" + 
				".xx.x...xxxxx..xxx..xxxxxxx...xx.xxxxxx.xx...xx.xx.xx.xxxxxx.xxxx.x..xxxxxx..xxxxx..x.xxxxxx.x..x...\r\n" + 
				".x....xxxxx.xxx..xx..xxxxxxx...xxxxxxxxxx..xxxx.xxxxxxxxxx.x.xxxxxxx.xxxxx..xx..x......xxxx..x..x...\r\n" + 
				"xx.....xxxxxxxxx.x..xxxx.xxx.xxx.xxxxxx.xxxx.xxxxxxxxxxxx...xxx.xxx...xx.x.xxx..x........x...xx.x.x.\r\n" + 
				"xxx..xx.xxxxxxx.xxx.x.xxxx.xxx.x.xxxx.xx..xx.x..x....xxx......xxx......xx..xxxxxxx.x.x.......xx.xxx.\r\n" + 
				"xxxx.xxxx.xx....x.xxxx.xx.xxxxxx.x.xxx.xxxxx.xxx.....x.xx....xxxx..x..xxxx.xx.x.xxxx.x.......xxxxx..\r\n" + 
				"x.x.....xxxxxxxxxx.xxxxx..x...xx.x.x.xxxxxxx...xx......x...xx..xx.xxx....xxxxxx...xx.xxx....xxxxxxx.\r\n" + 
				"........xxxx..xxx..xxx.xx.xx..xx.x...x.x.x.xxxx.xx.xx..x...xxxxxxx.x.x.xxxxxxxx..xxx.x.x.xxx..xxxxxx\r\n" + 
				"...........x...xx....x..x.xxxxxxxx.x.xxxxx.x..xxxx.xxx.....xxxxx.xxx.x.xx...xx...x.x.x.x.xxxxxxxxxxx\r\n" + 
				"...xxxx....xx.xx........x.xxxxxxxxxxxxxx...xx.x.xxxxx....xxxxx.xxxxxxxxx..xx.xx..x..xxx..xx.xxxxxx..\r\n" + 
				"xxxxxxxx....x.xxx.x..xx...xxxxx...x.xx...xxxxx.x.xxxxxxxxxxxxxxx.xxx.x.xxxxx....xx..xxxxx.xxxxxx.xx.\r\n" + 
				"xxxxxxxx......x..xxx.xxx...x.x..xxx..xxxxxxx.x.x....xxxxxx.xxxxxxx.x.xxx.xxxxxx.x....xx...x.........\r\n" + 
				".xx.xxxx.xx......xxxxxxxxx..x....xx.xxxx..xx.xxx.xxxxxx.x.....x..xxx.x.x.x.xxxxxxxxxxx.x..x.........\r\n" + 
				"xxxxx.x.xxxxx..xxxx.xxxxx...xxx..xx.xxx...xxxxxxxxxx.x.......xx..xxx.xxxx...x.xx.xxxxxxxxxxxx.......\r\n" + 
				".xx.xxxxxxxxx..xxxx.xxxx.xxxxxxxx.x..xxx.xxxx.xx....xxx..x...xx.xxxxx...x....xx.xxx.xxx..x.xx.......\r\n" + 
				"xxx...xxx.xxx....xxxxx.xxxxxx.xxxxx.xxx.xxx.xx.x...x.xx..xxxxx.x.xxxxx.xx.xxxx.xxxxxx.xx....x.......\r\n" + 
				"...x...xxxxx....xxx.xxxx...xx.x.xxxx.xx.xxx.xx.....x..x.xxx..xxxxx.x.......x.xx.x..xxxxx........x.xx\r\n" + 
				"..xxxx.xxx.x.x...xxxx.xxx.xx.xxxxx.x.x.xx.xxx.xxxxxx.xxxxx.x.x..x.xxxx..xx.xx.xxxx.xx..x.x...xx.xxxx\r\n" + 
				"..xxxxx..xxxxxx..xx.xx..x....x..xxxxx.xxx..x...xxxxxxxx..xxx........x.x..xxxxxxx.xxxxxx..xxxxxxxxxx.\r\n" + 
				"..xxxxxxxx....x.xxxx.....xxx.x....xxxx..x...xxx.x.xxx.x..xxxx.xx...xx.x.xx.....xxx.xx.x..xx..xxxxxxx\r\n" + 
				"..xxx..x..xxxxx..xxx..xx..x...xx.xxxxxxxxx.xxxx.xxx.x....x.x..x..xxxxxxxxxx...xx...x....xxxxxxxxxxxx\r\n" + 
				"...x..xxxxxxxxx..xxxxxx.x.xxxxxx.xxxx..xx.xx.xxx.xx.....xxx..xxxxx.xx.xxx.xxx.xx...x....xx..xxxxxx..\r\n" + 
				"..xxxx.x.xxx.x.x..xxxxx.xx.xx..x.xx.x...xx.x.xxxxx....xxxxx.xxxxxxx.x..xxxxxxxxx...xxxxxx..xxxxxx...\r\n" + 
				"xx..x..xxx.xxxxxx..xx..x.xxxxx....x..x..x.xxxx.xx..xxxxxxxxxx...xxxxxxx.xx..x.xxx..x.xxxxxxx..xxx.xx\r\n" + 
				"xx.x.x.xxxxxxxxxx.xxxx.xx..xxxxxxxxxxxxxxx.x..xxxxxxx...x...xxxxxx.xxxxxxx..xx...xx..xxxxxx.xxx...x.\r\n" + 
				".xxx.xx.xx.x.x.xx.xxxxxxx.xx..xxxx.xx.xxxxxx...xx.xxxx...xxx.xxx....xxx..x...xxxxxxxxxxxx....xx.xxx.\r\n" + 
				".xxx.xxxx.xxxxx.....xx..x..xxxxx......xxxxxxxxx...xxxxx.xxxxx.xx..xx..x..xxxxxxx..xxxxx.xx....xxxxx.\r\n" + 
				".xxx.x..x.xx.xxxxxxx.x.x.xxxx..xxx.xxxxxxx.xxxxxxxxxxxx.x..x.xxxxxx.xx.x.xxxxxx...xxxxxx.xxxx.xxxx..\r\n" + 
				"xxx.xxxxxxxx.xxxxxxx.xxxx..x..xxxx.xxx...x.xxxxxxxxxxxxx.xxxx.xxxxx.xxxx.xx.xxxx.xxx...x.xx.x.xxxx..\r\n" + 
				".xxxxx..x.x.xx.xx.xxx..xxxx...xx.xxxx.xxxxxxxxx..xx.xx.xxx.xxx.xxx.x.xxx.xxxx.x.xxxx..xxx.xxxxxxxxxx\r\n" + 
				"....xxxx.xx..x..xxxx...xx.xxxxxx.x.xxxxxx.x.xxxx.x.xxxxxx..xxxxxx.xxx.xxx.xx..xx.x..xxxx.xxx.xxxxxx.\r\n" + 
				"xx..xx.xx..xxx....xx.x.xxx.xx.xxx.xx.x..x.xxxxx.xx.xxx...xxxxx.xxxx.x..x.x....x..x.xx.xxx...........\r\n" + 
				"xxxx.xxxxxxx...xxxx..xxxx.xxxx....xxxx..x.xxxx.x.xxxxxxxxxxxxxxxx.xxxx.xxxx.xxx..x.xx.........x...x.\r\n" + 
				"...x...x..x.xxxxxx...xxxxx.xx.xxxx.xx.......xxxxx...x.xxxxxxx..xxxxxxxxxxxxxx..xxxxxxxxxx..xxxxxx.xx\r\n" + 
				".xxxxxxxxx.xxxxx...x..xx..xxx..xx.xx..xx..xxxxxxxxxxxxxxxxxxx..x...xxxxxxxxx.xx...xxx....xxxxxxxxxx.\r\n" + 
				"xxxxxxx..x.xxxxx..xxxxxxxxxxxx.xxxxxxxxxxxxx..xx.xxxxx.x.xxxxx...xxxxxxxxxxx.xxxxxxxx.xxxxx.xxxx....\r\n" + 
				".xx.xx.xxxx..xxxxxxxxx..x.x..xx.xx.xxx.xxx.xxxx.x.x..xx.xxxx.xxx.xxx.x.xxxxx.xx.xxxxx.x.x.xxx..xxxxx\r\n" + 
				"..xx.xx.xxx.xxxxxxxxxxxxx.x.xxx.xxxxxxxxxxxxxx.xxxxxxx.xxxxxxxxxxxxx.xxxxxx..xxxxxxx..xxxx.x..xxxxxx\r\n" + 
				"..xxxxxxx.xxx.xxxx.xxx..xxxxxxxxx..xxxx.xxxxxxxxxxxxx..xxx.xxxx.xxxxx.xxxxxxxxxxxxx...xxx.xxxxx.xxxx\r\n" + 
				"xxxxxx...xxx.xxxxx.x...xxxxxx...x.xx.xxx.xxxxx..xxx.xxxxxxxx.xx.xx..xxxxx.xxxxxxxxxxxxx.x.xxxxxxx.xx\r\n" + 
				".............................................................................................x......\r\n" + 
				"xxx.xxx.xx.xxxxxx.xxxxxxx.xxx.x..xxxxxxxx.xxx.xxxx.xx.xxx.xxxxxxxx.x.xxxx.xxxxx.xx.xxxxxx.xxxxxxxx..\r\n" + 
				"xx.xxxxx.xxxxxxxxxx..xxxxxxxxxxxxx.xx.xxxx.xxxxxx.xx.xx.xxx.xxxxxx.xxxxxx.xxx.x.xxxxxxxxxx.x.xx.xxxx\r\n" + 
				".xxx.xxxxxxxxxxxxxxxxxxxxxx.xxxxxxx.x.xxxxxxxxxxx.x..x.xxxx.xx.xxx.xxxxxxxx.xxxxx.xx..xxx..x.xxx.xxx\r\n" + 
				"..xx.xxxxxx.xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.xxxxxxxxxxxxxxxxxxxxxxxx.xx.x.xxx.x.xxxxxxx.xxxxxxxxxxx.x\r\n" + 
				"..xxxx.xxxxx.xxxxxxxx.xx.xxxxxx.xxxxxxxxxx.xxxxxxxxxxxxxxx.xxxxxxxxxx.xxxx.x.xxxxx.xxxx.xxxxxxx.xxxx\r\n" + 
				"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.xxxxxxxxx.xxxxxxx...xxx.xxxxx.xxxxxxxxxxxxxxxxxxxxx.xxxxx.xxx.xx\r\n" + 
				"xxxxxxxxxxx.xx.xxxxxxxxxxxxxxx.xx.xxxxxxxxxxx.xxxxxxxxxxxxxx.xxxxxx.xxxxxxxxxxx.xx.xxxxx.xx..xxx.xx.\r\n" + 
				".xxxxx..xxxxxxxxxxxxx.xxxxxxxxxxxx.xxxxx.xxxxxxxx.x.xxxxxxxxxxxx.xx.xxxxxxxxxxxx.xxxxx.xx.xxxxxxxxxx\r\n" + 
				"xxxxxxxxxxxx.xxxxxxxxxxxxxxxxxxx.x.xxxxxxxxxxxxx.xxxxxxxxxx.xxxxxxxxxxxx.xxx.xxxxxxxxxxxxxxxxxxxxxxx\r\n" + 
				"xxxxxxxxx.xxxx.xxxxxxxxxxx..xxx.xxxx.xx.xxxxxxxxxxxxxxxxxxxxx.xxxx.xxxxxxxxxxxxxxxxxxxxxxxxxx.xxxxx.\r\n" + 
				"...xxx..xxxx.xxxx.xxxxxx.xxxxxxxx.xxxxxxxxxxxxxx.xxx.xxxx.x.xxxxxxxx.xxxxxxxxxxxx.xxxxxxxxxxxxxxxxx.\r\n" + 
				"...x.xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.xx.xx..xxxxxxxxxxxxxxxxxxxxxxxxxxxx\r\n" + 
				"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.xxxxxxxxxxxxxxxxxxxxxxx.xxxxxxxxxxx.xx.xxxxxxxxxx\r\n" + 
				".xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.\r\n" + 
				"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
		System.out.println(str1.equals(str2));
	}
}