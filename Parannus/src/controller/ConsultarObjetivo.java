package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.Objetivo;
import model.entity.Solicitacao;
import model.entity.abstractClass.VO;
import model.exception.ServiceException;
import model.service.ServiceHandler;
import model.util.Util;
import model.vo.ObjetivoVO;
import model.vo.SolicitacaoVO;

@WebServlet("/ConsultarObjetivo")
public class ConsultarObjetivo extends Controller 
{

	@Override
	protected void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		
		Collection objetivos = null;
		Collection objetivosVOs = new ArrayList();
		
		try
		{					
			String buscar = request.getParameter("buscar");
			
			if(buscar != null && !buscar.equals(""))
			{
				ObjetivoVO objetivoVO = new ObjetivoVO();
				
				if (request.getParameter("descricao") != null  && !request.getParameter("descricao").trim().equals(""))
				{
					objetivoVO.setObjetivoNome(request.getParameter("descricao").trim());
				}
				
				
				objetivos = ServiceHandler.getInstance().recuperarObjetivos(objetivoVO);

				for (Objetivo objetivo : (Collection<Objetivo>)objetivos)
				{
					VO vo = Util.transformEntityToVO(objetivo,ObjetivoVO.class);
					objetivosVOs.add(vo);
				}			
			}
		}
		catch (ServiceException e)
		{
			e.printStackTrace();
		}
		
		request.setAttribute("objetivos", objetivosVOs);
		request.getRequestDispatcher("WEB-INF/consultarObjetivo.jsp").forward(request,response);
		
	}
	

}
