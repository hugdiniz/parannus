package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.Usuario;

import com.google.gson.Gson;

public abstract class Controller extends HttpServlet
{
	protected abstract void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{				
		controllerAction(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		controllerAction(request, response);
		
	}
	
	private void controllerAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Gson gson = new Gson();
		Usuario usuario = null;
		if (request.getSession().getAttribute("usuario") != null && !request.getSession().getAttribute("usuario").equals(""))
		{
			usuario = gson.fromJson(request.getSession(true).getAttribute("usuario").toString(), Usuario.class);
		}		
		
		if (usuario == null)
		{
			request.getRequestDispatcher("LogarUsuario").forward(request,response);
		}
		else
		{
			adicionarUsuario(request, usuario);
			action(request, response);
		}

	}
	protected void adicionarUsuario(HttpServletRequest request,Usuario usuario)
	{
		String nome = usuario.getNome();
		request.setAttribute("usuarioNome", nome);
		request.setAttribute("perfil", usuario.getPerfil().name());
	}
	protected void adicionarMSGSucesso(HttpServletRequest request,String msg)
	{
		
		request.setAttribute("tipoMSG", "Sucesso");		
		request.setAttribute("msg",msg);
	}
	protected void adicionarMSGErro(HttpServletRequest request,String msg)
	{
		
		request.setAttribute("tipoMSG", "Erro");		
		request.setAttribute("msg",msg);
	}
}
