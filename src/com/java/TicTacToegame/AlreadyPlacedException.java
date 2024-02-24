package com.java.TicTacToegame;

public class AlreadyPlacedException extends RuntimeException
{
	public AlreadyPlacedException()
	{
		super();
	}
	
	public AlreadyPlacedException(String message)
	{
		super(message);
	}
}