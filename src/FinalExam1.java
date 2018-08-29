
/** 
 * The program to calculate system of equation.
 * Artin Malekian
 * FinalExam  
 * 4 August 2016
 */

import java.util.Scanner;

public class FinalExam1 {

	public static void main(String[] args) {
		String response;

		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Enter the equations");
			String firstEqu = input.nextLine();
			System.out.println();
			String secondEqu = input.nextLine();

			CramerCalc intersect = new CramerCalc(firstEqu, secondEqu);
			System.out.println(intersect);
			System.out.println();

			System.out.println(" Do you want to continue? y/n");
			response = input.nextLine();
			System.out.println();
		} while (response.equalsIgnoreCase("y"));
		System.out.println();

		System.out.println("Goodbye");
	}

}
