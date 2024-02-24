package com.java.TicTacToegame;

public class InvalidPositionException extends RuntimeException
{
	public InvalidPositionException()
	{
		super();
	}
	
	public InvalidPositionException(String message)
	{
		super(message);
	}
}