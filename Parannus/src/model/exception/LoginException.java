package model.exception;

public class LoginException extends Exception
{
	public LoginException() 
	{
		super();
	}
	public LoginException(String excecaoFrase) 
	{
		super(excecaoFrase);
	}
	public LoginException(Exception exception) 
	{
		super(exception.getMessage());
	}
	public LoginException(String excecaoFrase, Exception exception) 
	{
		super(excecaoFrase + "\n" +exception.getMessage());
	}
}
