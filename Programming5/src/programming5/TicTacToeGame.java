package programming5;
import java.util.Scanner;
import java.util.Random;
import javax.swing.*;

public class TicTacToeGame
{
//the main method
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
		GameBoard board = new GameBoard();
		Random rand = new Random();
		boolean human = true;
		int x = 0;
		int y = 0;
		
		while(board.checkWin() != 'T' && board.checkWin() != 'O' && board.checkWin() != 'X')		
		{
		if (human)
		{
			board.showBoard();
			System.out.print("Put in x: ");
			x = scan.nextInt();
			System.out.print("Put in y: ");
			y = scan.nextInt();
			if (board.play(human, x, y) == false)
				System.out.println("Try a different spot.");
			else
				human = false;
			//the human plays
		}
		else
		{
			x = rand.nextInt(3);
			y = rand.nextInt(3);
			if (board.play(human, x, y))
			human = true;
			//the computer plays
		}
		//win conditions are checked for and acted upon
		board.checkWin(); 
		if (board.checkWin() == 'X')
		{
			board.showBoard();
			System.out.println("You win. " + board.validPlayCount() + " turns were taken this game.");
		}
		else if (board.checkWin() == 'O')
		{
			board.showBoard();
			System.out.println("You lose. " + board.validPlayCount() + " turns were taken this game.");
		}
		else if (board.checkWin() == 'T')
		{
			board.showBoard();
			System.out.println("Game goes to the cat. " + board.validPlayCount() + " turns were taken this game.");
		}
		else System.out.println("   ");
		
		}
	}

}
