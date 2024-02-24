package com.java.TicTacToegame;

import java.util.Scanner;

public class OXGameTest 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter 1st player name :");
		String player1 = sc.nextLine();
		
		System.out.println("Enter 2nd player name :");
		String player2 = sc.nextLine();

		OXGame game = new OXGame(player1, player2);
		
		for(int positionsFilled=0; positionsFilled<game.getArr().length;)
		{
			game.displayResult();
			
			if(positionsFilled%2==0)
			{
				System.out.println(player1+" : Enter a position to insert 'X'");
			}
			else
			{
				System.out.println(player2+" : Enter a position to insert 'O'");
			}
			
			String position = sc.nextLine();
				
			try
			{
				game.validateAndUpdatePosition(position, (positionsFilled%2==0) ? "X" : "O");
				positionsFilled++;
				if(positionsFilled>=3)
				{
					String winner = game.validationToFindTheWinner();
					if(!winner.isEmpty())
					{
						System.out.println(winner+" is the winner");
						break;
					}
					else if(winner.isEmpty() && positionsFilled==9)
					{
						System.out.println("Match drawn");
					}
				}
			}
			catch(IllegalArgumentException e)
			{
				System.out.println("Error : Only integers are allowed here");
			}
			catch(InvalidPositionException e)
			{
				System.out.println("Error : "+e.getMessage());
			}
			catch(AlreadyPlacedException e)
			{
				System.out.println("Error : "+e.getMessage());
			}
			System.out.println();
		}
		sc.close();
	}
}