package programming4;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.util.Scanner;
import java.io.*;

public class Grayscale extends JFrame
{

	public static void main( String [] args)
	{
		String direction;
		JFrame frame; 	// The frame for holding everything
		ImageIcon image; 	// The picture we will display
		JLabel imageLabel;// The picture label
		JScrollPane sp; 	// The scrolling pane will contain the label
					// that holds the picture
		PPMPicture PPMPicture = new PPMPicture("Finny.ppm");
		PPMPicture.setToGrayScale();
		PPMPicture.save("FinnyGray.ppm");
		PPMPicture.setToNegative();
		PPMPicture.save("FinnyNeg.ppm");
		PPMPicture Art = new PPMPicture("Finny.ppm");
		Art.setArtwork();
		Art.save("FinnyArt.ppm");
	}

}

