package hackerrank;

import java.util.Scanner;

/*
 * 全字母句子判断，可能包括大小写，空格，大写和小写是一个句子
 * https://www.hackerrank.com/challenges/pangrams
 */
public class pangrams {
	private static int[] record = new int[26];  //全部初始化为0
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */		
		Scanner in = new Scanner(System.in);
		char[] input = in.nextLine().toUpperCase().toCharArray();
		
		int count = 0;
		
		for (int i = 0; i < input.length && count < 26; i++) {
			if (input[i] == ' ') {
				continue;
			} else {
				if (record[input[i] - 'A'] == 0) {
					record[input[i] - 'A'] = 1;
					count++;
				}
			}
		}
		
		if (count==26) {
			System.out.println("pangram");
		} else {
			System.out.println("not pangram");
		}
	}
}