package Firstchapter;

import java.util.Arrays;

/*
 * M-I: We first find the row and col where the element is zero
 * then based on the finding we make row followed by column elements as zero
 * 
 * M-II: In this method we don't require any extra space. We just traverse through
 * first row and col until we find a zero
 * Then we traverse through all the rows and cols and make it's first row and col as zero
 * Then we make row elements as null followed by col elements
 * Atlast we make first row and col elements as zero as we have skipped and traversed
 * through all the other rows and cols except first
 * 
 */
public class ZeroMatrix {
	public static void checkZeros(int[][] a) {
		boolean row = false;
		boolean col = false;
		
		//check for zero in first row
		for(int i=0; i<a[0].length; i++) {
			if(a[0][i] == 0) {
				row = true;
				break;
			}
		}
		
		//check for zero in first column
		for(int i=0; i<a.length; i++) {
			if(a[i][0] == 0) {
				col = true;
				break;
			}
		}
		
		//check for rest of the matrix and if found zero then make first row and column as zero
		//Except first row and col as it is already traversed
		for(int i=1; i<a.length; i++) {
			for(int j=1; j<a[0].length; j++) {
				if(a[i][j] == 0) {
					a[i][0] = 0;
					a[0][j] = 0;
				}
			}
		}
		
		//make row elements as zero
		for(int i=1; i<a.length; i++) {
			if(a[i][0] == 0)
				nullRow(a, i);
		}

		//make row elements as zero
		for(int i=1; i<a[0].length; i++) {
			if(a[0][i] == 0)
				nullCol(a, i);
		}
		
		//make first row and col zero based on the condition
		if(row) nullRow(a, 0);
		if(col) nullCol(a, 0);
	}
	
	public static void checkZero(int[][] a) {
		boolean[] checkrow = new boolean[a.length];
		boolean[] checkcol = new boolean[a[0].length];
		
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[0].length; j++) {
				if(a[i][j] == 0) {
					checkrow[i] = true;
					checkcol[j] = true;
				}
			}
		}
		
		
		for(int i=0; i<a.length; i++) {
			if(checkrow[i])
				nullRow(a, i);
		}
		
		for(int i=0; i<a[0].length; i++) {
			if(checkcol[i])
				nullCol(a, i);
		}
	}
	
	public static void nullCol(int[][] a, int i) {
		for(int k=0; k<a.length; k++)
			a[k][i] = 0;
	}
	
	public static void nullRow(int[][] a, int i) {
		for(int k=0; k<a[0].length; k++)
			a[i][k] = 0;
	}
	
	public static void main(String[] args) {
		int[][] a = {{1,0,1},{0,1,1},{1,1,1}};
		
		Arrays
		.stream(a)
		.map(Arrays::toString)
		.forEach(System.out::println);
		
		System.out.println();
		
//		checkZero(a);//This method uses extra space
		
		checkZeros(a);//same complexity without extra space
		
//		Arrays
//		.stream(a)
//		.map(Arrays::toString)
//		.forEach(System.out::println);
	}
}
