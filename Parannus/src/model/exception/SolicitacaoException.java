package model.exception;

public class SolicitacaoException extends Exception
{
	public SolicitacaoException() 
	{
		super();
	}
	public SolicitacaoException(String excecaoFrase) 
	{
		super(excecaoFrase);
	}
	public SolicitacaoException(Exception exception) 
	{
		super(exception.getMessage());
	}
	public SolicitacaoException(String excecaoFrase, Exception exception) 
	{
		super(excecaoFrase + "\n" +exception.getMessage());
	}
}
