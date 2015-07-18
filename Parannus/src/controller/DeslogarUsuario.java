package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.service.LoginHandler;

@WebServlet("/DeslogarUsuario")
public class DeslogarUsuario extends Controller
{

	@Override
	protected void action(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		LoginHandler.getInstance().deslogar(request);
		request.getRequestDispatcher("LogarUsuario").forward(request,response);

	}

}
