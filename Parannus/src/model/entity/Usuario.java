package model.entity;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import model.entity.abstractClass.Entity;
import model.enumerado.PerfilEnum;
import model.exception.UsuarioException;
import model.util.Constantes;
import model.vo.UsuarioVO;



public class Usuario extends Entity
{

	private String nome;
	private String login;
	private String senha;	
	private PerfilEnum perfil;
	
	public Usuario(String login,String senha,String nome,PerfilEnum perfilEnum)
	{
		this.nome = nome;
		this.senha = senha;
		this.perfil = perfilEnum;
		this.login = login;
	}
	
	public static String validarCriptografarSenha(UsuarioVO usuarioVO) throws UsuarioException
	{
		/**
		 * ValidacaoSenha
		 */
		String senha = usuarioVO.getSenha();
		String login = usuarioVO.getLogin();
		
		if (senha == null || senha.length() < Constantes.tamanhoMinimoSenha)
		{
			throw new UsuarioException("erro.usuario.senha.invalida");	
		}
		if (login == null || login.equals(""))
		{
			throw new UsuarioException("erro.usuario.login.invalido");	
		}
		
		
		
		/**
		 * Criptografia
		 */
		String senhaCriptografada = null;		
		MessageDigest m;
		try
		{
			m = MessageDigest.getInstance("MD5");
			m.update(senha.getBytes(),0,senha.length());
		    senhaCriptografada = new BigInteger(1,m.digest()).toString(16);
		    return senhaCriptografada;
		} 
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
			throw new UsuarioException("erro.usuario.criptografar.senha");			
		}
		
	    
	}
	
	public String getSenha()
	{
		return senha;
	}
	public String getNome()
	{
		return nome;
	}
	public String getLogin()
	{
		return login;
	}
	
}
