package Firstchapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome_permutation {
	public static boolean permpal(String s) {
		int bitVector = getBits(s);
		return bitVector == 0 || (((bitVector & (bitVector - 1)) == 0));
	}
	
	public static int getBits(String s) {
		int val = 0;
		
		for(char phrase:s.toCharArray()) {
			int x = phrase - 'a';
			val = toggle(val, x);
		}
		return val;
	}
	
	public static int toggle(int p, int x) {
		int mask = 1 << x;
		
		if((p & x) == 0)
			p |= x;
		else
			p &= ~x;
		return p;
	}
	
	public static boolean findFrequency(String s) {
		int[] c = new int[26];
		int oddCount = 0;
		
		for(int i=0; i<s.length(); i++) {
			int val = s.charAt(i) - 'a';
			
			if(val >= 0) {
				c[val]++;
				if(c[val] %2 == 1)
					oddCount++;
				else 
					oddCount--;
			}
		}
		
		return oddCount <= 1;
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		String s = br.readLine();
		s = s.toLowerCase();
		
		System.out.println(s);
		
		System.out.println(permpal(s));
	}
}
