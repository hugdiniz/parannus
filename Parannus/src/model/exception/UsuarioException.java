package model.exception;

public class UsuarioException extends Exception
{
	public UsuarioException() 
	{
		super();
	}
	public UsuarioException(String excecaoFrase) 
	{
		super(excecaoFrase);
	}
	public UsuarioException(Exception exception) 
	{
		super(exception.getMessage());
	}
	public UsuarioException(String excecaoFrase, Exception exception) 
	{
		super(excecaoFrase + "\n" +exception.getMessage());
	}
}
