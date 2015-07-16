package model.service;

import java.sql.SQLException;
import java.util.Collection;

import model.dao.DAOSolicitacao;
import model.vo.AtividadeVO;
import model.vo.SolicitacaoVO;
import model.vo.UsuarioVO;
import sun.security.jca.GetInstance;

public class ServiceHandler {
	
	private static ServiceHandler serviceHandler;
	
	
	public static ServiceHandler getInstance()
	{
		if (serviceHandler == null) {
			serviceHandler = new ServiceHandler();
		}
		return serviceHandler;
	}
	
	
	public Collection recuperarAtividades(AtividadeVO atividadeVO)
	{
		return null;
	}
	
	public Collection recuperarSolicitacaos(SolicitacaoVO solicitacaoVO) throws ClassNotFoundException, SQLException
	{
		DAOSolicitacao daoSolicitacao = DAOSolicitacao.getInstance();
		return daoSolicitacao.recuperar(solicitacaoVO);
	}
	
	public Collection recuperarUsuarios(UsuarioVO solicitacaoVO)
	{
		return null;
	}

}
