//Thomas Lay
//A Serious Game
//Task: to create a game that can be educational to grade school children.
package game;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class Game
{
  private Grid grid;
  private int userRow;
  private int msElapsed;
  private int timesGet;
  private int timesAvoid;
  private int timesRight;
  private String name;
  private String userGif = "submarine.gif";
  private String avoidGif = "shark.gif";
  private String getGif = "treasure.gif";
  private String emptyGif = null;
  ArrayList<Question> list = new ArrayList<Question>();
  //Heap() heap = new Heap();
  
  public Game()
  {
    //name = JOptionPane.showInputDialog("What is your name?");
	JLabel welcomeMessage = new JLabel();
	welcomeMessage.setFont (new Font ("Helvetica", Font.BOLD, 30) );   
    welcomeMessage.setText ("Collect the Treasure,\n " + "but don't hit three Sharks!");
    JOptionPane.showMessageDialog (null, welcomeMessage, "Submarine", JOptionPane.PLAIN_MESSAGE, null);
    grid = new Grid(5, 10);
    userRow = 0;
    msElapsed = 0;
    timesGet = 0;
    timesAvoid = 0;
    updateTitle();
    grid.setImage(new Location(userRow, 0), userGif);
  }
  
  public void loadQuestions()
  {
	  try
	  {
	  File file = new File("Questions.txt");
	  Scanner scan = new Scanner(file);
	  while (scan.hasNextLine())
	  {
		  String id = scan.nextLine();
		  String question = scan.nextLine();
		  String a = scan.nextLine();
		  String b = scan.nextLine();
		  String c = scan.nextLine();
		  String d = scan.nextLine();
		  String right = scan.nextLine();
		  Question quest = new Question();
		  quest.setIdNumber(id);
		  quest.setQuestion(question);
		  quest.setAAnswer(a);
		  quest.setBAnswer(b);
		  quest.setCAnswer(c);
		  quest.setDAnswer(d);
		  quest.setRightAnswer(right);
		  list.add(quest);
	  }//while
	  }catch(FileNotFoundException e)
	  {
		  JOptionPane.showMessageDialog (null, "The file was not found.", "error", JOptionPane.PLAIN_MESSAGE, null);
	  }
  }
  
  public boolean askQuestion()
  {
	  Question quest = new Question();
	  quest = list.remove(0);
	  String id = quest.getIdNumber();
	  String q = quest.getQuestion();
	  String a = quest.getAAnswer();
	  String b = quest.getBAnswer();
	  String c = quest.getCAnswer();
	  String d = quest.getDAnswer();
	  String r = quest.getRightAnswer();
	  Object [] candidates = {"A", "B", "C", "D"};
	  
	  int ans = JOptionPane.showOptionDialog(null, q+"\n A. "+ a + "\n B. " + b + "\n C. " + c + "\n D. " + d, id, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, candidates, candidates[0]);

	  String StringAnswer = (new Integer(ans+65)).toString();
	  
	  if(r.equals(StringAnswer))
		  return true;
	  else
		  return false;
  }
  
  public void play()
  {
	loadQuestions();
    while (!isGameOver())
    {
      grid.pause(100);
      handleKeyPress();
      if (msElapsed % 1000 == 0)
      {
        scrollLeft();
        populateRightEdge();
      }
      updateTitle();
      msElapsed += 100;
    }
  }
  
  public void handleKeyPress()
  {
	  int key = grid.checkLastKeyPressed();
	  grid.setImage(new Location(userRow, 0), emptyGif);
	  if (key == 38 && userRow > 0)
		  userRow--;
	  if (key == 40 && userRow < grid.getNumRows() - 1)
		  userRow++;
	  handleCollision(new Location(userRow, 0));
	  grid.setImage(new Location(userRow, 0), userGif);
  }
  
  public void populateRightEdge()
  {
	  for(int i = 0; i < grid.getNumRows(); i++)
	  {
	  if (Math.random() <= .1)// 1/3 chance to be get, avoid, or null
		  grid.setImage(new Location(i, grid.getNumCols() - 1), getGif);
	  else if (Math.random() <= .15)
		  grid.setImage(new Location(i, grid.getNumCols() - 1), avoidGif);
	  else if (Math.random() <= 1)
		  grid.setImage(new Location(i, grid.getNumCols() - 1), emptyGif);
	  }//for
  }//populateRightEdge
  
  public void scrollLeft()
  {
	  boolean user = false;
	  handleCollision(new Location(userRow, 1));
	  for(int i = 1; i < grid.getNumCols(); i++)
	  {
		  for(int j = 0; j < grid.getNumRows(); j++)
		  {
			  String scrollObj = grid.getImage(new Location(j, i-1));
			  if (scrollObj != emptyGif)
			  {
				  if(scrollObj.equals(userGif))
					  user = true;
			  }//if
			  if(user)
			  {
				  grid.setImage(new Location(j, i-1), grid.getImage(new Location(j, i)));
			  }//if
		  }//for j
	  }//for i
  }//scrollLeft
  
  
  public void handleCollision(Location loc)
  {
	  if (grid.getImage(loc) != emptyGif)
	  {
		  if(grid.getImage(loc).equals(avoidGif))
			  timesAvoid++;
		  if(grid.getImage(loc).equals(getGif))
		  {
			  timesGet++;
			  if(timesGet%3 == 0)
			  {
				  if(askQuestion() == true)
				  {
					  timesRight++;
					  JOptionPane.showMessageDialog (null, "Good Job!", "Question", JOptionPane.PLAIN_MESSAGE, null);
				  }
				  else
					  JOptionPane.showMessageDialog (null, "That's not it! You'll get the next one!", "Question", JOptionPane.PLAIN_MESSAGE, null);
			  }
		  }
		  if (!grid.getImage(loc).equals(userGif))
			  grid.setImage(loc, emptyGif);
	  }
  }
  
  public int getScore()
  {
    return timesRight;
  }
  
  public void updateTitle()
  {
    grid.setTitle("Score:  " + getScore() + " Sharks Hit: " + timesAvoid);
  }
  
  public boolean isGameOver()
  {
	  Scores scores = new Scores();
	  scores.setName(name);
	if (timesAvoid > 2)
	{
		scores.setScore(getScore());
		grid.closeFrame();
		JOptionPane.showMessageDialog (null, "You hit too many sharks, but you did get " + getScore() + " questions right. Try again!", "Submarine", JOptionPane.PLAIN_MESSAGE, null);
		Object [] candidates = {"Yes", "No"};
		int ans = JOptionPane.showOptionDialog(null, "Do you want to play again?", "Try again", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, candidates, candidates[0]);
		if(ans == 0)
			test();
		return true;
	}
	else if (timesGet > 59)
	{
		scores.setScore(getScore());
		grid.closeFrame();
		JOptionPane.showMessageDialog (null, "You got " + getScore() + " questions right out of 20.", "Submarine", JOptionPane.PLAIN_MESSAGE, null);
		Object [] candidates = {"Yes", "No"};
		int ans = JOptionPane.showOptionDialog(null, "Do you want to play again?", "Try again", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, candidates, candidates[0]);
		if(ans == 0)
			test();
		return true;
	}
    return false;
  }
  
  public static void test()
  {
    Game game = new Game();
    game.play();
  }
  
  public static void main(String[] args)
  {
    test();
  }
}