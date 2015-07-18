package model.enumerado;
public enum StatusEnum
{

	CRIADO,

	INICIADO,

	EXECUTANDO,

	CONCLUIDO,

	ATRASADO,

	CANCELADO;
	
	
	public String toString() 
	{
		return this.name();		
	};
}
