///////////////////////////////////////////////////////////////////////////////
// Author:       DeClue                                                                          //
// Description:  The Picture class encapsulates a PPM picture.  currently,   //
//               there are three methods that need to be implemented.        //
///////////////////////////////////////////////////////////////////////////////
package programming4;

import java.util.Scanner;
import java.io.*;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class PPMPicture
{
    /////////// DATA MEMBERS /////////////
    private int [] pixels;          //An array to store the pixels
    private String firstLine;       //First line of the PPM file - "P3"
    private String secondLine;      //Second line of the PPM file - the comment
    int x, y;                       //Dimensions of the picture
    private String fourthLine;      //Fourth line of the PPM file - 255


    /////////// CONSTRUCTOR /////////////
    public PPMPicture (String fileName)
    //TASK: Read the PPM file into the array named pixels
    //PREcondition : fileName is the name of a PPM file
    //POScondition : pixels contains the RGB values for the fileName
    {
        int size; //size of the array
        try
        {
            //Create a scanner to read from the ppm file
            File inputFile = new File (fileName);
            Scanner picScanner = new Scanner (inputFile);
   
            if (picScanner.hasNext())//read the size of the array
            {
                firstLine = picScanner.nextLine(); //Read in the P3
                secondLine = picScanner.nextLine();// Read in the comment
                x = picScanner.nextInt();
                y = picScanner.nextInt();
                picScanner.nextLine();
                fourthLine = picScanner.nextLine();
                pixels = new int [x*y*3];           //width X height X 3 (RGB)
            }
            else //The file is empty
            {
                System.err.println("The file could not be found");
                return;
            }//else
   
            int location = 0;
            while (picScanner.hasNext())
            {
                pixels [location] = picScanner.nextInt();
                location++;
            }//while
        }//try
        catch (IOException e)
        {
            System.out.println (e.getStackTrace());
        }//catch
        return;
    }//Picture Class constructor

    public void save (String saveFileName)
    //TASK: This method will save the file as <saveFileName>.ppm
    //PRECondition: saveFileName must be in the form XYZ.ppm
    //POSCondition: none
    {
        try
        {
            FileWriter fw = new FileWriter(saveFileName);
            BufferedWriter bw = new BufferedWriter(fw);
           
            bw.write(firstLine); //Write the P3
            bw.newLine();
            bw.write(secondLine); //comment
            bw.newLine();
            bw.write (new Integer(x).toString()); //x
            bw.write (" ");
            bw.write (new Integer(y).toString()); //y
            bw.newLine();
            bw.write(fourthLine); //255
            bw.newLine();
           
            for (int i = 0; i < pixels.length; i++)
            {
                bw.write(new Integer(pixels[i]).toString());
                bw.newLine();
            }//for
            bw.close();
           
        }//try
        catch (IOException ioe)
        {
            ioe.printStackTrace();  
        }//catch
    }//save

    public void setToGrayScale()
    //TASK: This method changes the file to BW by averaging the RGB values
    //PRECondition:  pixels array contains the RGB values for a PPM file
    //POSTCondition: pixels array contains a grayScale version of the PPM file
    {
    	for (int i = 0; i < pixels.length; i+=3)
    	{
    		int red = pixels[i];
    		int green = pixels[i + 1];
    		int blue = pixels[i + 2];
    		int average = (red + green + blue) / 3;
    		pixels[i] = average;
    		pixels[i+1] = average;
    		pixels[i+2] = average;
    	}
               
    }//setToGrayScale

    public void setToNegative()
    //TASK: This method takes a gray scale image and produces a negative
    //PRECondition: pixels array contains a grayscale image of a PPM file
    //POSCondition: pixels contains a negative of the grayscale image
    {
    	for (int i = 0; i < pixels.length; i++)
    	{
    	    int negative = pixels[i];
    	    pixels[i] = 255 - negative;
    	}

       
       
       
    }//setToNegative
   
    public void setArtwork()
    //TASK: This method modifies the pixel array such that it contains digital art
    //PRECondition: pixels array contains a grayscale image of a PPM file
    //POSCondition: pixels array contains a modified, artistic image
    //             
    {
    	for (int i = 0; i < pixels.length; i+=3)
    	{
    	    pixels[i + 2] = pixels[i];
    	    
    	}

       
    }//myArtwork

   
}//Picture

    	