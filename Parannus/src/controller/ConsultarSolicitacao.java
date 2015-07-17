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
public class ConsultarSolicitacao extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		action(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		action(request, response);
	}
	private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String acao = (String) request.getParameter("acaoListar");		
		if (acao == null) acao = "";		
		switch (acao) 
		{
			case "Criar":
				//request.getRequestDispatcher("CriarDepartamento").forward(request,response);
				
				break;
			case "Atualizar":
				//request.getRequestDispatcher("AtualizarDepartamento").forward(request,response);
				break;
			case "Ver":
				//request.getRequestDispatcher("VerDepartamento").forward(request,response);
				break;
			case "":
			default:
				Collection solicitacaos =	null;
				
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
}
