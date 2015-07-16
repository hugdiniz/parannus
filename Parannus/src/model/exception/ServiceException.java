package model.exception;

public class ServiceException extends Exception
{
	public ServiceException() 
	{
		super();
	}
	public ServiceException(String excecaoFrase) 
	{
		super(excecaoFrase);
	}
	public ServiceException(Exception exception) 
	{
		super(exception.getMessage());
	}
	public ServiceException(String excecaoFrase, Exception exception) 
	{
		super(excecaoFrase + "\n" +exception.getMessage());
	}
}
