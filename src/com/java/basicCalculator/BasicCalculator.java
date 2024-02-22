package com.java.basicCalculator;

import java.util.Scanner;

public class BasicCalculator 
{
	static
	{
		System.out.println("Welcome to Basic Calculator");
		System.out.println("---------------------------");
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		char decider; // in or out of the loop
		
		do
		{
			try
			{
				// user input
				System.out.println("Enter 1st number :");
				int firstNumber = Integer.parseInt(sc.nextLine());
				System.out.println("Enter 2nd number :");
				int secondNumber = Integer.parseInt(sc.nextLine());
				
				// menu
				System.out.println("\tMenu");
				System.out.println("\t----");
				Operations.menu();
						
				while(true)
				{
					try
					{
						// choice
						System.out.println("Enter your choice ('+', '-', '*', '/') :");
						char choice = sc.next().charAt(0);
						
						// Arithmetic operations
						int result = Operations.performArithmeticOperation(firstNumber, secondNumber, choice);
						System.out.println(firstNumber+" "+choice+" "+secondNumber+" = "+result);
						break;
					}
					catch(InvalidChoiceException e)
					{
						System.err.println("Error : "+e.getMessage());
					}					
				}
			}
			catch(NumberFormatException e)
			{
				System.err.println("Error : Please enter integers only");
			}
			catch(ArithmeticException e)
			{
				System.err.println("Error : Cannot divide by zero");
			}
			catch(Exception e)
			{
				System.out.println("Error : "+e.getMessage());
			}
			
			System.out.println("Do you want to continue ? Enter 'Y' or 'y' to continue");
			decider = sc.next().charAt(0);
			System.out.println();
			sc.nextLine();
		}while(decider=='Y' || decider=='y');
		
		System.out.println("Thank you! Visit again");
		sc.close();
	}
}