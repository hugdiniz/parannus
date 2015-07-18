package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.Solicitacao;
import model.entity.abstractClass.Entity;
import model.entity.abstractClass.VO;
import model.exception.ServiceException;
import model.service.ServiceHandler;
import model.util.Util;
import model.vo.SolicitacaoVO;

@WebServlet("/ConsultarSolicitacao")
public class ConsultarSolicitacao extends Controller
{
	private static final long serialVersionUID = 1L;
		
	@Override
	protected void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Collection solicitacaos = null;
		Collection solicitacaoVOs = new ArrayList();
		
		try
		{					
			String buscar = request.getParameter("buscar");
			
			if(buscar != null && !buscar.equals(""))
			{
				SolicitacaoVO solicitacaoVO = new SolicitacaoVO();
				
				if (request.getParameter("sugestao") != null  && !request.getParameter("sugestao").trim().equals(""))
				{
					solicitacaoVO.setSugestao(request.getParameter("sugestao").trim());
				}
				if (request.getParameter("impacto") != null  && !request.getParameter("impacto").trim().equals(""))
				{
					solicitacaoVO.setImpacto(request.getParameter("impacto").trim());
				}
				if (request.getParameter("tipo") != null  && !request.getParameter("tipo").trim().equals(""))
				{
					solicitacaoVO.setTipo(request.getParameter("tipo").trim());
				}
				
				solicitacaos = ServiceHandler.getInstance().recuperarSolicitacaos(solicitacaoVO);

				for (Solicitacao solicitacao : (Collection<Solicitacao>)solicitacaos)
				{
					VO vo = Util.transformEntityToVO(solicitacao,SolicitacaoVO.class);
					solicitacaoVOs.add(vo);
				}			
			}
		}
		catch (ServiceException e)
		{
			e.printStackTrace();
		}
		
		request.setAttribute("solicitacaos", solicitacaoVOs);
		request.getRequestDispatcher("WEB-INF/consultarSolicitacao.jsp").forward(request,response);
	}
}
