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
			String nome = usuario.getNome();
			request.setAttribute("usuarioNome", nome);
			action(request, response);
		}

	}
}
