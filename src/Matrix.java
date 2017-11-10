/* The purpose of this program is to generate 2 square matrices according to the user's dimensional input.
 * The program then manipulates the matrices by multiplying then adding the original matrices together, 
 * displaying the result along with a clock denoting the elapsed time during each function.
 */

import java.util.*;

public class Matrix {
	
static String restart = "y";
static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		while(restart.equals("y")){
			int dimension = 0;
			while(dimension < 25) {
				System.out.println("Input value for square matrices: (min. 25)");
				dimension = input.nextInt();
			}
			System.out.println("Generating dual " + dimension + "x" + dimension + " matrices..." );
			int[][] a = new int[dimension][dimension];
			int[][] b = new int[dimension][dimension];
			Random r = new Random();
			for(int i = 0; i < dimension; i++) {
				for(int j = 0; j < dimension; j++) {
					a[i][j] = r.nextInt(30) + 1;
					b[i][j] = r.nextInt(30) + 1;
				}
			}
			System.out.println("Matrix 1:");
			showMatrix(a);
			System.out.println("Matrix 2:");
			showMatrix(b);
			multiplyMatrices(a,b);
			addMatrices(a,b);
			System.out.println("Restart the program? (y/n)");
			input.nextLine();
			restart = input.nextLine();
		}
		System.out.println("Terminating program...");
	}
	
	public static void showMatrix(int[][] m){ //display matrix within a bracket
		System.out.print(" --");
		for(int i = 0; i < m.length*6 - 4; i++) {
			System.out.print(" ");
		}
		System.out.println("--");
		for(int i = 0; i < m.length; i++) {
			System.out.print("|");
			for(int j = 0; j < m.length; j++) {
				System.out.print(m[i][j] + " ");
				if(m[i][j] < 10000) { 
					System.out.print(" ");
					if(m[i][j] < 1000) {
						System.out.print(" ");
						if(m[i][j] < 100) {
							System.out.print(" ");
							if(m[i][j] < 10) {
								System.out.print(" ");
							}	
						}	
					}
				}
				
				
			}
			System.out.println("|");
		}
		System.out.print(" --");
		for(int i = 0; i < m.length*6 - 4; i++) {
			System.out.print(" ");
		}
		System.out.println("--");
	}
	
	public static void multiplyMatrices(int[][] a, int[][] b){
		System.out.println("Multiplying matrices...");
		long start = System.currentTimeMillis();
		int product[][] = new int[a.length][b.length];
		for (int i = 0; i < a.length; i++) { 
		    for (int j = 0; j < b.length; j++) { 
		        for (int k = 0; k < a.length; k++) { 
		            product[i][j] += a[i][k] * b[k][j];
		        }
		    }
		}	
		showMatrix(product);
		long time = System.currentTimeMillis() - start;
		System.out.println("Time to complete: " + time + " ms");
	}
	
	public static void addMatrices(int[][] a, int[][] b){
		System.out.println("Adding matrices...");
		long start = System.currentTimeMillis();
		int sum[][] = new int[a.length][b.length];
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < b.length; j++) {
				sum[i][j] = a[i][j] + b[i][j];
			}
		}
		showMatrix(sum);
		long time = System.currentTimeMillis() - start;
		System.out.println("Time to complete: " + time + " ms");
	}

}
