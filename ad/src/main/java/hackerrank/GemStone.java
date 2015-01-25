package hackerrank;

import java.util.Scanner;

/* 字符串问题
 * https://www.hackerrank.com/challenges/gem-stones
 * 
 * 算法
 * 1. 把每个字符串的字符计数逐个放入alph
 * 2. 所有没出现过的字母位置都把invalid置为true
 * 3. 最后输出invalid等于false的个数
 * 
 */
public class GemStone {
	private static int findGemNum(String[] s) {
		int[] alph = new int[26];  //记录字符的数目
		boolean[] invalid = new boolean[26];  //初始默认值为0,false
		
		for (int i = 0; i < s.length; i++) {
			char[] ac = s[i].toCharArray();
			for (int j = 0; j < ac.length; j++) {
				alph[ac[j] - 'a']++;				
			}
			for (int j = 0; j < alph.length; j++) {
				if (alph[j] == 0 ) {
					invalid[j] = true;
				}
				alph[j] = 0;
			}
		}
		
		int sum=0;
		for (int i = 0; i < invalid.length; i++) {
			if(!invalid[i]) {
				sum++;
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int line = in.nextInt();
		String[] input = null;
		
		in.nextLine();  //读掉第一行的回车
		
		if (line>0) {
			input = new String[line];
			for (int i = 0; i < line; i++) {
				input[i] = in.nextLine();				
			}
		}		

		System.out.println(findGemNum(input));

	}
}