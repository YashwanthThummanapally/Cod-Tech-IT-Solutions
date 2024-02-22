package com.java.basicCalculator;

public class Operations 
{
	public static void menu()
	{
		System.out.println("Addition : +");
		System.out.println("Subtraction : -");
		System.out.println("Multiplication : *");
		System.out.println("Division : /");
	}
	
	public static int performArithmeticOperation(int firstNumber, int secondNumber, char choice) throws InvalidChoiceException
	{
		switch(choice)
		{
			case '+' : return firstNumber+secondNumber;
			case '-' : return firstNumber-secondNumber;
			case '*' : return firstNumber*secondNumber;
			case '/' : return firstNumber/secondNumber;
			default : throw new InvalidChoiceException("Invalid choice. Please enter '+', '-', '*', '/' only");
		}
	}
}
