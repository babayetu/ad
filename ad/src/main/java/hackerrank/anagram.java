package hackerrank;

import java.util.Scanner;

/*
 * anagram 打乱字母顺序变成另一个词，比如silent打乱字母顺序重新组合可以变成listen
 * 
 * https://www.hackerrank.com/challenges/anagram
 * 
 * 1. 如果字符串长度S1+S2是奇数，不等长，肯定不会是anagram，返回-1
 * 2. 否则把字符串切成s1和s2，统计各自字符的数目，两个char[26]数组，两两比较，不同的，则sum增加不同的部分
 * 3. 最终返回总的sum的数值
 */
public class anagram {
	private static int minChangeForAnagram(String a) {
		if (a==null) {
			return -1;
		}
		if (a.length() % 2 != 0) {
			//无法切成两份等长的字符串
			return -1;
		}
		
		char[] ac = a.toCharArray();
		int[] s1count=new int[26];
		int[] s2count = new int[26];
		
		int half = ac.length / 2;
		
		for (int i = 0; i < half; i++) {
			s1count[ac[i] - 'a']++;
			s2count[ac[i+half] - 'a']++;
		}
		
		int sum=0;
		for (int i = 0; i < s1count.length; i++) {
			sum=sum+Math.abs(s1count[i] - s2count[i]);
		}
		
		//因为总的不同数是2份，只需要变一半就能变成一样的了
		return sum / 2;
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
	
		for (int i = 0; i < input.length; i++) {
//			System.out.println(input[i]);
			System.out.println(minChangeForAnagram(input[i]));
		}		
	}
}