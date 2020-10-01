package Firstchapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//check if only one operation is enough to make two strings equal.
public class OneAway { 
	public static boolean getCount(String one, String two) {
		//if difference between two strings is more than one then there is no way to check
		//for one way
		if(Math.abs(one.length() - two.length()) > 1) return false;
		String small = (one.length() < two.length())?one:two;
		String big = (one.length() < two.length())?two:one;
		
		int i = 0, j = 0;
		boolean findDiff = false;
		
		while(j<big.length() && i<small.length()) {
			if(small.charAt(i) != big.charAt(j)) {
				if(findDiff) return false;//this is the first difference found
				findDiff = true;
				
				//if it is replace then increment count of smaller string
				if(small.length() == big.length()) i++; 
			}else {
				i++;//increment small string index if equal
			}
			j++;//increment big string index whatever be the case
		}
		return true;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		String one = br.readLine();
		String two = br.readLine();
		
		System.out.println(getCount(one, two));

	}

}
