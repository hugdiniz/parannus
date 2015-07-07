package model.vo;

import model.entity.Perfil;
import model.entity.Solicitacao;

public class UsuarioVO
{
	private String nome;
	private String matricula;
	private Perfil perfil;
	private Solicitacao solicitacao;
	
	public String getNome()
	{
		return nome;
	}
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	public String getMatricula()
	{
		return matricula;
	}
	public void setMatricula(String matricula)
	{
		this.matricula = matricula;
	}
	public Perfil getPerfil()
	{
		return perfil;
	}
	public void setPerfil(Perfil perfil)
	{
		this.perfil = perfil;
	}
	public Solicitacao getSolicitacao()
	{
		return solicitacao;
	}
	public void setSolicitacao(Solicitacao solicitacao)
	{
		this.solicitacao = solicitacao;
	}
}
