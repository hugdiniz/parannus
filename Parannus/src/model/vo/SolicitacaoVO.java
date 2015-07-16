package model.vo;

import model.entity.abstractClass.*;

public class SolicitacaoVO extends VO
{
	private String sugestao = null;
	private String impacto = null;
	private String tipo = null;
	
	
	
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
		
	
}
