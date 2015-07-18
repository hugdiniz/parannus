package model.vo;

import model.entity.abstractClass.VO;
import model.enumerado.PerfilEnum;

public class UsuarioVO extends VO
{
	private String login;
	private PerfilEnum perfil;
	private String senha;
	private String nome;
		
	public String getNome()
	{
		return nome;
	}
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	public String getSenha()
	{
		return senha;
	}
	public void setSenha(String senha)
	{
		this.senha = senha;
	}
	public String getLogin()
	{
		return login;
	}
	public void setLogin(String login)
	{
		this.login = login;
	}
	
	public PerfilEnum getPerfil()
	{
		return perfil;
	}
	public void setPerfil(PerfilEnum perfil)
	{
		this.perfil = perfil;
	}
}