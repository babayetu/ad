package hackerrank;

import java.util.Scanner;

/*
 * Palindrome Index 字符串是否删掉一个字母变成回文的
 * 如果可以输出删掉字符的位置，从0开始，如果字符串已经是回文的，或者找不到，则输出-1
 * 
 * https://www.hackerrank.com/challenges/palindrome-index
 * 
 * 思路：
 * 1.两个游标，一个在最前i=0，一个在最后j=len-1，比较扫描i++,j--，直到i==j
 * 2.找到第一个不同的a[i]!=a[j]
 * 3.如果a[i+1]==a[j]，则a[i]必定需要被删除，此时i++，设置flag=1，表明已经删除了一个字符，继续下一轮
 *   否则如果a[i]==a[j-1],说明a[j]需要被删除，此时j--,设置flag=1，表明已经删除了一个字符，继续下一轮
 *   否则返回-1，因为无论怎么删除一个字符也不可能是回文
 */
public class palindromeIndex {
	private static int findDeletedPosForPalindrome(char[] input) {
		if (input.length == 0) {
			return -1;
		}
		
		int i=0;
		int j=input.length - 1;
		int flag = 0;
		int delPos = -1;
		
		//处理特殊case
		boolean dualPossible = false;
		int remi = -1;
		int remj = -1;
		
		while (i<j) {
			if (input[i] == input[j]) {
				i++;
				j--;
				continue;
			} else {
				if (flag > 0) {
					//已经删掉过字符了，题目不允许删2次
					if (!dualPossible) {
						return -1;
					} else {
						//否则走第二种情况
						delPos = remj;
						i=remi;
						j=remj-1;						
						flag=1;
						continue;
					}					
				}
				
				//此处有bug
				//输入 1
				//hgygsvlfcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcwflvsgygh
				//输出 44
				//之判断一种情况未必正确，如果两种情况都可以的话，应该都用来计算
				if (input[i+1] == input[j] && input[i] == input[j-1]) {
					//需要判断两种情况
					dualPossible = true;
					remi=i;
					remj=j;
					delPos = remi;
					i++;
					flag++;
					continue;
				} else if (input[i+1] == input[j]) {
					delPos = i;
					i++;				
					flag++;
					continue;
				} else if (input[i] == input[j-1]) {
					delPos=j;
					j--;
					flag++;
					continue;
				}
			}
		}
		
		if (flag==0) {
			//回文
			return -1;
		} else {
			return delPos;
		}
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
			System.out.println(findDeletedPosForPalindrome(input[i].toCharArray()));
		}		
	}
}