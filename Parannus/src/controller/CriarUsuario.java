package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.enumerado.PerfilEnum;

@WebServlet("/CriarUsuario")
public class CriarUsuario extends Controller
{

	
	@Override
	protected void action(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		Gson gson = new Gson();
		
		request.setAttribute("tipos", gson.toJson(PerfilEnum.valores()));
		request.getRequestDispatcher("WEB-INF/criarUsuario.jsp").forward(request,response);
	}

}
