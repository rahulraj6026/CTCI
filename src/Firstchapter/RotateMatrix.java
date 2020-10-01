package Firstchapter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

/*
 * We simply traverse from first element to leftmost bottom element then followed by
 * rightmost bottom element and then atlat rightmost top element by swapping the elements. 
 */
public class RotateMatrix {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
		int N = mat.length;
		
		//for a given matrix we have n/2 squares
		//for n=3 we have 1 square for 4 we have two squares
		for(int i=0; i<(N/2); i++) {
			for(int j=i; j<(N-i-1); j++) {
				int temp = mat[i][j];//top element
//				System.out.println(temp);
				mat[i][j] = mat[N-1-j][i];//Leftmost corner bottom element
//				System.out.println(mat[N-1-j][i]);
				mat[N-1-j][i] = mat[N-1-i][N-1-j];//Righmost corner bottom element
//				System.out.println(mat[N-1-j][i]);
				mat[N-1-i][N-1-j] = mat[j][N-1-i];//Rightmost corner top Element 
//				System.out.println(mat[j][N-1-i]);
				mat[j][N-1-i] = temp;
			}
		}
		
		Arrays.stream(mat)
		.map(Arrays::toString)
		.forEach(System.out::println);
	}
}
