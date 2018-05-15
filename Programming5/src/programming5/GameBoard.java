//ThomasLay
//Programming Assingment 5
//This code plays tic tac toe with the user
//The game can win lose and tie

package programming5;

public class GameBoard
{
	//an array showing the board
	private static char [][] board;
	//a counter for the plays
	private static int plays;
	//the constructor method
	public GameBoard()
	{
		board = new char [3][3];
		plays = 0;
		for(int row = 0; row < board.length; row++)
			for(int column = 0; column < board.length; column++)
				board[row][column] = ' ';
	}
	//this method places an x or o in a chosen location
	public boolean play(boolean x, int row, int column)
	{
		if (x)
		{
			if (board[row][column] == 'X' || board[row][column] == 'O')
			{
				return false;
			}//if (board[row][column] == 'X' || board[row][column] == 'O')
		else
		{
			board[row][column] = 'X';
			plays ++;
			return true;
		}//else
		}//if(x)
		else if (board[row][column] == 'X' || board[row][column] == 'O')
		{
			return false;
		}//else if
		else
		{
			board[row][column] = 'O';
			plays ++;
			return true;
		}//else
	}
	//an accessor method
	public int validPlayCount()
	{
		return plays;
	}
	
	public char checkWin()
	{
		//checks if x is the winner
		if (board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X')
			return 'X';
		else if (board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X')
			return 'X';
		else if (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X')
			return 'X';
		else if (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X')
			return 'X';
		else if (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X')
			return 'X';
		else if (board[1][0] == 'X' && board[1][1] == 'X' && board[2][1] == 'X')
			return 'X';
		else if (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X')
			return 'X';
		else if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X')
			return 'X';
		else if (board[2][0] == 'X' && board[1][1] == 'X' && board[0][2] == 'X')
			return 'X';
		//checks if o is the winner
		else if (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O')
			return 'O';
		else if (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O')
			return 'O';
		else if (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O')
			return 'O';
		else if (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O')
			return 'O';
		else if (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O')
			return 'O';
		else if (board[1][0] == 'O' && board[1][1] == 'O' && board[2][1] == 'O')
			return 'O';
		else if (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O')
			return 'O';
		else if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O')
			return 'O';
		else if (board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == 'O')
			return 'O';
		//checks for ties
		else if (board[0][0] != ' '
			&& board[1][0] != ' '
			&& board[2][0] != ' '
			&& board[0][1] != ' '
			&& board[1][1] != ' '
			&& board[2][1] != ' '
			&& board[0][2] != ' '
			&& board[1][2] != ' '
			&& board[2][2] != ' ')
			return 'T';
		else
			return ' ';
	}
	//shows the board
	public void showBoard()
	{
		System.out.println(board[0][0]+" | "+board[1][0]+" | "+board[2][0]);
		System.out.println("--+---+--");
		System.out.println(board[0][1]+" | "+board[1][1]+" | "+board[2][1]);
		System.out.println("--+---+--");
		System.out.println(board[0][2]+" | "+board[1][2]+" | "+board[2][2]);
	}
}
