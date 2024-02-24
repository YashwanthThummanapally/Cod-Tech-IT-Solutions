package com.java.TicTacToegame;

public class OXGame 
{
	private String arr[];
	private String player1;
	private String player2;
	
	public OXGame(String player1, String player2)
	{
		super();
		this.player1 = player1;
		this.player2 = player2;
		this.arr = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
	}
	
	public void setArr(String arr[])
	{
		this.arr = arr;
	}
	
	public String[] getArr()
	{
		return this.arr;
	}
	
	public void setPlayer1(String name)
	{
		this.player1 = name;
	}
	
	public String getPlayer1()
	{
		return this.player1;
	}
	
	public void setPlayer2(String name)
	{
		this.player2 = name;
	}
	
	public String setPlayer2()
	{
		return this.player2;
	}	
	
	public void displayResult()
	{
		for(int i=0; i<this.arr.length; i++)
		{
			System.out.print(arr[i]+"\t");
			if((i+1)%3==0)
			{
				System.out.println();
			}
		}
	}
	
	public void validateAndUpdatePosition(String position, String updatedValue)
	{
		int validPosition = Integer.parseInt(position);
		
		if(validPosition>=1 && validPosition<=9)
		{
			if(this.arr[validPosition-1].equals("X") || this.arr[validPosition-1].equals("O"))
			{
				throw new AlreadyPlacedException("Previously selected position cannot be changed. Please select different position");
			}
			else
			{
				this.arr[validPosition-1] = updatedValue;
			}
		}
		else
		{
			throw new InvalidPositionException("Invalid position selected. Please select position from 1 to 9 only");
		}
	}
	
	public String validationToFindTheWinner()
	{
		if(this.arr[0]==this.arr[1] && this.arr[1]==this.arr[2])
		{
			if(this.arr[0]=="X")
			{
				return this.player1;
			}
			else
			{
				return this.player2;
			}
		}
		else if(this.arr[3]==this.arr[4] && this.arr[4]==this.arr[5])
		{
			if(this.arr[3]=="X")
			{
				return this.player1;
			}
			else
			{
				return this.player2;
			}
		}
		else if(this.arr[6]==this.arr[7] && this.arr[7]==this.arr[8])
		{
			if(this.arr[6]=="X")
			{
				return this.player1;
			}
			else
			{
				return this.player2;
			}
		}
		else if(this.arr[0]==this.arr[3] && this.arr[3]==this.arr[6])
		{
			if(this.arr[0]=="X")
			{
				return this.player1;
			}
			else
			{
				return this.player2;
			}
		}
		else if(this.arr[1]==this.arr[4] && this.arr[4]==this.arr[7])
		{
			if(this.arr[1]=="O")
			{
				return this.player2;
			}
			else
			{
				return this.player1;
			}
		}
		else if(this.arr[2]==this.arr[5] && this.arr[5]==this.arr[8])
		{
			if(this.arr[2]=="O")
			{
				return this.player2;
			}
			else
			{
				return this.player1;
			}
		}
		else if(this.arr[0]==this.arr[4] && this.arr[4]==this.arr[8])
		{
			if(this.arr[0]=="O")
			{
				return this.player2;
			}
			else
			{
				return this.player1;
			}
		}
		else if(this.arr[2]==this.arr[4] && this.arr[4]==this.arr[6])
		{
			if(this.arr[2]=="O")
			{
				return this.player2;
			}
			else
			{
				return this.player1;
			}
		}
		else
		{
			return "";
		}
	}
}