package model.entity;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.dao.DAO;
import model.entity.abstractClass.Entity;
import model.exception.SolicitacaoException;
import model.vo.ObjetivoVO;



public class Solicitacao extends Entity
{

	private String sugestao;

	private String impacto;

	private String tipo;

	private Collection idOjetivos;
	private Collection objetivos = null;

	public Solicitacao(String sugestao,String impacto,String tipo)
	{
		this.sugestao = sugestao;
		this.impacto = impacto;
		this.tipo = tipo;
		this.idOjetivos = new ArrayList();
		//this.objetivo = objetivo;
		
	}
	
	public Solicitacao()
	{
		// TODO Auto-generated constructor stub
	}
	
	public Collection getObjetivos() throws SolicitacaoException
	{
		if (objetivos == null)
		{
			try
			{
				objetivos = new ArrayList();
				for (Long idObjetivo : (Collection<Long>)idOjetivos)
				{
					ObjetivoVO objetivoVO = new ObjetivoVO();
					objetivoVO.setId(idObjetivo);
					Objetivo objetivo = (Objetivo) DAO.getInstance().search(objetivoVO, Objetivo.class);
					objetivos.add(objetivo);
					
				}
			} 
			catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException| SQLException e)
			{				
				e.printStackTrace();
				throw new SolicitacaoException("erro.solicitacao.get.objetivo");
			}
		}
		return objetivos;
	}
	
	public void addObjetivo(Objetivo objetivo) throws SolicitacaoException
	{
		if (objetivos == null)
		{
			getObjetivos();
		}
		objetivos.add(objetivo);
		idOjetivos.add(objetivo);
	}

}
