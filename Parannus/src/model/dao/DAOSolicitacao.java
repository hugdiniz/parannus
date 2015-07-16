package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import model.entity.Solicitacao;
import model.vo.SolicitacaoVO;
import sun.security.jca.GetInstance;

public class DAOSolicitacao extends DAO
{
	private static DAOSolicitacao daoSolicitacao;
	private DAOSolicitacao() throws ClassNotFoundException, SQLException 
	{
		super();		
	}
	
	public static DAOSolicitacao getInstance() throws ClassNotFoundException, SQLException
	{
		if (daoSolicitacao == null)
		{
			daoSolicitacao = new DAOSolicitacao();
		}
		return daoSolicitacao;
	}
	public  Collection recuperar(SolicitacaoVO solicitacaoVO)
	{
		Solicitacao solicitacao = new Solicitacao("bla","Nenhum","Inutil");
		Collection solicitacoes = new ArrayList();
		solicitacoes.add(solicitacao);
		return solicitacoes;
	}

}
