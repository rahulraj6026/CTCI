package Firstchapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * This programs is to find unique characters in a given string. This will be handled
 * in two ways
 * 
 * M-I: Using a boolean array of size 26 and then we change the boolean value of current
 * character if that character is found. If that character occurs again then the value
 * is updated and we return the output
 * 
 * M-II: As in previous approach we used extra space but had TC O(n) we need a simple 
 * approach to solve this. What we do is we check whether the bit is set for the ASCII 
 * value. If it is set then that character already occurs. If it is not set we set it 
 * for future reference
 * 
 * We can sort and compare characters but it will take O(nlogn)
 * 
 * We assume that string consist of all lower case characters
 * 
 */
public class Unique_Characters {
	public static boolean methodOne(String s) {
		boolean[] ch = new boolean[26];
		
		for(int i=0; i<s.length(); i++) {
			int val = s.charAt(i) - 'a';
			if(ch[val]) return false;
			ch[val] = true;
		}
		return true;
	}
	
	public static boolean methodTwo(String s) {
		int checker = 0;
		
		for(int i=0; i<s.length(); i++) {
			int val = s.charAt(i) - 'a';
			if((checker & (1<<val)) > 0)//check whether bit is set or not
				return false;
			checker |= (1<<val);//if bit is not set we set the bit
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		System.out.println(methodOne(s));//TC:O(n) SC:O(n)
		
		System.out.println(methodTwo(s));
		
	}
}
