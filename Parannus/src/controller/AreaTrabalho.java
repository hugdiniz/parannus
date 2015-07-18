package controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DAO;
import model.entity.Solicitacao;
import model.exception.ServiceException;
import model.service.ServiceHandler;
import model.vo.SolicitacaoVO;

@WebServlet("")
public class AreaTrabalho extends Controller
{	
	private static final long serialVersionUID = 1L;
	
	
	protected void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
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
				request.getRequestDispatcher("WEB-INF/areaTrabalho.jsp").forward(request,response);			
		}
	}
}
