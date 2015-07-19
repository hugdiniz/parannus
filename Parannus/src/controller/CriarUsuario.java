package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.enumerado.PerfilEnum;
import model.exception.LoginException;
import model.exception.UsuarioException;
import model.service.LoginHandler;
import model.vo.UsuarioVO;

@WebServlet("/CriarUsuario")
public class CriarUsuario extends Controller
{

	@Override
	protected void action(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		Gson gson = new Gson();
		String criar = (String) request.getParameter("criar");
		request.setAttribute("tipos", gson.toJson(PerfilEnum.valores()));
		
		
		if (criar != null && criar.contains("Criar"))
		{
			String login = (String) request.getParameter("login");
			String senha = (String) request.getParameter("senha");
			String perfil = (String) request.getParameter("perfil");
			String nome = (String) request.getParameter("nome");
			UsuarioVO usuarioVO = new UsuarioVO();
			usuarioVO.setLogin(login);
			usuarioVO.setSenha(senha);
			usuarioVO.setNome(nome);
			usuarioVO.setPerfil(PerfilEnum.valueOf(perfil));
			
			try
			{
				LoginHandler.getInstance().criarUsuario(usuarioVO);				
				request.getRequestDispatcher("").forward(request,response);
				
			} 
			catch (LoginException e)
			{				
				e.printStackTrace();
				request.getRequestDispatcher("WEB-INF/criarUsuario.jsp").forward(request,response);
			} catch (UsuarioException e) 
			{				
				e.printStackTrace();
				request.getRequestDispatcher("WEB-INF/criarUsuario.jsp").forward(request,response);
			}
		}
		else
		{
			request.getRequestDispatcher("WEB-INF/criarUsuario.jsp").forward(request,response);
		}
		
		
		
		//request.getRequestDispatcher("WEB-INF/criarUsuario.jsp").forward(request,response);
	}

}
