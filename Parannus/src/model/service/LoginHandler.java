package model.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import model.dao.DAO;
import model.entity.Usuario;
import model.exception.LoginException;
import model.exception.ServiceException;
import model.exception.UsuarioException;
import model.vo.UsuarioVO;

public class LoginHandler
{
	private static LoginHandler loginHandler;
		
	public static LoginHandler getInstance()
	{
		if (loginHandler == null)
		{
			loginHandler = new LoginHandler();
		}
		return loginHandler;
	}
	
	public Collection recuperarUsuarios(UsuarioVO usuarioVO) throws LoginException
	{
		Collection usuarios = null;
		
		try
		{
			usuarios = DAO.getInstance().search(usuarioVO, Usuario.class);
		} catch (NoSuchMethodException | SecurityException	| IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			throw new LoginException("erro.login.handler.recuperar.usuarios.dao.search");			
		}
		return usuarios;
	}
	
	public Usuario recuperarUsuario(UsuarioVO usuarioVO) throws LoginException
	{
		Collection usuarios = recuperarUsuarios(usuarioVO);
		if (usuarios != null && !usuarios.isEmpty())
		{
			return (Usuario) usuarios.iterator().next();
		}
		return null;
	}
	
	public void manterUsuario(Usuario usuario) throws LoginException
	{
		try
		{
			DAO.getInstance().insertOrUpdate(usuario);
		}
		catch (ClassNotFoundException | SQLException e)
		{			
			e.printStackTrace();
			throw new LoginException("erro.login.handler.manter.usuarios.dao.insertOrUpdate");
		}
	}
	
	public void criarUsuario(UsuarioVO usuarioVO) throws  UsuarioException, LoginException
	{
		String senhaCriptografada = Usuario.validarCriptografarSenha(usuarioVO);		
		Usuario usuario = new Usuario(usuarioVO.getLogin(), senhaCriptografada,usuarioVO.getNome(),usuarioVO.getPerfil());
		
		UsuarioVO usuarioVOConsulta = new UsuarioVO();
		usuarioVOConsulta.setLogin(usuarioVO.getLogin());
		Usuario usuarioRecuperado = recuperarUsuario(usuarioVOConsulta);
		
		if (usuarioRecuperado != null)
		{
			throw new LoginException("erro.login.handler.ja.existe");
		}
		else
		{
			manterUsuario(usuario);
		}	
		
	}
	
	public Usuario Logar(UsuarioVO usuarioVO,HttpServletRequest request) throws LoginException
	{
		Usuario usuario = null;
		try
		{
			String senhaCriptografada = Usuario.validarCriptografarSenha(usuarioVO);
			usuarioVO.setSenha(senhaCriptografada);
			usuario = recuperarUsuario(usuarioVO);
		} 
		catch (LoginException | UsuarioException e)
		{
			e.printStackTrace();
			throw new LoginException("erro.login.handler.logar.recuperar.usuarios");
		}
		if (usuario != null)
		{
			request.getSession(true).setAttribute("usuario", usuario.toString());
			return usuario;
		}
		else
		{
			throw new LoginException("erro.login.handler.logar.erro.login.senha");
		}	
	}
	public void deslogar(HttpServletRequest request)
	{
			
		request.getSession(true).setAttribute("usuario",null);
					
	}
	
}
