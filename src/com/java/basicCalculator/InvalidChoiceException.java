package com.java.basicCalculator;

public class InvalidChoiceException extends Exception
{
	public InvalidChoiceException()
	{
		super();
	}
	
	public InvalidChoiceException(String message)
	{
		super(message);
	}
}
