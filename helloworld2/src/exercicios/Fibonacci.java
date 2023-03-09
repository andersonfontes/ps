package exercicios;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println("FIBONACCI \n\n");
		System.out.println("digite o maximo \n");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int maximoint = scanner.nextInt();
				
	 //scanner.
				
		int i=1 , last=0;
		while (i < maximoint) {
			System.out.print(i + "\n");
			last=i;
			i=i+last;
		}
		

	}

}
