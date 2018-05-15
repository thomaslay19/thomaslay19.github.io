package programming3;

import java.awt.Dimension;	// So we can use Dimension objects

import javax.swing.*;		// JFrames, JScrollPanes, JLabels & ImageIcons

public class Claymation 
{
	public static void main(String[] args) 
	{
		////////  DECLARATIONS AND COMPONENTS   ///////
		String direction;
		JFrame frame; 	// The frame for holding everything
		ImageIcon image; 	// The picture we will display
		JLabel imageLabel;// The picture label
		JScrollPane sp; 	// The scrolling pane will contain the label
					// that holds the picture
		Integer Objecti = null; //An integer object
		
		////////          ALGORITHM              /////// 

//Create a dialog box that asks what direction the user would like to play the images
		direction = JOptionPane.showInputDialog
				("Would you like the photos to be played forwards or backwards?");
//Four pictures, so write a loop that executes four times\
		while (direction != "quit")
		{
		if (direction.equalsIgnoreCase ("forwards"))
		{
			for (int i = 1; i < 11; i++)
			{
				//Step 1: Create an Integer object from int i
				Objecti = new Integer(i);
				
				//Step 2: image is created as “1.jpg” “2.jpg” and so on
				image = new ImageIcon (Objecti.toString()+".jpg");
				
				//Step 3: Set up the Frame
				frame = new JFrame ("Building Picture");
				frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
			
				//Step 4: Show the picture
				imageLabel = new JLabel (image);
				sp = new JScrollPane (imageLabel);
				sp.setPreferredSize(new Dimension (400,400));
				frame.getContentPane().add(sp);
				frame.pack();
				frame.setVisible(true);
			
				//Step 5: Pause long enough to view the picture
				for (long j = 0; j < 100000000; j++);
			
			}//for
			direction = JOptionPane.showInputDialog
					("Would you like the photos to be played forwards or backwards?");
		}
		if (direction.equalsIgnoreCase ("backwards"))
		{
			for (int i = 10; i > 0; i--)
			{
				//Step 1: Create an Integer object from int i
				Objecti = new Integer(i);
				
				//Step 2: image is created as “1.jpg” “2.jpg” and so on
				image = new ImageIcon (Objecti.toString()+".jpg");
				
				//Step 3: Set up the Frame
				frame = new JFrame ("Building Picture");
				frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
			
				//Step 4: Show the picture
				imageLabel = new JLabel (image);
				sp = new JScrollPane (imageLabel);
				sp.setPreferredSize(new Dimension (400,400));
				frame.getContentPane().add(sp);
				frame.pack();
				frame.setVisible(true);
			
				//Step 5: Pause long enough to view the picture
				for (long j = 0; j < 100000000; j++);		
			}//for
			direction = JOptionPane.showInputDialog
					("Would you like the photos to be played forwards or backwards?");
		}
		}
	}
}
