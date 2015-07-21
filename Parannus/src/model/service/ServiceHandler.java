package model.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import model.dao.DAO;
import model.entity.Objetivo;
import model.entity.Solicitacao;
import model.entity.Usuario;
import model.exception.ServiceException;
import model.exception.SolicitacaoException;
import model.vo.ObjetivoVO;
import model.vo.SolicitacaoVO;

public class ServiceHandler 
{
	
	private static ServiceHandler serviceHandler;
	
	
	public static ServiceHandler getInstance()
	{
		if (serviceHandler == null) 
		{
			serviceHandler = new ServiceHandler();
		}
		return serviceHandler;
	}	
	
	public Collection recuperarSolicitacaos(SolicitacaoVO solicitacaoVO) throws ServiceException
	{
		Collection solicitacaos = null;
		try
		{
			solicitacaos = DAO.getInstance().search(solicitacaoVO, Solicitacao.class);
		}
		catch (SQLException | ClassNotFoundException |NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
		{			
			e.printStackTrace();
			throw new ServiceException("erro.service.handler.recuperar.solicitacaos.dao.search");
		}
		return solicitacaos;
		
	}
	
	public Solicitacao recuperarSolicitacao(SolicitacaoVO solicitacaoVO) throws ServiceException
	{
		Collection solicitacaos = null;
		solicitacaos = recuperarSolicitacaos(solicitacaoVO);		
		if (solicitacaos != null && !solicitacaos.isEmpty())
		{
			return (Solicitacao) solicitacaos.iterator().next();
		}
		else
		{
			return null;
		}	
	}
	
	public void manterSolicitacao(Solicitacao solicitacao) throws ServiceException
	{
		try
		{
			Collection idObjetivos = new ArrayList();
			for (Objetivo objetivo : (Collection<Objetivo>)solicitacao.getObjetivos())
			{
				manterObjetivo(objetivo);
				ObjetivoVO objetivoVO = new ObjetivoVO();
				objetivoVO.setObjetivoNome(objetivo.getObjetivoNome());
				Objetivo objetivoRecuperado = ServiceHandler.getInstance().recuperarObjetivo(objetivoVO);
				idObjetivos.add(objetivoRecuperado.getId());
			}
			solicitacao.setIdOjetivos(idObjetivos);
		}
		catch (SolicitacaoException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try
		{
			DAO.getInstance().insertOrUpdate(solicitacao);
		}
		catch (ClassNotFoundException | SQLException e)
		{			
			e.printStackTrace();
			throw new ServiceException("erro.service.handler.manter.solicitacaos.dao.insertOrUpdate");
		}
	}
	

	public void manterObjetivo(Objetivo objetivo) throws ServiceException
	{
		try
		{
			DAO.getInstance().insertOrUpdate(objetivo);
		}
		catch (ClassNotFoundException | SQLException e)
		{			
			e.printStackTrace();
			throw new ServiceException("erro.service.handler.manter.solicitacaos.dao.insertOrUpdate");
		}
	}
	
	public Collection recuperarObjetivos(ObjetivoVO objetivoVO) throws ServiceException
	{
		Collection objetivos = null;
		try
		{
			objetivos = DAO.getInstance().search(objetivoVO, Objetivo.class);
		}
		catch (SQLException | ClassNotFoundException |NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
		{			
			e.printStackTrace();
			throw new ServiceException("erro.service.handler.recuperar.solicitacaos.dao.search");
		}
		return objetivos;
		
	}
	
	public Objetivo recuperarObjetivo(ObjetivoVO objetivoVO) throws ServiceException
	{
		Collection objetivos = null;
		objetivos = recuperarObjetivos(objetivoVO);		
		if (objetivos != null && !objetivos.isEmpty())
		{
			return (Objetivo) objetivos.iterator().next();
		}
		else
		{
			return null;
		}	
	}

	public void manterUsuario(Usuario usuario) throws ServiceException
	{
		try
		{
			DAO.getInstance().insertOrUpdate(usuario);
		}
		catch (ClassNotFoundException | SQLException e)
		{			
			e.printStackTrace();
			throw new ServiceException("erro.service.handler.manter.solicitacaos.dao.insertOrUpdate");
		}
		
	}

}
