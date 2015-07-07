package model.vo;

import model.entity.Objetivo;

public class SolicitacaoVO 
{
	private String sugestao;
	private String impacto;
	private String tipo;
	private Objetivo objetivo;
	public String getSugestao()
	{
		return sugestao;
	}
	public void setSugestao(String sugestao)
	{
		this.sugestao = sugestao;
	}
	public String getImpacto()
	{
		return impacto;
	}
	public void setImpacto(String impacto)
	{
		this.impacto = impacto;
	}
	public String getTipo()
	{
		return tipo;
	}
	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}
	public Objetivo getObjetivo()
	{
		return objetivo;
	}
	public void setObjetivo(Objetivo objetivo)
	{
		this.objetivo = objetivo;
	}
	
	
}
