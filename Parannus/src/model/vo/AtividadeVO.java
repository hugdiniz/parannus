package model.vo;

import java.util.Date;

import model.entity.Usuario;

public class AtividadeVO
{
	private Date dataCriacao;
	private Date dataInicio;
	private Date dataFim;
	private Usuario usuario;
	
	
	public Date getDataCriacao()
	{
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao)
	{
		this.dataCriacao = dataCriacao;
	}
	public Date getDataInicio()
	{
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio)
	{
		this.dataInicio = dataInicio;
	}
	public Date getDataFim()
	{
		return dataFim;
	}
	public void setDataFim(Date dataFim)
	{
		this.dataFim = dataFim;
	}
		public Usuario getUsuario()
	{
		return usuario;
	}
	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}
	
}
