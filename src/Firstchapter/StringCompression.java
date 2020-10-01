package Firstchapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//compress the string 
//aabbcc = a2b2c2
public class StringCompression {
	public static String updateString(String s) {
		StringBuilder br = new StringBuilder();
		int start = 0;
		if(s.length() <= 1) {
			br.append(s.charAt(start));
			br.append(1);
			return br.toString();
		}else {
			int end = start+1;
			while(end < s.length()) {
				if(s.charAt(start) != s.charAt(end)) {
					br.append(s.charAt(start));
					br.append(end-start);
					start = end;
				}
				end++;
			}
			br.append(s.charAt(start));
			br.append(end - start);
		}
		
		return br.toString();
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		s = updateString(s);
		
		System.out.println(s);
	}
}
