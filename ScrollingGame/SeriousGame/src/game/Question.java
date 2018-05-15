package game;

public class Question
{
    protected String idNumber;
    protected String question;
    protected String aAnswer;
    protected String bAnswer;
    protected String cAnswer;
    protected String dAnswer;
    protected String rightAnswer;
	
    public Question() 
	{
		idNumber = "0";
		question = "q";
		aAnswer = "a";
		bAnswer = "b";
		cAnswer = "c";
		dAnswer = "d";
		rightAnswer = "r";
	}//constructor
    
    public String getIdNumber()
    {
    	return idNumber;
    }
    
    public String getQuestion()
    {
    	return question;
    }
    
    public String getAAnswer()
    {
    	return aAnswer;
    }
    
    public String getBAnswer()
    {
    	return bAnswer;
    }
    
    public String getCAnswer()
    {
    	return cAnswer;
    }
    
    public String getDAnswer()
    {
    	return dAnswer;
    }
    
    public String getRightAnswer()
    {
    	return rightAnswer;
    }
    
    public void setIdNumber(String id)
    {
    	idNumber = id;
    }
    
    public void setQuestion(String q)
    {
    	question = q;
    }
    
    public void setAAnswer(String a)
    {
    	aAnswer = a;
    }
    
    public void setBAnswer(String b)
    {
    	bAnswer = b;
    }
    
    public void setCAnswer(String c)
    {
    	cAnswer = c;
    }
    
    public void setDAnswer(String d)
    {
    	dAnswer = d;
    }
    
    public void setRightAnswer(String r)
    {
    	rightAnswer = r;
    }
}