package controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.exception.ServiceException;
import model.service.ServiceHandler;
import model.vo.SolicitacaoVO;

@WebServlet("/ConsultarSolicitacao")
public class ConsultarSolicitacao extends Controller
{
	private static final long serialVersionUID = 1L;
		
	@Override
	protected void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Collection solicitacaos = null;
		try
		{
			solicitacaos = ServiceHandler.getInstance().recuperarSolicitacaos(new SolicitacaoVO());
		}catch (ServiceException e)
		{
			e.printStackTrace();
		}
		
		request.setAttribute("solicitacaos", solicitacaos);
		request.getRequestDispatcher("WEB-INF/consultarSolicitacao.jsp").forward(request,response);
	}
}
