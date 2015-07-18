package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.Usuario;
import model.exception.LoginException;
import model.service.LoginHandler;
import model.vo.UsuarioVO;

@WebServlet("/LogarUsuario")
public class LogarUsuario extends Controller
{
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		action(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		action(request, response);
	}
	
	@Override
	protected void action(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{	
		String logar = (String) request.getParameter("logar");
		if (logar != null && logar.contains("Logar"))
		{
			String login = (String) request.getParameter("login");
			String senha = (String) request.getParameter("senha");
			UsuarioVO usuarioVO = new UsuarioVO();
			usuarioVO.setLogin(login);
			usuarioVO.setSenha(senha);
			
			try
			{
				Usuario usuario = LoginHandler.getInstance().Logar(usuarioVO,request);
				String nome = usuario.getNome();
				request.setAttribute("usuarioNome", nome);
				
				request.getRequestDispatcher("").forward(request,response);
				
			} 
			catch (LoginException e)
			{				
				e.printStackTrace();
				request.getRequestDispatcher("WEB-INF/logarUsuario.jsp").forward(request,response);
			}
		}
		else
		{
			request.getRequestDispatcher("WEB-INF/logarUsuario.jsp").forward(request,response);
		}	
		
	}	
}
