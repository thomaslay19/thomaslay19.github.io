package game;

public class Scores
{
	protected int score;
	protected String name;
	
	public Scores()
	{
		score = 0;
		name = "";
	}
	
	public int getScore()
	{
		return score;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setScore(int newScore)
	{
		score = newScore;
	}
	
	public void setName(String newName)
	{
		name = newName;
	}
}
