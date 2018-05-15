//name: Thomas Lay
//program: 3a
//description: This program takes the drop height, first bounce height, and number of allowed bounces of a ball.
//It then decides how many times it bounced, how high each bounce was, and the total vertical distance of the ball.
//test cases: 10 6 5, 20 1 8, 5 4 3
//assumption: The program calculates the correct answer for each test case.
package programming3;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class BouncingBall
{

	public static void main(String [] args) throws IOException
	{
		File inputFile = new File("bouncedata.txt");//finds the file
		Scanner file = new Scanner (inputFile);//reads the file
		double dropHeight = 0;//the three collected variables are set as 0
		double bounceHeight = 0;
		int bounceNumber = 0;
		int realBounceNumber = 0;// this counts the actual number of bounces
		
		while (file.hasNext())
		{
			dropHeight = file.nextInt();//sets the values for the three collected variables
			bounceHeight = file.nextInt();
			bounceNumber = file.nextInt();
			double totalDistance = dropHeight;//drop height is added to total distance once
			double bounceIndex = dropHeight / (double)bounceHeight;//finds the bounce index
			
			while (bounceHeight > .001 && bounceNumber > realBounceNumber)//the loop ends if the bounce height is too low, or if the bounce number is too high
			{
				totalDistance += (bounceHeight*2);//calculates the distance. multiplies bounce height by two to simulate rising and falling
				bounceHeight /= bounceIndex;//finds the new bounce height by dividing by the bounce index
				realBounceNumber++;//increments the bounce number for each bounce
				System.out.println("Bounce number: " + realBounceNumber + " Bounce Height: " + bounceHeight + " feet");
			}
		
		System.out.println("The ball bounced " + realBounceNumber + " times. It bounced a total distance of " + totalDistance + " feet.");
		realBounceNumber = 0;//sets the bounce number to zero for the next set
		}
			
	}

}

