package Firstchapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * Check whether a string is permutation of other (abcd) (dabc)
 * 
 * M-I: In this method we simply check whether the strings are equal are not after sorting
 * we require to sort the string which is O(nlogn) and then for comparision O(1)
 * 
 * M-II: In this method we take a character array and then increment the count of that character.
 * Then with the second array we decrement the count and then if the count<0 we return false as it is not present.
 * O(length of biggest string)
 */
public class Check_Permutation {
	public static String sortA(String s) {
		char[] a = s.toCharArray();
		
		Arrays.sort(a);
		
		return new String(a);//if we use toString it will return the object
	}
	public static boolean methodOne(String a, String b) {
		if(a.length() != b.length()) return false;//if size is not same
		
		return sortA(a).equals(sortA(b));
	}
	
	public static boolean methodTwo(String a, String b) {
		if(a.length() != b.length()) return false;
		
		int c[] = new int[26];
		
		for(int i=0; i<a.length(); i++)//O(len(a))
			c[a.charAt(i) - 'a']++;
		
		for(int i=0; i<b.length(); i++) {
			int val = b.charAt(i) - 'a';
			c[val]--;
			if(c[val] < 0)
				return false;
		}//O(len(b))
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		String a = br.readLine();
		String b = br.readLine();
		
		System.out.println(methodOne(a,b));
		
		System.out.println(methodTwo(a,b));
		
	}
}
