package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.Solicitacao;
import model.entity.abstractClass.VO;
import model.exception.ServiceException;
import model.service.ServiceHandler;
import model.util.Util;
import model.vo.SolicitacaoVO;

@WebServlet("/CriarSolicitacao")
public class CriarSolicitacao extends Controller
{

	@Override
	protected void action(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{		
		Collection solicitacaos = new ArrayList();
		
		try
		{					
			String buscar = request.getParameter("criar");
			
			if(buscar != null && !buscar.equals(""))
			{
				
				
				String sugestao = null;
				String tipo = null;
				String impacto = null;
				
				
				if (request.getParameter("sugestao") != null  && !request.getParameter("sugestao").trim().equals(""))
				{
					sugestao = request.getParameter("sugestao").trim();
				}
				if (request.getParameter("impacto") != null  && !request.getParameter("impacto").trim().equals(""))
				{
					impacto = request.getParameter("impacto").trim();
				}
				if (request.getParameter("tipo") != null  && !request.getParameter("tipo").trim().equals(""))
				{
					tipo = request.getParameter("tipo").trim();
				}
				Solicitacao solicitacao = new Solicitacao(sugestao, impacto, tipo);
				
				ServiceHandler.getInstance().manterSolicitacao(solicitacao);
				request.getRequestDispatcher("ConsultarSolicitacao").forward(request,response);
			}
			else
			{
				request.getRequestDispatcher("WEB-INF/criarSolicitacao.jsp").forward(request,response);
			}	
			
		}
		catch (ServiceException e)
		{
			e.printStackTrace();
			request.getRequestDispatcher("WEB-INF/criarSolicitacao.jsp").forward(request,response);
		}
		
		
		
	}
	
}
