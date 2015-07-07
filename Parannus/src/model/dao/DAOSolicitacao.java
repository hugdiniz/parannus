package model.dao;

import java.util.ArrayList;
import java.util.Collection;

import model.entity.Solicitacao;
import model.vo.SolicitacaoVO;
import sun.security.jca.GetInstance;

public class DAOSolicitacao
{
	private static DAOSolicitacao daoSolicitacao;
	
	
	public static DAOSolicitacao getInstance()
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
