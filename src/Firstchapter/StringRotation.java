package Firstchapter;

/*
 * Given two strings, s1 and s2, write code to check if s2 is
 * a rotation of s1 using only one call to isSubstring (e.g., "waterbottle" is a
 * rotation of "erbottlewat").
 * 
 * We concatenate first string and check whether there is any substring i.e. s2
 */
public class StringRotation {
	public static boolean isRotation(String s1, String s2) {
	      if (s1.length() != s2.length()) {
	         return false;
	      }
	      String s1s1 = s1 + s1;
	      System.out.println(s1s1);
	      return isSubstring(s1s1, s2);
	   }
	   
	   private static boolean isSubstring(String str, String substr) {
	      return str.contains(substr);
	   }
	   
	public static void main(String[] args) {
		System.out.println(isRotation("erbottlewat", "waterbottle"));
	      System.out.println(isRotation("cat", "dog"));
		
		
	}
}
